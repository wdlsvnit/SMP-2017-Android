package com.codehash.nikunj.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public ArrayList<Item> src=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.list);
        for(int i=0;i<10;i++)
        {
            src.add(new Item("Nikunj","Author"));
            src.add(new Item("Hacker","I am everything."));
        }
        customListViewAdapter customAdapter = new customListViewAdapter(this,src);
        listView.setAdapter(customAdapter);
    }
}
