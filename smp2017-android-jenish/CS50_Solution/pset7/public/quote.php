<?php>

    require("../incudes/config.php");
    
    if($_SEVER["REQUEST_METHOD"] == "POST")
    {
        if(empty($_POST["symbol"]))
        {
            apologize("You must provide a symbol");
        }
        
        $slock= lookup($_POST["symbol"]);
        
        if(count($stock) == 3)
        {
           render("quote_result.php", ["title" => "Quote", "stock" => $stock]);
        }
        else
        {
            apologize("Stock not found.");
        }
    
    }
    else
    {
        render("quote_form.php", ["title" => "Quote"]);
    }

<?>