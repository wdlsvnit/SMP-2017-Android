package com.codehash.nikunj.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nikunj on 3/6/17.
 */

public class customListViewAdapter extends BaseAdapter {
    public ArrayList<Item> item;
    public Context context;
    public customListViewAdapter(Context context , ArrayList<Item> item)
    {
        this.item=item;
        this.context=context;
    }
    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.customlistlayout,parent,false);

        }
        Item currentItem= (Item) getItem(position);
        TextView text1=(TextView)convertView.findViewById(R.id.text1);
        TextView text2=(TextView)convertView.findViewById(R.id.text2);
        text1.setText(currentItem.get1());
        text2.setText(currentItem.get2());
        return convertView;
    }
}
