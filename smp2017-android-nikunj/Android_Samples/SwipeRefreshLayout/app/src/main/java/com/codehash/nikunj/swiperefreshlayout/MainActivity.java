package com.codehash.nikunj.swiperefreshlayout;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter<String> arrayAdapter;
    private LinkedList<String> ln;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        ln=new LinkedList<>();
        for(int i=1;i<=15;i++)ln.add(String.valueOf(i));
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ln);
        list.setAdapter(arrayAdapter);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ln.add(0,"Demo");
                arrayAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }
}
