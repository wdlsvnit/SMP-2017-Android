package com.example.muskanchotrani.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.order;
import static android.R.attr.x;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int x1=0;
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void threeA(View view) {
        x1+=3;
        displayForTeamA(x1);
    }
    public void twoA(View view) {
        x1+=2;
        displayForTeamA(x1);
    }
    public void oneA(View view) {
        x1+=1;
        displayForTeamA(x1);
    }
    int x2=0;
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void threeB(View view) {
        x2+=3;
        displayForTeamB(x2);
    }
    public void twoB(View view) {
        x2+=2;
        displayForTeamB(x2);
    }
    public void oneB(View view) {
        x2+=1;
        displayForTeamB(x2);
    }
    public void reset(View view) {
        x1=0;
        x2=0;
        displayForTeamA(x1);
        displayForTeamB(x2);
    }
}
