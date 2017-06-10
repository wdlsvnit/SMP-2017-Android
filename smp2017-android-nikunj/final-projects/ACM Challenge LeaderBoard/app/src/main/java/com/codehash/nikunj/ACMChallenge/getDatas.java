package com.codehash.nikunj.ACMChallenge;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by nikunj on 6/6/17.
 */

public class getDatas {
    public static LinkedList<Datas> getJsondata(int a) throws Exception
    {
        URL uri=new URL("https://api.hackerearth.com/challenges/v1/leaderboard/");
        HttpURLConnection httpURLConnection=(HttpURLConnection)uri.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        String data="{\"client_id\": \"ecbce8a7214d4158adb97fb2de2e842f25bb7a65a843.api.hackerearth.com\", \"client_secret\": \"f34d20db882fdea377870152e87b1265ad27f9c2\", \"challenge_slug\": \"acm_summer_challenge\", \"page_index\": "+a+"}";
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        byte[] out = data.getBytes();
        httpURLConnection.setFixedLengthStreamingMode(out.length);
        httpURLConnection.connect();
        try{
            OutputStream outputStream=httpURLConnection.getOutputStream();
            outputStream.write(out);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        BufferedReader br=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String result=br.readLine();
        LinkedList<Datas> src=new LinkedList<>();
        JSONObject ob=new JSONObject(result);
        JSONArray leaderboard=ob.getJSONArray("leaderboard");
        for(int i=0;i<leaderboard.length();i++){
            JSONObject jb= leaderboard.getJSONObject(i);
            src.add(new Datas(jb.getString("username"),jb.getString("profile"),jb.getString("name"),jb.getString("problems_solved"),jb.getString("time_taken"),jb.getInt("score"),jb.getInt("rank")));
        }
        return src;
    }
}
