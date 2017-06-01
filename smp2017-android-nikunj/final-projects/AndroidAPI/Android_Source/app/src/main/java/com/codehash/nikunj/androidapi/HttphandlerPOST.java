package com.codehash.nikunj.androidapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nikunj on 31/5/17.
 */

public class HttphandlerPOST {
    public String postService(String reqURL,String namez,String descp) throws Exception
    {
        HttpURLConnection httpURLConnection=(HttpURLConnection)new URL(reqURL).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        String data = "namez="+namez+"&descp="+descp;

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
        return result;

    }
}
