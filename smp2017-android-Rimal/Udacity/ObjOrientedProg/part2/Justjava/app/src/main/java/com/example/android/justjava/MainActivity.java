/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    int price = 0;
    String out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void add(View view) {
        if (quantity==100)
            Toast.makeText(this,"You cannot have more than 100 cups of coffees...",Toast.LENGTH_SHORT).show();
        if (quantity<100)
        quantity = quantity + 1;
        dq(quantity);
    }

    public void subtract(View view) {
        if (quantity==1)
            Toast.makeText(this,"You should atleast have a cup of coffee...",Toast.LENGTH_SHORT).show();
        if (quantity>1)
        quantity = quantity - 1;
        dq(quantity);
    }

    public void submitOrder(View view) {
        CheckBox WhippedCream=(CheckBox) findViewById(R.id.wcheckbox);
        CheckBox chocolate=(CheckBox) findViewById(R.id.ccheckbox);

        EditText name=(EditText) findViewById(R.id.name_edit);
        String cusname=name.getText().toString();

        String subject="Justjava order for " + cusname ;

        boolean haveWhippedCream= WhippedCream.isChecked();
        boolean choco=chocolate.isChecked();
        calculatePrice(haveWhippedCream , choco);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary(price , haveWhippedCream, choco , cusname ) );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */

    private int calculatePrice(boolean cream , boolean chocolate) {
        if( cream==true && chocolate==false)
        price = quantity * 15;
        else if (cream==false && chocolate==true)
            price = quantity * 20;
        else if (chocolate==true && cream==true)
            price = quantity * 25;
        else
            price = quantity * 10;
        return price;
    }

    private String orderSummary(int price , boolean topping1 , boolean topping2 , String name) {
        boolean haveWhippedCream=true;
        out = name + "\nQuantity: " + quantity +"\nAdded whipped cream:"+ topping1
                + "\nAdded chocolate: " + topping2 + "\nPrice: Rs." + price + "\nThank You!";
        return out;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void dq(int no) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + no);
    }
    /**
     * This method displays the given price on the screen.
     */
}
