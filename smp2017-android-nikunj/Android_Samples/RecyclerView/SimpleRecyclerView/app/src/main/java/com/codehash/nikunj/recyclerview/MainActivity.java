package com.codehash.nikunj.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<recycleData> src;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycle);
        src=recycleData.createList(15);
        recyclerViewAdapter recyclerViewadapter=new recyclerViewAdapter(this,src);
        recyclerView.setAdapter(recyclerViewadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
