package com.jenish.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.android.tictactoe.R.id.fab;
import static com.jenish.android.tictactoe.R.id.winnerLayout;


public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState={2,2,2,2,2,2,2,2,2} ;
    int[][] winningState={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameOver=false;


    public void gameLogic(View view)
    {
        ImageView tappedView = (ImageView) view;
        boolean flag=false;
        int taggedLocation = Integer.parseInt(view.getTag().toString());

        if(gameState[taggedLocation] == 2 && gameOver== false) {

            gameState[taggedLocation] = activePlayer;
            if (activePlayer == 0) {

                tappedView.setImageResource(R.drawable.x);
                activePlayer = 1;
            } else {

                tappedView.setImageResource(R.drawable.zero);
                activePlayer = 0;
            }
            //tappedView.animate().translationYBy(3000f).setDuration(500);
        }
        String msg;
        for(int [] winingPosition : winningState)
        {
            if(gameState[winingPosition[0]] == gameState[winingPosition[1]]  && gameState[winingPosition[1]] == gameState[winingPosition[2]] && gameState[winingPosition[0]]!= 2)
            {
                if(activePlayer==0)
                {
//                    Toast.makeText(getApplicationContext(),"ZERO HAS WON",Toast.LENGTH_LONG).show();
                    msg = "ZERO IS WINNER";
                }
                else
                {
//                    Toast.makeText(getApplicationContext(),"X HAS WON",Toast.LENGTH_LONG).show();
                    msg = "X IS WINNER";
                }
                RelativeLayout winnerLayout = (RelativeLayout)findViewById(R.id.winnerLayout);
                winnerLayout.setVisibility(View.VISIBLE);
                TextView message = (TextView)findViewById(R.id.msg);
                message.setText(msg);

                gameOver = true;
            }
        }

        for(int i=0;i<gameState.length;i++)
        {
            if(gameState[i] != 2)
            {
                flag =true;
            }
            else
            {
                flag = false;
                break;
            }
        }

        if(flag == true)
        {
            RelativeLayout winnerLayout = (RelativeLayout)findViewById(R.id.winnerLayout);
            winnerLayout.setVisibility(View.VISIBLE);
            TextView message = (TextView)findViewById(R.id.msg);
            message.setText("GAME IS DRAW");

            gameOver = true;
        }
    }

    public void playAgain(View view){
        RelativeLayout winnerLayout =(RelativeLayout)findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);

        gameOver=false;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i] = 2;
        }

        GridLayout gl = (GridLayout)findViewById(R.id.girdLayout);

        for(int i=0;i<gl.getChildCount();i++)
        {
            ((ImageView)gl.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout winnerLayout = (RelativeLayout)findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
