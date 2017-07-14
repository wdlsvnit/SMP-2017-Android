package com.example.muskanchotrani.justjava;

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
import static android.R.attr.value;
import static android.R.attr.x;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.muskanchotrani.justjava.R.id.price;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int x=1;
    public void minus(View view) {
        if(x==1)
        {
            Toast.makeText(this,"You cannot order less than one coffee",Toast.LENGTH_SHORT).show();
            return; }
        x--;
        display(x);
    }
    public void plus(View view) {
        if(x==100)
        {    Toast.makeText(this,"You cannot order more than hundred coffees",Toast.LENGTH_SHORT).show();
            return; }
        x++;
        display(x);
    }
    public void submitOrder(View view) {
        int price;
        String name;
        EditText names =(EditText) findViewById(R.id.name);
        name = names.getText().toString();
        CheckBox checkbox = (CheckBox) findViewById(R.id.cream);
        boolean whippedCream=checkbox.isChecked();
        CheckBox check = (CheckBox) findViewById(R.id.chocolate);
        boolean addchocolate =check.isChecked();
        price=calculatePrice(x,addchocolate,whippedCream);
        String s=createOrderSummary(price,whippedCream,addchocolate,name);
        displayMessage(s);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "www.muskanyhms@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffees ordered for "+name);
        intent.putExtra(Intent.EXTRA_TEXT,s);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        display(x);
    }
    private int calculatePrice(int t, boolean ch, boolean wh)
    {
        if(ch&&wh)
        {   return(t*8);    }
        else if(ch)
        {   return(t*7);    }
        else if(wh)
        {   return(t*6);    }
        return(t*5);
    }

    private void display(int number) {
        TextView figureTextView = (TextView) findViewById(
                R.id.figure);
        figureTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.cost);
        priceTextView.setText(message);
    }
    private String createOrderSummary(int price, boolean whippedCream, boolean chocolate,String name)
    {
        String s;
        s="Name:"+name+"\n"+"Quantity: "+x+"\nAdd Whipped Cream?"+whippedCream+"\nAdd Chocolate?"+chocolate+"\nTotal: "+price+"\nThankyou";
        return(s);
    }
}