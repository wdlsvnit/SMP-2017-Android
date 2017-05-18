package com.nik1010.vac13;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberofCofees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        String message = "$"+(numberofCofees*5);
        displayMessage(message);
    }
    public void increment(View view){
        numberofCofees++;
        display(numberofCofees);

    }
    public void decrement(View view){
        if(numberofCofees>0){numberofCofees--;
        display(numberofCofees);}

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayMessage(String message)
    {
        TextView priceText = (TextView)findViewById(R.id.price_text_view);
        priceText.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number)
    {
        TextView priceText=(TextView)findViewById(R.id.price_text_view);
        priceText.setText(NumberFormat.getCurrencyInstance().format(number));

    }
}