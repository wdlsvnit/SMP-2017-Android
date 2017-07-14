package com.example.user.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA=0,scoreB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayForTeamA(int score){
        TextView scoreView=(TextView)findViewById(R.id.team_a_score);
        scoreView.setText(""+score);
    }
    public void ashow1(View v){
        scoreA+=1;
        displayForTeamA(scoreA);
    }
    public void ashow2(View v){
        scoreA+=2;
        displayForTeamA(scoreA);
    }
    public void ashow3(View v){
        scoreA+=3;
        displayForTeamA(scoreA);
    }
    public void displayForTeamB(int score){
        TextView scoreView=(TextView)findViewById(R.id.team_b_score);
        scoreView.setText(""+score);
    }
    public void bshow1(View v){
        scoreB+=1;
        displayForTeamB(scoreB);
    }
    public void bshow2(View v){
        scoreB+=2;
        displayForTeamB(scoreB);
    }
    public void bshow3(View v){
        scoreB+=3;
        displayForTeamB(scoreB);
    }
    public void reset(View a){
        scoreA=scoreB=0;
        displayForTeamB(scoreB);
        displayForTeamA(scoreA);
    }
}
