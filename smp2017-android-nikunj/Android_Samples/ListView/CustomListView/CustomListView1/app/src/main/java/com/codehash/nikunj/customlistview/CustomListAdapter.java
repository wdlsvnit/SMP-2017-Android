package com.codehash.nikunj.customlistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by nikunj on 1/6/17.
 */

public class CustomListAdapter extends ArrayAdapter{
    Context context;
    public CustomListAdapter(@NonNull Context context, String [] res) {

        super(context,R.layout.customlistlayout,res);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.customlistlayout,parent,false);
        String strr=(String)getItem(position);
        TextView customtext=(TextView)view.findViewById(R.id.customtext);
        customtext.setText(strr);
        return view;
    }
}
