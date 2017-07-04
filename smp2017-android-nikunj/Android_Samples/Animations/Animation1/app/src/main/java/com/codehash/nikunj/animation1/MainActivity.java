package com.codehash.nikunj.animation1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView hello=(TextView)findViewById(R.id.hello);
        final ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(hello,View.ALPHA,0,1);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setInterpolator(new LinearInterpolator());



        final ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(hello,"scaleX",1.0f,2.0f);
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator1.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator1.setDuration(2000);


        final AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(objectAnimator,objectAnimator1);
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatorSet.start();
            }
        });
    }
}
