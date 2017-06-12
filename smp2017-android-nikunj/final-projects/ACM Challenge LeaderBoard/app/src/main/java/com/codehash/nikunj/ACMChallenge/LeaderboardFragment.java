package com.codehash.nikunj.ACMChallenge;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * Created by nikunj on 6/6/17.
 */

public class LeaderboardFragment extends Fragment {
    public LinkedList<Datas> src;
    public RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.leaderboardfragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        src=new LinkedList<>();
        StrictMode.ThreadPolicy strict=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(strict);
        try{
            src=getDatas.getJsondata(1);
            src.addAll(getDatas.getJsondata(2));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        final customRecyclerAdapter adapter=new customRecyclerAdapter(src);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(src.get(position).getProfile()));
                        startActivity(intent);
                    }
                }
        );



        return view;
    }


}
