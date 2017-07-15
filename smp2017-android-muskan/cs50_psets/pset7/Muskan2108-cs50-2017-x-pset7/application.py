from cs50 import SQL
from flask import Flask, flash, redirect, render_template, request, session, url_for
from flask_session import Session
from passlib.apps import custom_app_context as pwd_context
from tempfile import mkdtemp

from helpers import *

# configure application
app = Flask(__name__)

# ensure responses aren't cached
if app.config["DEBUG"]:
    @app.after_request
    def after_request(response):
        response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
        response.headers["Expires"] = 0
        response.headers["Pragma"] = "no-cache"
        return response

# custom filter
app.jinja_env.filters["usd"] = usd

# configure session to use filesystem (instead of signed cookies)
app.config["SESSION_FILE_DIR"] = mkdtemp()
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# configure CS50 Library to use SQLite database
db = SQL("sqlite:///finance.db")
@app.route("/")
@login_required
def index():
    transactions = db.execute("SELECT * FROM history  WHERE userId = :userId", userId=session["user_id"])
    newTransactions = {}
    value = 0
    for transaction in transactions:
        if transaction["transType"]=="sell":
            transaction["quantity"]=transaction["quantity"]*-1
        if transaction["symbol"] in newTransactions:
            value += transaction["quantity"] * newTransactions[transaction["symbol"]]["price"]
            newTransactions[transaction["symbol"]]["quantity"] += transaction["quantity"]
            if newTransactions[transaction["symbol"]]["quantity"] == 0:
                del newTransactions[transaction["symbol"]]
            
        else:
            newTransactions[transaction["symbol"]] = transaction
            newTransactions[transaction["symbol"]]["price"] = lookup(transaction["symbol"])["price"]
            value += transaction["quantity"] * newTransactions[transaction["symbol"]]["price"]
    cash = db.execute("SELECT cash FROM users WHERE id = :userId", userId=session["user_id"])[0]["cash"]
    net = cash + value
    
    return render_template("portfolio.html", transactions=newTransactions, cash=usd(cash), net=usd(net))

@app.route("/buy", methods=["GET", "POST"])
@login_required
def buy():    
    if request.method == "GET":
        return render_template("buy.html")
    else:
        stock = lookup(request.form.get("stocks"))
        if not stock:
            return apology("Invalid Symbol")
        
        
        try:
            shares = int(request.form.get("number"))
            if shares < 0:
                return apology("Shares must be positive integer")
        except:
            return apology("Shares must be positive integer")
        
        
        money = db.execute("SELECT cash FROM users WHERE id = :id",
                            id=session["user_id"])
        
        
        if not money or float(money[0]["cash"]) < stock["price"] * shares:
            return apology("Not enough money")
                              
        rows=db.execute("SELECT * FROM users WHERE id= :id",id=session["user_id"])
        u=db.execute("UPDATE users SET cash = cash - :purchase WHERE id = :id",
                    id=session["user_id"], 
                    purchase=stock["price"] * float(shares))
        db.execute("INSERT INTO history (userId,transType,symbol,price,quantity) VALUES (:id,:t,:sym,:price,:quan)",id=session["user_id"],t="buy",sym=stock["symbol"],price=stock["price"],quan=shares)
                        
        return redirect(url_for("index"))

@app.route("/history")
@login_required
def history():
        transactions = db.execute("SELECT * FROM history  WHERE userId = :userId", userId=session["user_id"])
        return render_template("history.html",transactions=transactions)

@app.route("/login", methods=["GET", "POST"])
def login():
    """Log user in."""

    # forget any user_id
    session.clear()

    # if user reached route via POST (as by submitting a form via POST)
    if request.method == "POST":

        # ensure username was submitted
        if not request.form.get("username"):
            return apology("must provide username")

        # ensure password was submitted
        elif not request.form.get("password"):
            return apology("must provide password")

        # query database for username
        rows = db.execute("SELECT * FROM users WHERE username = :username", username=request.form.get("username"))

        # ensure username exists and password is correct
        if len(rows) != 1 or not pwd_context.verify(request.form.get("password"), rows[0]["hash"]):
            return apology("invalid username and/or password")

        # remember which user has logged in
        session["user_id"] = rows[0]["id"]

        # redirect user to home page
        return redirect(url_for("index"))

    # else if user reached route via GET (as by clicking a link or via redirect)
    else:
        return render_template("login.html")

@app.route("/logout")
def logout():
    """Log user out."""

    # forget any user_id
    session.clear()

    # redirect user to login form
    return redirect(url_for("login"))

@app.route("/quote", methods=["GET", "POST"])
def quote():

	session.clear()

    
	if request.method == "POST":

       
		if not request.form.get("symbol"):
           
			return apology("Enter a symbol")

             
		row =lookup(request.form.get("symbol"))

 
		if row == None:
			return apology("Invalid symbol")            
		return render_template("quoted.html", name=row["name"], symbol=row["symbol"], price=usd(row["price"]))
	else:
        
		return render_template("quote.html")



@app.route("/register", methods=["GET", "POST"])
def register():
    session.clear()
    if request.method == "POST":
        if not request.form.get("username"):
            return apology("username cannot be blank")
        if not request.form.get("password"):
            return apology("Password is required")
        elif request.form.get("password") != request.form.get("confirm password"):
            return apology(" passwords should match")
        
        result=db.execute("INSERT INTO users (username,hash) VALUES (:username, :hash)", username=request.form.get("username"),hash=pwd_context.encrypt(request.form.get("password")))
        if not result:
            return apology("Cannot register")
        session["user_id"]=result
        return redirect(url_for("index"))
    else :
        return render_template("register.html")

        

@app.route("/sell", methods=["GET", "POST"])
@login_required
def sell():
    if request.method == "GET":
        return render_template("sell.html")
    else:
        stock = lookup(request.form.get("stocks"))
        if not stock:
            return apology("Invalid Symbol")
        
        
        try:
            shares = int(request.form.get("number"))
            if shares < 0:
                return apology("Shares must be positive integer")
        except:
            return apology("Shares must be positive integer")
        myshare=db.execute("SELECT quantity FROM history WHERE userId=:id",id=session["user_id"])
        if not myshare or int(myshare[0]["quantity"])<shares:
            return apology("Not enough shares")
        db.execute("INSERT INTO history (userId,transType,symbol,price,quantity) VALUES (:id,:type,:sym,:price,:quan)",id=session["user_id"],type="sell",sym=stock["symbol"],price=stock["price"],quan=shares)
        db.execute("UPDATE users SET cash=cash+:add WHERE id=:id",add=float(shares)*stock["price"],id=session["user_id"])

        return redirect(url_for("index"))
        
@app.route("/add", methods=["GET", "POST"])
@login_required
def add():
    if request.method == "POST":
        c=int(request.form.get("cash"))
        if c<0:
            return apology("Money cannot be negative")
        db.execute("UPDATE users SET cash=cash+:mon WHERE id=:id",mon=c,id=session["user_id"])
        return redirect(url_for("index"))
    else:
        return render_template("add.html")