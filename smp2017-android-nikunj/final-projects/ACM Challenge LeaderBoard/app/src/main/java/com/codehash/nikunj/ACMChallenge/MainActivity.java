package com.codehash.nikunj.ACMChallenge;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    public Toolbar toolbar;
    public TabLayout tabLayout;
    public ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.cardview_dark_background)));
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new fragmentPageAdapter(getSupportFragmentManager(),this));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setNestedScrollingEnabled(true);


        
    }
}
