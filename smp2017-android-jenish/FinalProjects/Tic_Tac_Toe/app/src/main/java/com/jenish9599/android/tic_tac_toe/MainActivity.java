package com.jenish9599.android.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState={2,2,2,2,2,2,2,2,2} ;
    int[][] winningState={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameOver=false;
    boolean twoPlayer=false;

    public void computer_make_move()
    {

//       To dismiss the dialog




        //find winning
        //find to block
        //find corner
        int movingindex = -1;
        ViewGroup temp =(ViewGroup)findViewById(R.id.girdLayout) ;




        movingindex = look_for_win_or_block(1);

        if(movingindex == -1)
        {
            movingindex = look_for_win_or_block(0);

            if(movingindex == -1)
            {
                movingindex = look_for_corner();

                if(movingindex == -1)
                {
                    movingindex = look_for_open_space();
                }
            }
        }

        if(movingindex != -1) {
            gameState[movingindex] = activePlayer;
            String s = "" + movingindex;
            ImageView view = (ImageView) temp.findViewWithTag(s);
            view.setImageResource(R.drawable.nell);
            activePlayer = 0;

        }
    }
    public int look_for_corner(){

        if (gameState[0] == 1)
        {
            if (gameState[2] == 2)
                return 2;
            if (gameState[8] == 2)
                return 8;
            if (gameState[6] == 2)
                return 6;
        }

        if (gameState[2] == 1)
        {
            if (gameState[0] == 2)
                return 0;
            if (gameState[8] == 2)
                return 8;
            if (gameState[6] == 2)
                return 6;
        }

        if (gameState[8] == 1)
        {
            if (gameState[0] == 2)
                return 0;
            if (gameState[2] == 2)
                return 2;
            if (gameState[6] == 2)
                return 6;
        }

        if (gameState[6] == 1)
        {
            if (gameState[0] == 2)
                return 0;
            if (gameState[2] == 2)
                return 2;
            if (gameState[8] == 2)
                return 8;
        }

        if (gameState[0] == 2)
            return 0;
        if (gameState[2] == 2)
            return 2;
        if (gameState[6] == 2)
            return 6;
        if (gameState[8] == 2)
            return 8;

        return -1;
    }


    public int look_for_open_space(){

        for(int i=0;i<9;i++)
        {
            if(gameState[i] == 2)
                return i;
        }

        return -1;
    }
    public int look_for_win_or_block(int mark){

        if(gameState[0]==mark && gameState[1]==mark && gameState[2]==2)
            return 2;
        if(gameState[0]==mark && gameState[1]==2 && gameState[2]==mark)
            return 1;
        if(gameState[0]==2 && gameState[1]==mark && gameState[2]==mark)
            return 0;


        if(gameState[3]==mark && gameState[4]==mark && gameState[5]==2)
            return 5;
        if(gameState[3]==mark && gameState[4]==2 && gameState[5]==mark)
            return 4;
        if(gameState[3]==2 && gameState[4]==mark && gameState[5]==mark)
            return 3;

        if(gameState[6]==mark && gameState[7]==mark && gameState[8]==2)
            return 8;
        if(gameState[6]==mark && gameState[7]==2 && gameState[8]==mark)
            return 7;
        if(gameState[6]==2 && gameState[7]==mark && gameState[8]==mark)
            return 6;


        if(gameState[0]==mark && gameState[3]==mark && gameState[6]==2)
            return 6;
        if(gameState[0]==mark && gameState[3]==2 && gameState[6]==mark)
            return 3;
        if(gameState[0]==2 && gameState[3]==mark && gameState[6]==mark)
            return 0;


        if(gameState[1]==mark && gameState[4]==mark && gameState[7]==2)
            return 7;
        if(gameState[1]==mark && gameState[4]==2 && gameState[7]==mark)
            return 4;
        if(gameState[1]==2 && gameState[4]==mark && gameState[7]==mark)
            return 1;


        if(gameState[2]==mark && gameState[5]==mark && gameState[8]==2)
            return 8;
        if(gameState[2]==mark && gameState[5]==2 && gameState[8]==mark)
            return 5;
        if(gameState[2]==2 && gameState[5]==mark && gameState[8]==mark)
            return 2;


        if(gameState[0]==mark && gameState[4]==mark && gameState[8]==2)
            return 8;
        if(gameState[0]==mark && gameState[4]==2 && gameState[8]==mark)
            return 4;
        if(gameState[0]==2 && gameState[4]==mark && gameState[8]==mark)
            return 0;

        if(gameState[2]==mark && gameState[4]==mark && gameState[6]==2)
            return 6;
        if(gameState[2]==mark && gameState[4]==2 && gameState[6]==mark)
            return 4;
        if(gameState[2]==2 && gameState[4]==mark && gameState[6]==mark)
            return 2;

        return -1;
    }
    public void gameLogic(View view)
    {
        ImageView tappedView = (ImageView) view;

        int taggedLocation = Integer.parseInt(view.getTag().toString());

        if(gameState[taggedLocation] == 2 && gameOver== false) {

            gameState[taggedLocation] = activePlayer;
            if (activePlayer == 0) {

                tappedView.setImageResource(R.drawable.xx);
                activePlayer = 1;

                result();
                if(twoPlayer == false && gameOver==false)
                {
                    computer_make_move();
                    result();
                }

            } else {

                tappedView.setImageResource(R.drawable.nell);
                activePlayer = 0;
                result();
            }


        }


//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public void result(){
        boolean flag=false;
        String msg;
        int m=0;
        for(int [] winingPosition : winningState)
        {
            if(gameState[winingPosition[0]] == gameState[winingPosition[1]]  && gameState[winingPosition[1]] == gameState[winingPosition[2]] && gameState[winingPosition[0]]!= 2)
            {
                if(activePlayer==0)
                {
//                    Toast.makeText(getApplicationContext(),"ZERO HAS WON",Toast.LENGTH_LONG).show();
                    msg = "ZERO IS WINNER";
                    m=0;
                }
                else
                {
//                    Toast.makeText(getApplicationContext(),"X HAS WON",Toast.LENGTH_LONG).show();
                    msg = "X IS WINNER";
                    m=1;
                }
                RelativeLayout winnerLayout = (RelativeLayout)findViewById(R.id.winnerlayout);
                winnerLayout.setVisibility(View.VISIBLE);
                TextView message = (TextView)findViewById(R.id.scoreboard);
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
            RelativeLayout winnerLayout = (RelativeLayout)findViewById(R.id.winnerlayout);
            winnerLayout.setVisibility(View.VISIBLE);
            TextView message = (TextView)findViewById(R.id.scoreboard);
            message.setText("GAME IS DRAW");
            gameOver = true;
        }
    }


    public void playAgain(View view){
//        RelativeLayout winnerLayout =(RelativeLayout)findViewById(R.id.winnerlayout);
//        winnerLayout.setVisibility(View.INVISIBLE);
        TextView sc = (TextView)findViewById(R.id.scoreboard);
        sc.setText("RESULT");
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

    public void back(View view){
//        RelativeLayout winnerLayout =(RelativeLayout)findViewById(R.id.winnerlayout);
//        winnerLayout.setVisibility(View.INVISIBLE);
        TextView sc = (TextView)findViewById(R.id.scoreboard);
        sc.setText("RESULT");
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

        twoPlayer=false;
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void oneplayer(View view)
    {
        setContentView(R.layout.oneplayer);
    }

    public void twoplayer(View view)
    {
        setContentView(R.layout.oneplayer);
        twoPlayer=true;
    }
}
