<?php
    
    require("../includes/config.php");
    
    
    if ($_SERVER["REQUEST_METHOD"] == "POST")
    {
        
        if (empty($_POST["symbol"]))
        {
            apologize("You must select a symbol.");
        }
        
        
        $stock = lookup($_POST["symbol"]);
        
        
        $positions = query("SELECT * FROM portfolio WHERE id = ? AND symbol = ?", $_SESSION["id"], $_POST["symbol"]);
        
        
        query("DELETE FROM portfolio WHERE id = ? AND symbol = ?", $_SESSION["id"], $_POST["symbol"]);
        
        
        $credit = $stock["price"] * $positions[0]["shares"];
        
        
        query("UPDATE users set cash = cash + ? WHERE id = ?", $credit, $_SESSION["id"]);
        
        logSell($stock["symbol"], $positions[0]["shares"], $stock["price"]);
        
        
        redirect("index.php");
    }
    else
    {
        
        $positions = query("SELECT * FROM portfolio WHERE id = ?", $_SESSION["id"]);
        render("sell_form.php", ["title" => "Sell", "positions" => $positions]);
    }
?>