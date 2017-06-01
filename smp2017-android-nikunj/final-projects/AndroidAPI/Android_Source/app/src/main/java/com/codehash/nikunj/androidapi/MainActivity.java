package com.codehash.nikunj.androidapi;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements dialogLayout.POSTdata {
    public ListView list;
    public LinkedList<String> str;
    public ArrayAdapter<String> arrayAdapter;
    public HttphandlerGET httphandler;
    public StrictMode.ThreadPolicy threadPolicy;
    public FloatingActionButton fab;
    public DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        list = (ListView) findViewById(R.id.list);
        str = new LinkedList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        httphandler = new HttphandlerGET();


        list.setAdapter(arrayAdapter);

        arrayAdapter.setNotifyOnChange(true);
        try {
            JSONparser(httphandler.makeService("http://192.168.1.103/practice/get.php"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        Log.i("main", str.toString());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment = new dialogLayout();
                dialogFragment.show(getFragmentManager(), "TAG");

            }
        });


    }

    public void JSONparser(String JsonString) throws Exception {
        JSONObject jsonObject = new JSONObject(JsonString);
        if (jsonObject.getInt("success") == 1) {
            JSONArray jsonDetails = jsonObject.getJSONArray("details");
            for (int i = 0; i < jsonDetails.length(); i++) {
                JSONObject temp = jsonDetails.getJSONObject(i);
                str.add(temp.getString("namez"));
            }
        }

    }


    @Override
    public void postData(String name, String description)  {
        HttphandlerPOST httphandlerPOST=new HttphandlerPOST();
        try{
            Log.i("main",httphandlerPOST.postService("http://192.168.1.103/practice/post.php",name,description));
            str.add(name);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
