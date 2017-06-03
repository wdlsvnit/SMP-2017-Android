package com.codehash.nikunj.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public ListView list;
    public CustomListAdapter customListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        String[] str={"Nikunj","Vedansh","Mahek","SaiKrishna","Mohit","Vishnu","Ashutosh","Noel","Aakash","Ajay","Abhishek","Shaishav"};
        customListAdapter=new CustomListAdapter(this,str);
        list.setAdapter(customListAdapter);
    }
}
