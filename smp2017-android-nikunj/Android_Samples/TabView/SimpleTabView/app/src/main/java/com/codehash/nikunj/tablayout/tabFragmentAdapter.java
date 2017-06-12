package com.codehash.nikunj.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nikunj on 5/6/17.
 */

public class tabFragmentAdapter extends FragmentPagerAdapter {

    public final int count = 3;
    public String[] titles= {"tab1","tab2","tab2"};
    public Context context;

    public tabFragmentAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
       return Fragment1.create(titles[position]);
    }

    @Override
    public int getCount() {
        return count;
    }

}
