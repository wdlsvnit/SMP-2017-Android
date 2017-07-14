package com.example.muskanchotrani.quiz;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.muskanchotrani.quiz.MainActivity;
import com.example.muskanchotrani.quiz.R;
import com.example.muskanchotrani.quiz.edittext;

import static com.example.muskanchotrani.quiz.R.id.score;

public class summary extends AppCompatActivity {
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("stuff");
        data= edittext.getActivityInstance().getData();
        TextView score = (TextView) findViewById(R.id.get_score);
        score.setText(stuff);
        TextView text_score = (TextView) findViewById(R.id.show_name);
        text_score.setText("Hey "+data);

    }
    public void restart(View view)
    {
        Intent inte = new Intent(this,MainActivity.class);
        startActivity(inte);
    }
    public void exit(View view)
    {
        finish();
    }
}
