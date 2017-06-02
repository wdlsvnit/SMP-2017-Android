package com.codehash.nikunj.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nikunj on 2/6/17.
 */

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerlayout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        recycleData recycledata= list.get(position);
        TextView textView1= holder.recycletext1;
        textView1.setText(recycledata.getRecyclerString1());
        TextView textView2 = holder.recycletext2;
        textView2.setText(recycledata.getRecyclerString2());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView recycletext1;
        public TextView recycletext2;
        public ViewHolder(View view){
            super(view);
            recycletext1=(TextView)view.findViewById(R.id.recycletext1);
            recycletext2=(TextView)view.findViewById(R.id.recycletext2);
        }

    }
    public List<recycleData> list;

    public recyclerViewAdapter(Context context, List<recycleData> list)
    {
        this.list=list;
    }


}
