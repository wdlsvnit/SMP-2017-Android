package com.example.user.profitloss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    float value,tax,investment,profit,sales,initialInvestment=0,initialSales=0,initialTax=0,initialProfit=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = (Spinner)findViewById(R.id.drop_down_menu);
        adapter = ArrayAdapter.createFromResource(this, R.array.country_gst_rates, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String valueString = getResources().getStringArray(R.array.gst_rates)[position - 1];
                try {
                    value = Float.valueOf(valueString);
                } catch(NumberFormatException e) {
                    Toast.makeText(Main2Activity.this,"Please Select GST Rate on Item",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Main2Activity.this,"Please Select GST Rate on Item",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void calculateTotal(){
        EditText invest=(EditText)findViewById(R.id.investment);
        EditText saleview=(EditText)findViewById(R.id.sales);
        EditText item=(EditText)findViewById(R.id.current_item);
        String currentItem=item.getText().toString();
        if(currentItem=="")
            Toast.makeText(Main2Activity.this,"Current Item Name Field cannot be Empty",Toast.LENGTH_SHORT).show();
        else {
            String invest1 = invest.getText().toString();
            investment = Float.valueOf(invest1);
            String invest2 = saleview.getText().toString();
            sales = Float.valueOf(invest2);
            tax = (investment * value) / 100;
            profit = sales - (investment + tax);
            TextView investView = (TextView) findViewById(R.id.invest_text_view);
            TextView earnView = (TextView) findViewById(R.id.earn_text_view);
            TextView taxView = (TextView) findViewById(R.id.tax_text_view);
            TextView profitView = (TextView) findViewById(R.id.profit_text_view);
            initialInvestment += investment;
            initialSales += sales;
            initialTax += tax;
            initialProfit += profit;
            investView.setText("Total Amount Invested: " + NumberFormat.getCurrencyInstance().format(initialInvestment));
            earnView.setText("Total Amount Earned: " + NumberFormat.getCurrencyInstance().format(initialSales));
            taxView.setText("Total Tax Deployed: " + NumberFormat.getCurrencyInstance().format(initialTax));
            profitView.setText("Net Profit: " + NumberFormat.getCurrencyInstance().format(initialProfit));
            Toast.makeText(Main2Activity.this, "Record Saved for" + currentItem, Toast.LENGTH_SHORT).show();
        }
    }
}