/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

package com.example.android.justjava;

import com.example.android.justjava.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

import static android.R.attr.orderingFromXml;
import static android.R.attr.x;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText namef=(EditText) findViewById(R.id.name_field);
        String name=namef.getText().toString();
        CheckBox haswhc =(CheckBox) findViewById(R.id.checkboxclick);
        CheckBox hasch=(CheckBox) findViewById(R.id.cck);
        boolean haswc=haswhc.isChecked();
        boolean haschoco=hasch.isChecked();
        int price=calculateprice(haswc,haschoco);
       String message=createOrderSummary(name,price,haswc,haschoco);
        displayMessage(message);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    private int calculateprice(boolean  haswc,boolean haschoco)
    {  boolean haswcc=haswc;
        boolean  haschocol=haschoco;
        int baseprice=5;
        if(haswcc)
            baseprice+=1;
        if(haschocol)
            baseprice+=2;

        int price=baseprice*quantity;
        return price;

    }
    private String createOrderSummary(String name,int price,boolean haswc,boolean haschoco)
    {
        String mess="Name: "+name+" \n Has Whipped Cream :"+haswc+ "\nHas Chocolate :"+haschoco+"\nQuantity = "+quantity+"\nTotal  $ ="+price+"\n Thank You!";
        return mess;
    }
    public void increment(View view) {
         quantity++;
        display(quantity);

    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
         quantity--;
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
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(message);
    }
}