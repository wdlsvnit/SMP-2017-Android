package com.codehash.nikunj.animation2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text=(TextView)findViewById(R.id.textit);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.animate().alpha(0.5f).rotation(90f).xBy(10).yBy(10).setDuration(1000).setStartDelay(10).
                        setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                Toast.makeText(MainActivity.this, "Started...", Toast.LENGTH_SHORT).show();
                            };
                        });
            }
        });
    }
}
