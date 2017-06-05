package com.codehash.nikunj.tablayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nikunj on 5/6/17.
 */

public class Fragment1 extends Fragment {

    public static Fragment1 create(String string)
    {
        Bundle args=new Bundle();
        args.putString("Value",string);
        Fragment1 fragment1=new Fragment1();
        fragment1.setArguments(args);
        return fragment1;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment1,container,false);
        TextView txt=(TextView)view.findViewById(R.id.fragmenttxt);
        Bundle data=getArguments();
        txt.setText(data.getString("Value"));


        return view;
    }
}
