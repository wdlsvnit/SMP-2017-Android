package com.example.muskanchotrani.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muskanchotrani.quiz.R;
import com.example.muskanchotrani.quiz.quiz;

import static android.R.attr.duration;
import static android.os.Build.VERSION_CODES.N;
import static java.lang.Integer.parseInt;

public class edittext extends AppCompatActivity {
    static edittext INSTANCE;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        INSTANCE=this;
    }

    public void next(View view) {
        String name = "";
        EditText names = (EditText) findViewById(R.id.name);
        name = names.getText().toString();
        String age = "";
        EditText ages = (EditText) findViewById(R.id.age);
        age = ages.getText().toString();
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = null;
        Toast toast=null;
        if ((name.isEmpty()) && (age.isEmpty())) {
            text= "First name and age is required!";
            toast = Toast.makeText(context, text, duration);
            toast.show();
            // names.setError("First name and age required!");
        } else if (name.isEmpty()) {
            text = "First name is required!";
            toast = Toast.makeText(context, text, duration);
            toast.show();
            // names.setError("First name is required!");
        } else if (age.isEmpty()) {
            text = "Age is required!";
            toast = Toast.makeText(context, text, duration);
            toast.show();
//            ages.setError("Age is required!");
        }  else {
            Intent i = new Intent(getApplicationContext(), quiz.class);
            data=name;
            startActivity(i);
            finish();
        }

    }
    public static edittext getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        return this.data;
    }
}

