package com.example.android.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
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
        String message="Thank You";
        display(quantity);
        displayPrice(quantity*5,message);
    }
    public void increment(View view){
        quantity+=1;
        display(quantity);
    }
    public void decrement(View view){
        if(quantity>0)
            quantity-=1;
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
    private void displayPrice(int number,String message)
    {
        TextView priceTextview= (TextView)findViewById(R.id.price_text_view);
        priceTextview.setText(NumberFormat.getCurrencyInstance().format(number)+"\n"+message);
    }

}
