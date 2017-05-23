package com.example.nikunj.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public int seconds,minutes,hours,secs;
    public boolean state;
    public Button start,stop,reset;
    public TextView time;
    public Toolbar toolbar;
    public ListView list;
    ArrayAdapter<String> ar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);
        list=(ListView)findViewById(R.id.list);
        setSupportActionBar(toolbar);
        reset=(Button)findViewById(R.id.reset);
        time=(TextView)findViewById(R.id.time);
        ar=new ArrayAdapter<String>(getApplicationContext(),R.layout.custom);
        list.setAdapter(ar);
        if(savedInstanceState!=null){
            seconds=savedInstanceState.getInt("seconds");
            state=savedInstanceState.getBoolean("state");
        }
        run();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!state){
                    state=true;
                }

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state=false;
            }
        });
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                state=false;
                seconds=0;
                time.setText("00:00:00");
                ar.clear();
            }
        });

    }
    public void onSaveInstanceState(Bundle savedinstancestate){
        savedinstancestate.putInt("seconds",seconds);
        savedinstancestate.putBoolean("state",state);
    }
    public void run(){

        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(state){
                hours=seconds/3600;
                minutes=(seconds%3600)/60;
                secs=seconds%60;
                String timelive=String.format("%02d:%02d:%02d",hours,minutes,secs);
                time.setText(timelive);}
                if(state){seconds++;handler.postDelayed(this,1000);}
                else handler.postDelayed(this,1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.setting){
            ar.add(time.getText().toString());
        }
        return true;
    }
}
