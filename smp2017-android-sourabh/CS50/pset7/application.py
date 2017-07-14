import sqlalchemy
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
app.jinja_env.globals.update(lookup=lookup)
# configure session to use filesystem (instead of signed cookies)
app.config["SESSION_FILE_DIR"] = mkdtemp()
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# configure CS50 Library to use SQLite database
#db = SQL("sqlite:///finance.db")

@app.route("/")
@login_required
def index():
    stock = db.execute('''SELECT users.cash as cash, stocks.stock as stock, sum(stocks.number) as num 
    FROM users INNER JOIN stocks ON users.id = stocks.id 
    where users.id = :id
    group by stocks.stock''', id = session["user_id"])
    if stock == []:
       stock = db.execute("select cash from users where id = :id",id = session["user_id"])
       nonedict = {"stock":"None","num":0}
       stock[0].update(nonedict)
    return render_template("index.html", items = stock)

@app.route("/buy", methods=["GET", "POST"])
@login_required
def buy():
    """Buy shares of stock."""
    if request.method == "GET":
        return render_template('buy.html')
    if request.method == "POST":
        try:
            name = str(request.form.get("stock"))
            quantity = request.form.get("number")
        except ValueError:
            return apology("Number only")
        stock = lookup(name)
        if stock == None:
            return apology("Stock doesnt exist")
        price_t = stock["price"] * int(quantity)
        cash = float(db.execute("SELECT cash FROM USERS WHERE id = :id",id=session["user_id"])[0]["cash"])
        if price_t>cash:
            return apology("Short of Cash")
        db.execute("INSERT INTO stocks('id','stock','price_bought','number') VALUES(:id,:stock,:price,:number)", id = session["user_id"], stock=stock['symbol'],price = stock['price'],number=quantity )
        db.execute("UPDATE users SET cash = :net where id = :id",id = session["user_id"],net = cash-price_t)
        return redirect(url_for("index"))
        
@app.route("/history")
@login_required
def history():
    """Show history of transactions."""
    rows = db.execute("SELECT stock as stock,price_bought as price, datetime_bought as date, number as num from stocks where id = :id",id = session["user_id"])
    bought = []
    sold = []
    for row in rows:
        if row['num'] < 0 :
            sold.append(row)
        else:
            bought.append(row)
            
    return render_template("history.html",bought = bought, sold=sold)

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
@login_required
def quote():
    """Get stock quote."""
    if request.method == "GET":
        return render_template("quote.html")
    if request.method == "POST":
        stock_name = request.form.get("stock")
        val = lookup(stock_name)
        if val==None:
            return apology("Not Available")
        return render_template("quoted.html", val=val)

@app.route("/register", methods=["GET", "POST"])
def register():
    if request.method == "POST":
        '''Input Validisation'''
        password = request.form.get("password")
        username = request.form.get("username")
        if username == '':
            return apology("Username cannot be blank")
        if password =='' or request.form.get('password2')=='':
            return apology('Password fields cant be blank')
        if password!= request.form.get('password2'):
            return apology('Password fields should match')
        unames = db.execute("SELECT username from users")
        if username not in unames:
            hashs  = pwd_context.encrypt(password)
            db.execute('INSERT INTO users (username , hash) VALUES (:username, :hashs)', username = username, hashs=hashs)
            return render_template("login.html")
    else:
        return render_template("register.html")    
    """Register user."""
        

@app.route("/sell", methods=["GET", "POST"])
@login_required
def sell():
    """Sell shares of stock."""
    if request.method == "GET":
        return render_template('sell.html')
    if request.method == "POST":
        try:
            name = request.form.get("stock")
            quantity = int(request.form.get("number"))
        except:
            return apology("Number only")
        stock_def = lookup(name)
        if stock_def == None:
            return apology("Stock doesnt exist")
        price_t = stock_def["price"] * int(quantity)
        stock = db.execute("SELECT sum(number) as number FROM stocks WHERE id = :id and stock = :symbol group by stock",id=session["user_id"],symbol=stock_def["symbol"])
        if stock ==[]:
            return apology("Stock not bought")
        number = stock[0]["number"]
        if number<quantity:
            return apology("Not enough stocks")
        db.execute("UPDATE users SET cash = cash + :net where id =:id",id = session["user_id"],net = price_t )
        db.execute("INSERT INTO stocks('id','stock','price_bought','number') VALUES (:id,:stock,:price,:num) ",id = session["user_id"], num = -quantity, stock = stock_def["symbol"], price = stock_def["price"])
        return redirect(url_for("index"))

@app.context_processor
def my_utility_processor():

    def look(sym):
        return lookup(symbol)

    return dict(look=look)
