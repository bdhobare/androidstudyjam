package com.miles.sunshine.network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by miles on 10/22/16.
 */

public class NetworkHandler {

    public String get(String path){
        String result=null;
        HttpURLConnection httpURLConnection=null;
        try {
            URL url=new URL(path);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream in=new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuffer buffer=new StringBuffer();
            while ((line=bufferedReader.readLine())!= null){
                buffer.append(line);
                buffer.append('\r');
            }
            bufferedReader.close();
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
    }
}
