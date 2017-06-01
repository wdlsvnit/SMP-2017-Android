package com.codehash.nikunj.androidapi;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nikunj on 31/5/17.
 */

public class HttphandlerGET  {
    public String makeService(String requrl) throws Exception{
        URL url= new URL(requrl);
        HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String result=br.readLine();
        Log.i("main",result);
        return result;
    }
}
