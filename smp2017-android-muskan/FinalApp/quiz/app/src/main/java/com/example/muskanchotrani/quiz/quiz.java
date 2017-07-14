package com.example.muskanchotrani.quiz;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.muskanchotrani.quiz.R;
import com.example.muskanchotrani.quiz.questons;
import com.example.muskanchotrani.quiz.summary;

import java.util.Random;

import static com.example.muskanchotrani.quiz.R.id.number;
import static com.example.muskanchotrani.quiz.R.string.ques2;

public class quiz extends AppCompatActivity
{
    Button optiona, optionb, optionc, optiond;
    TextView number,ques,resource;
    private questons mQuestions = new questons();
    private String mAnswer;
    private int mScore=0;
    private int mQuestionsLength = 35;
    Random r;
    private int mNumber=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final Intent i = new Intent(this, summary.class);
        final Bundle bundle = new Bundle();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        optiona = (Button) findViewById(R.id.optiona);
        optionb = (Button) findViewById(R.id.optionb);
        optionc = (Button) findViewById(R.id.optionc);
        optiond = (Button) findViewById(R.id.optiond);
        r = new Random();
        number = (TextView) findViewById(R.id.number);
        ques = (TextView) findViewById(R.id.ques);
        resource = (TextView) findViewById(R.id.resource);
        number.setText(mNumber+".");
        updateQuestions(r.nextInt(mQuestionsLength));

        optiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(optiona.getText()==mAnswer)
                { mScore++;  }
                else
                {
                    wrongAnswer();
                }
                mNumber++;
                if(mNumber==21)
                {   String t;
                    t=String.valueOf(mScore);
                    bundle.putString("stuff", t);
                    i.putExtras(bundle);
                    startActivity(i);
                    finish();
                }
                else
                {
                    number.setText(mNumber+".");
                    updateQuestions(r.nextInt(mQuestionsLength));
                }
            }
        });
        optionb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(optionb.getText()==mAnswer)
                { mScore++;  }
                else
                {
                    wrongAnswer();
                }
                mNumber++;
                if(mNumber==21)
                {
                    String t;
                    t=String.valueOf(mScore);
                    bundle.putString("stuff", t);
                    i.putExtras(bundle);
                    startActivity(i);
                    finish();
                }
                else
                {
                    number.setText(mNumber+".");
                    updateQuestions(r.nextInt(mQuestionsLength));
                }

            }
        });
        optionc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(optionc.getText()==mAnswer)
                { mScore++;  }
                else
                {
                    wrongAnswer();
                }
                mNumber++;
                if(mNumber==21)
                {
                    String t;
                    t=String.valueOf(mScore);
                    bundle.putString("stuff", t);
                    i.putExtras(bundle);
                    startActivity(i);
                    finish();
                }
                else
                {
                    number.setText(mNumber+".");
                    updateQuestions(r.nextInt(mQuestionsLength));
                }

            }
        });
        optiond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(optiond.getText()==mAnswer)
                { mScore++;  }
                else
                {
                    wrongAnswer();
                }
                mNumber++;
                if(mNumber==21)
                {
                    String t;
                    t=String.valueOf(mScore);
                    bundle.putString("stuff", t);
                    i.putExtras(bundle);
                    startActivity(i);
                    finish();
                }
                else
                {
                    number.setText(mNumber+".");
                    updateQuestions(r.nextInt(mQuestionsLength));
                }

            }
        });
    }
    private void updateQuestions(int num)
    {
        ques.setText(mQuestions.getQuestion(num));
        optiona.setText(mQuestions.getChoice1(num));
        optionb.setText(mQuestions.getChoice2(num));
        optionc.setText(mQuestions.getChoice3(num));
        optiond.setText(mQuestions.getChoice4(num));
        resource.setText(mQuestions.getResource(num));
        mAnswer=mQuestions.getCorrectAnswer(num);

    }
    private void wrongAnswer()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(quiz.this);
        alertDialogBuilder.setMessage("Wrong Answer :(");
        alertDialogBuilder.show();
    }

}