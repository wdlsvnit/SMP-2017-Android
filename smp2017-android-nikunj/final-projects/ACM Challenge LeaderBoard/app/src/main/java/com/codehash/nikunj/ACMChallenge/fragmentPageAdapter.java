package com.codehash.nikunj.ACMChallenge;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nikunj on 6/6/17.
 */

public class fragmentPageAdapter extends FragmentPagerAdapter {
    public String titles[]={"LeaderBoard","About me"};
    public Context context;
    public fragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new LeaderboardFragment();

            case 1:
                return new Aboutme();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
