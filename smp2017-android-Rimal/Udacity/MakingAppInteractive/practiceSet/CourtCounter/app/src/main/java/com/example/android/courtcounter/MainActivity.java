package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ascore=0;
    int bscore=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);
    }
    public void for3point(View view){
        ascore+= 3;
        displayForTeamA(ascore);
    }
    public void for2Point(View view){
        ascore = ascore + 2;
        displayForTeamA(ascore);
    }

    public void onReset(View view){
        ascore=0;
        bscore=0;
        displayForTeamB(bscore);
        displayForTeamA(ascore);
    }
    public void freeThroew(View view) {
        ascore +=1;
        displayForTeamA(ascore);
    }
    public void for3pointb(View view){
        bscore+= 3;
        displayForTeamB(bscore);
    }
    public void for2Pointb(View view){
        bscore = bscore + 2;
        displayForTeamB(bscore);
    }
    public void freeThrow(View view) {
        bscore +=1;
        displayForTeamB(bscore);
    }
    /**

     * Displays the given score for Team A.

     */

    public void displayForTeamA(int ascorescore) {

        TextView scoreView = (TextView) findViewById(R.id.team_a_score);

        scoreView.setText(String.valueOf(ascore));

    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int bscore) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(bscore));
    }
}
