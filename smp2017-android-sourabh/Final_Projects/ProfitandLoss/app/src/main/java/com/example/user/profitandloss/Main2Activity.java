package com.example.user.profitandloss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {

    public EditText citem,icost,sprice;
    public String curitem,gst_rat,invco,salepr;

    public Spinner spinner;
    public int gstSel;
    public Button submit_gst;
    double rate,tax,investment,profit,sales,initialInvestment=0,initialSales=0,initialTax=0,initialProfit=0;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialise Firebase
        firebaseAuth = FirebaseAuth.getInstance();

        // Database Initialisation
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        spinner = (Spinner)findViewById(R.id.drop_down_menu);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gstSel = i;
                switch (i){
                    case 1: rate=0.0;
                            break;
                    case 2: rate=5.0;
                            break;
                    case 3: rate=12.0;
                            break;
                    case 4: rate=18.0;
                            break;
                    case 5: rate=28.0;
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Main2Activity.this,"Please Select GST Rate on Item",Toast.LENGTH_SHORT).show();
            }
        });

        citem = (EditText) findViewById(R.id.current_item);
        icost = (EditText) findViewById(R.id.investment);
        sprice = (EditText) findViewById(R.id.sales);



        submit_gst = (Button) findViewById(R.id.submit_gst);
        submit_gst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gstSel == 0 || curitem == "" || invco == "" || salepr == "") {
                    if(gstSel == 0)
                        Toast.makeText(Main2Activity.this,"Please Select GST Rate on Item",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Main2Activity.this,"All Data Required",Toast.LENGTH_SHORT).show();
                }
                else {
                    calculateTotal();
                    feedDetails();
                }
            }
        });
    }

    public void feedDetails() {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseUser.getUid();
        com.example.user.profitandloss.AllDetails ob = new com.example.user.profitandloss.AllDetails();
        ob.initialInvestment=initialInvestment;
        ob.initialSales=initialSales;
        ob.initialTax=initialTax;
        ob.initialProfit=initialProfit;
        databaseReference.child(uid).setValue(ob);
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
            tax = (investment * rate) / 100;
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
