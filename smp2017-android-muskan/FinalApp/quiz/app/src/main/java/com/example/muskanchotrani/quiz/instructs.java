package com.example.muskanchotrani.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.muskanchotrani.quiz.R;
import com.example.muskanchotrani.quiz.edittext;

import java.text.NumberFormat;
import static android.R.attr.value;
import static android.R.attr.x;

public class instructs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructs);
    }
    public void enter (View view)
    {
        Intent i =new Intent(this,edittext.class);
        startActivity(i);
        finish();
    }
}
