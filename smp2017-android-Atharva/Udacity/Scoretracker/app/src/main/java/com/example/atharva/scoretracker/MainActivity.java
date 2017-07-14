package com.example.atharva.scoretracker;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
     int homeGoals=0;
     int awayGoals=0;
     int homeFouls=0;
     int awayFouls=0;
     int homeYellows=0;
     int awayYellows=0;
     int homeReds=0;
     int awayReds=0;
     int homeOffsides=0;
     int awayOffsides=0;
     int[] minusButtonIds={R.id.minus_home,R.id.minus_away,R.id.home_foul_minus,R.id.away_foul_minus,R.id.home_yellow_minus,
     R.id.away_yellow_minus,R.id.home_red_minus,R.id.away_red_minus,R.id.away_offside_minus,R.id.home_offside_minus};

    int[] plusButtonIds={R.id.plus_home,R.id.plus_away,R.id.home_foul_plus,R.id.away_foul_plus,R.id.home_yellow_plus,
            R.id.away_yellow_plus,R.id.home_red_plus,R.id.away_red_plus,R.id.away_offside_plus,R.id.home_offside_plus};

    int[] resetButtonIds={R.id.reset_foul,R.id.reset_offside,R.id.reset_red,R.id.reset_yellow};

    int[] textIds={R.id.home_goals,R.id.away_goals,R.id.home_foul,R.id.away_foul,R.id.home_yellow,R.id.away_yellow,
    R.id.home_red,R.id.away_red,R.id.home_offside,R.id.away_offside};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickSet(View view)
    {

        TextView test=(TextView)findViewById(R.id.test);
        ImageView homeTeam=(ImageView)findViewById(R.id.home_team);
        ImageView awayTeam=(ImageView)findViewById(R.id.away_team);
        Spinner homeSpinner=(Spinner)findViewById(R.id.home_spinner);
        Spinner awaySpinner=(Spinner)findViewById(R.id.away_spinner);
        String hometeam = homeSpinner.getSelectedItem().toString();
        String awayteam = awaySpinner.getSelectedItem().toString();
        switch (hometeam)
        {
            case "Real Madrid":
                homeTeam.setImageResource(R.drawable.realmadridlogo1);
                break;
            case "Barcelona":
                homeTeam.setImageResource(R.drawable.barcelonalogo1);
                break;
            case "Chelsea":
                homeTeam.setImageResource(R.drawable.chelsealogo);
                break;
            case "Manchester Utd.":
                homeTeam.setImageResource(R.drawable.manchesterutdlogo);
                break;
            case "Bayern Munich":
                homeTeam.setImageResource(R.drawable.bayernmunichlogo);
                break;
            case "Borrusia Dortmund":
                homeTeam.setImageResource(R.drawable.dortmundlogo);
                break;
        }
        switch (awayteam)
        {
            case "Real Madrid":
                awayTeam.setImageResource(R.drawable.realmadridlogo1);
                break;
            case "Barcelona":
                awayTeam.setImageResource(R.drawable.barcelonalogo1);
                break;
            case "Chelsea":
                awayTeam.setImageResource(R.drawable.chelsealogo);
                break;
            case "Manchester Utd.":
                awayTeam.setImageResource(R.drawable.manchesterutdlogo);
                break;
            case "Bayern Munich":
                awayTeam.setImageResource(R.drawable.bayernmunichlogo);
                break;
            case "Borrusia Dortmund":
                awayTeam.setImageResource(R.drawable.dortmundlogo);
                break;
        }

        test.setText(hometeam+" V/S "+awayteam);
    }

    public void onClickButton(View view)
    {
        final int viewId=view.getId();
        final Button button = (Button) findViewById(viewId);
        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    for(int c : minusButtonIds)
                    {
                        if(c==viewId)
                            button.setBackground(getResources().getDrawable(R.drawable.button_pressed_minus));
                    }
                    for(int c: plusButtonIds)
                    {
                        if(c==viewId)
                            button.setBackground(getResources().getDrawable(R.drawable.button_pressed_plus));

                    }
                    for(int c: resetButtonIds)
                    {
                        if(c==viewId)
                            button.setBackground(getResources().getDrawable(R.drawable.button_pressed_minus));

                    }
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    button.setBackground(getResources().getDrawable(R.drawable.round_button));
                }
                return false;
            }

        });
        int buttonId=view.getId();
        switch (buttonId)
        {
            case R.id.plus_home: ++homeGoals;
                                 textViewUpdater(R.id.home_goals,homeGoals);
                                 break;
            case R.id.plus_away: ++awayGoals;
                                 textViewUpdater(R.id.away_goals,awayGoals);
                                 break;
            case R.id.minus_home: --homeGoals;
                                 textViewUpdater(R.id.home_goals,homeGoals);
                                  break;
            case R.id.minus_away: --awayGoals;
                                 textViewUpdater(R.id.away_goals,awayGoals);
                                  break;

            case R.id.home_foul_plus: ++homeFouls;
                                      textViewUpdater(R.id.home_foul,homeFouls);
                                      break;
            case R.id.away_foul_plus: ++awayFouls;
                                      textViewUpdater(R.id.away_foul,awayFouls);
                                      break;
            case R.id.home_foul_minus: --homeFouls;
                                       textViewUpdater(R.id.home_foul,homeFouls);
                                       break;
            case R.id.away_foul_minus: --awayFouls;
                                       textViewUpdater(R.id.away_foul,awayFouls);
                                       break;

            case R.id.home_yellow_plus: ++homeYellows;
                                        textViewUpdater(R.id.home_yellow,homeYellows);
                                        break;
            case R.id.away_yellow_plus: ++awayYellows;
                                        textViewUpdater(R.id.away_yellow,awayYellows);
                                        break;
            case R.id.home_yellow_minus: --homeYellows;
                                         textViewUpdater(R.id.home_yellow,homeYellows);
                                         break;
            case R.id.away_yellow_minus: --awayYellows;
                                         textViewUpdater(R.id.away_yellow,awayYellows);
                                         break;

            case R.id.home_red_plus: ++homeReds;
                                     textViewUpdater(R.id.home_red,homeReds);
                                     break;
            case R.id.away_red_plus: ++awayReds;
                                     textViewUpdater(R.id.away_red,awayReds);
                                     break;
            case R.id.home_red_minus: --homeReds;
                                      textViewUpdater(R.id.home_red,homeReds);
                                      break;
            case R.id.away_red_minus: --awayReds;
                                      textViewUpdater(R.id.away_red,awayReds);
                                      break;

            case R.id.home_offside_plus: ++homeOffsides;
                                         textViewUpdater(R.id.home_offside,homeOffsides);
                                         break;
            case R.id.away_offside_plus: ++awayOffsides;
                                         textViewUpdater(R.id.away_offside,awayOffsides);
                                         break;
            case R.id.home_offside_minus: --homeOffsides;
                                          textViewUpdater(R.id.home_offside,homeOffsides);
                                          break;
            case R.id.away_offside_minus: --awayOffsides;
                                          textViewUpdater(R.id.away_offside,awayOffsides);
                                          break;

        }
    }

    public void onClickReset(View view) {
        switch (view.getId())
        {
            case R.id.reset_foul:
                textViewUpdater(R.id.home_foul,0);
                textViewUpdater(R.id.away_foul,0);
                break;
            case R.id.reset_yellow:
                textViewUpdater(R.id.home_yellow,0);
                textViewUpdater(R.id.away_yellow,0);
                break;
            case R.id.reset_red:
                textViewUpdater(R.id.home_red,0);
                textViewUpdater(R.id.away_red,0);
                break;
            case R.id.reset_offside:
                textViewUpdater(R.id.home_offside,0);
                textViewUpdater(R.id.away_offside,0);
                break;
            case R.id.reset_all:
                for(int c:textIds)
                {
                    textViewUpdater(c,0);
                }
        }

    }

    public void textViewUpdater(int textId,int value)
    {
        TextView text=(TextView)findViewById(textId);
        text.setText(String.valueOf(value));
    }


}
