package com.example.muskanchotrani.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.muskanchotrani.quiz.R;
import com.example.muskanchotrani.quiz.instructs;

import static com.example.muskanchotrani.quiz.R.layout.activity_instructs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start (View view)
    {
        Intent i = new Intent(this,instructs.class);
        startActivity(i);
        finish();
    }
}
