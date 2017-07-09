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
    int[][] board={{2,2,2},{2,2,2},{2,2,2}};
    boolean gameOver=false;
    boolean twoPlayer=false;
    boolean Hard=false;


    public void esay(View view){
        Hard = false;
        setContentView(R.layout.oneplayer);

    }

    public void hard(View view){
        Hard = true;
        setContentView(R.layout.oneplayer);
    }

    public void computer_make_move()
    {




        int movingindex = -1;
        ViewGroup temp =(ViewGroup)findViewById(R.id.girdLayout) ;


        if(Hard)
        {
            movingindex = bestmove();
        }


        if(movingindex == -1)
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


            if(movingindex <3 )
                board[0][movingindex] = activePlayer;
            else if (movingindex>=3 && movingindex <=5)
                board[1][movingindex-3] = activePlayer;
            else
                board[2][movingindex-6] = activePlayer;



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
//        if(gamseState[9] then == 1 )
        if(gameState[2]==2 && gameState[4]==mark && gameState[6]==mark)
            return 2;

        return -1;
    }
    public void gameLogic(View view)
    {
        ImageView tappedView = (ImageView) view;

        int taggedLocation = Integer.parseInt(view.getTag().toString());

        if(gameState[taggedLocation] == 2 && !gameOver) {

            gameState[taggedLocation] = activePlayer;



            if(taggedLocation <3 )
            board[0][taggedLocation] = activePlayer;
            else if (taggedLocation>=3 && taggedLocation <=5)
                board[1][taggedLocation-3] = activePlayer;
            else
                board[2][taggedLocation-6] = activePlayer;


            if (activePlayer == 0) {

                tappedView.setImageResource(R.drawable.xx);
                activePlayer = 1;

                result();
                if(!twoPlayer && !gameOver)
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
        if(gameOver == false) {
            for (int i = 0; i < gameState.length; i++) {
                if (gameState[i] != 2) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                RelativeLayout winnerLayout = (RelativeLayout) findViewById(R.id.winnerlayout);
                winnerLayout.setVisibility(View.VISIBLE);
                TextView message = (TextView) findViewById(R.id.scoreboard);
                message.setText("GAME IS DRAW");
                gameOver = true;
            }
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

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j] = 2;
            }
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

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j] = 2;
            }
        }

        GridLayout gl = (GridLayout)findViewById(R.id.girdLayout);

        for(int i=0;i<gl.getChildCount();i++)
        {
            ((ImageView)gl.getChildAt(i)).setImageResource(0);
        }

        //twoPlayer=false;
        if(twoPlayer == true)
        {
            twoPlayer = false;
            setContentView(R.layout.activity_main);
        }
        else {

            Hard = false;
            setContentView(R.layout.gametype);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void oneplayer(View view)
    {

        setContentView(R.layout.gametype);

    }

    public void twoplayer(View view)
    {
        setContentView(R.layout.oneplayer);
        twoPlayer=true;
    }


    public  int bestmove()
    {
        int bestVal = -1000;

        int row = -1;
        int col = -1;

        // Traverse all cells, evalutae minimax function for
        // all empty cells. And return the cell with optimal
        // value.
        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                // Check if celll is empty
                if (board[i][j]==2)
                {
                    // Make the move
                    board[i][j] = 1;

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax( 0,false);

                    // Undo the move
                    board[i][j] = 2;

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal)
                    {
                        row = i;
                        col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return (row*3) + col;

    }



    public int minimax(int depth, boolean isMax) {
        int score = evaluate();

        // If Maximizer has won the game return his/her
        // evaluated score
        if (score == 10)
            return score;

        // If Minimizer has won the game return his/her
        // evaluated score
        if (score == -10)
            return score;

        // If there are no more moves and no winner then
        // it is a tie
        if (isMovesLeft() == false)
            return 0;

        // If this maximizer's move
        if (isMax) {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board[i][j] == 2) {
                        // Make the move
                        board[i][j] = 1;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = max(best,
                                minimax(depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = 2;
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board[i][j] == 2) {
                        // Make the move
                        board[i][j] = 0;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = min(best,
                                minimax(depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = 2;
                    }
                }
            }
            return best;
        }
    }


       public int evaluate() {



            // Checking for Rows for X or O victory.
            for (int row = 0; row<3; row++)
            {
                if (board[row][0]==board[row][1] &&
                        board[row][1]==board[row][2])
                {
                    if (board[row][0]==1)
                        return +10;
                    else if (board[row][0]==0)
                        return -10;
                }
            }

            // Checking for Columns for X or O victory.
            for (int col = 0; col<3; col++)
            {
                if (board[0][col]==board[1][col] &&
                        board[1][col]==board[2][col])
                {
                    if (board[0][col]==1)
                        return +10;

                    else if (board[0][col]==0)
                        return -10;
                }
            }

            // Checking for Diagonals for X or O victory.
            if (board[0][0]==board[1][1] && board[1][1]==board[2][2])
            {
                if (board[0][0]==1)
                    return +10;
                else if (board[0][0]==0)
                    return -10;
            }

            if (board[0][2]==board[1][1] && board[1][1]==board[2][0])
            {
                if (board[0][2]==1)
                    return +10;
                else if (board[0][2]==0)
                    return -10;
            }

            // Else if none of them have won then return 0
            return 0;
        }


    public boolean isMovesLeft()
    {
        for (int i = 0; i<3; i++)
            for (int j = 0; j<3; j++)
                if (board[i][j]==2)
                    return true;
        return false;
    }

    public int max(int a ,int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }

    public int min(int a ,int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }

}
