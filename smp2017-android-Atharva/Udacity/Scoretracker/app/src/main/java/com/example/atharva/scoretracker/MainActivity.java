package com.example.atharva.scoretracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
     int homeGoals=0;
     int awayGoals=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGoals(View view)
    {
        TextView test=(TextView)findViewById(R.id.test);
        TextView home_Goals=(TextView)findViewById(R.id.home_goals);
        TextView away_Goals=(TextView)findViewById(R.id.away_goals);
        test.setText(String.valueOf(view)+"\n"+String.valueOf(view.getId())+"\n"+String.valueOf(R.id.home_goals));
        int buttonId=view.getId();
        switch (buttonId)
        {
            case R.id.plus_home: ++homeGoals;
                                 home_Goals.setText(String.valueOf(homeGoals));
                                 break;
            case R.id.plus_away: ++awayGoals;
                                 away_Goals.setText(String.valueOf(awayGoals));
                                 break;
            case R.id.minus_home: --homeGoals;
                                  home_Goals.setText(String.valueOf(homeGoals));
                                  break;
            case R.id.minus_away: --awayGoals;
                                  away_Goals.setText(String.valueOf(awayGoals));
                                  break;
        }
    }
}
