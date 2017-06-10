package com.codehash.nikunj.ACMChallenge;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by nikunj on 6/6/17.
 */

public class customRecyclerAdapter extends RecyclerView.Adapter<customRecyclerAdapter.ViewHolder> {
    public LinkedList<Datas> src;
    public void edit( LinkedList<Datas> src)
    {
       for(int i=0;i<src.size();i++)
       {

           this.src.remove(i);
           this.src.add(i,src.get(i));
           notifyItemRemoved(i);
           notifyItemRangeChanged(i, src.size());
       }

    }

    public customRecyclerAdapter(LinkedList<Datas> src) {
        this.src = src;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.customrecyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView name=holder.name;
        TextView time_taken=holder.time_taken;
        TextView score=holder.score;
        TextView rank=holder.rank;

        if(src.get(position).getUsername().equals("khokharnikunj8")&&src.get(position).getName().equals("NIKUNJ KHOKHAR"))
        {

            name.setTextColor(Color.parseColor("#1f2da6"));
            time_taken.setTextColor(Color.parseColor("#1f2da6"));
            score.setTextColor(Color.parseColor("#1f2da6"));
            rank.setTextColor(Color.parseColor("#1f2da6"));
            Log.i("main",src.get(position).getUsername());

        }
        else
        {
            name.setTextColor(Color.parseColor("#7e7c7c"));
            time_taken.setTextColor(Color.parseColor("#7e7c7c"));
            score.setTextColor(Color.parseColor("#7e7c7c"));
            rank.setTextColor(Color.parseColor("#7e7c7c"));
        }
        name.setText(src.get(position).getName());
        time_taken.setText(src.get(position).getTime_taken());
        score.setText(String.valueOf(src.get(position).getScore()));
        rank.setText(String.valueOf(src.get(position).getRank()));

    }

    @Override
    public int getItemCount() {
        return src.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name,time_taken,score,rank;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            time_taken=(TextView)itemView.findViewById(R.id.time_taken);
            score=(TextView)itemView.findViewById(R.id.score);
            rank=(TextView)itemView.findViewById(R.id.rank);
        }
    }
}
