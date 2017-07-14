package com.example.android.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int basePrice=15;
        CheckBox whipped_check_box=(CheckBox)findViewById(R.id.whipped_check);
        boolean hasWhippedCream=whipped_check_box.isChecked();
        CheckBox choco_check_box=(CheckBox)findViewById(R.id.chocolate_check);
        boolean hasChoco=choco_check_box.isChecked();
        if(hasWhippedCream)
            basePrice+=5;
        if(hasChoco)
            basePrice+=10;
        int price =quantity*basePrice;
        display(quantity);
        createOrderSummary(price,hasWhippedCream,hasChoco);
    }
    private void createOrderSummary(int price,boolean hasWhippedCream,boolean hasChoco){
        EditText textView=(EditText)findViewById(R.id.Name);
        String Name= textView.getText().toString();
        String message="Name: "+Name;
        String subject="Just Java Summary For "+Name;
        if(hasWhippedCream||hasChoco)
        {
            message+="\nToppings:";
            if(hasWhippedCream)
                message+="Whipped Cream";
            if(hasChoco) {
                if (hasWhippedCream)
                    message += "\n\t\t\t\t\t\t ";
                message += "Chocolate";
            }
        }
        message+="\nQuantity: "+quantity;
        message+="\nTotal Amount: "+NumberFormat.getCurrencyInstance().format(price);
        message+="\nThank You !";
        emailSummary(message,subject);
    }
    public void increment(View view){
        if(quantity<100)
        quantity+=1;
        else
            Toast.makeText(this,"You cannot order more than 100 cups",Toast.LENGTH_SHORT).show();
        display(quantity);
    }

    public void decrement(View view){
        if(quantity>1)
            quantity-=1;
        else
            Toast.makeText(this,"You cannot order less than 1 cup",Toast.LENGTH_SHORT).show();
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on screen
     */
    private void emailSummary(String message,String subject)
    {
        Intent intentEmail=new Intent(Intent.ACTION_SENDTO);
        intentEmail.setData(Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_TEXT,message);
        intentEmail.putExtra(Intent.EXTRA_SUBJECT,subject);
        if(intentEmail.resolveActivity(getPackageManager())!=null){
            startActivity(intentEmail);
        }
        else
        {
            Toast.makeText(this,"You have no Email Apps",Toast.LENGTH_SHORT).show();
        }
    }

}
