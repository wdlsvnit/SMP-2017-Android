package com.codehash.nikunj.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public ListView list;
    public ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        String[] src={"Nikunj","Vedansh","Mahek","SaiKrishna","Mohit","Vishnu","Ashutosh","Noel","Aakash","Ajay","Abhishek","Shaishav"};
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,src);
        list.setAdapter(arrayAdapter);
    }
}
