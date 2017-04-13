package com.example.user.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by user on 2016-12-16.
 */
public class NetworkDelete extends AsyncTask<String,Void,String> {
    private URL Url;
    private String URL_Adress="http://192.168.0.2:8080/Test/TestDB_delete.jsp";
    private Custom_Adapter custom_adapter;

    public NetworkDelete(Custom_Adapter adapter) {
    custom_adapter=adapter;
    }

    protected void onPreExecute(){
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... strings) {
        String res="";
        try {
            Url=new URL(URL_Adress);
            HttpURLConnection conn=(HttpURLConnection)Url.openConnection();
            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=utf-8");
            StringBuffer buffer=new StringBuffer();
            buffer.append("BOOKID").append("=").append(strings[0]);
            OutputStreamWriter outputStreamWriter=
                    new OutputStreamWriter(conn.getOutputStream(),"utf-8");
            PrintWriter printWriter=new PrintWriter(outputStreamWriter);
            printWriter.write(buffer.toString());
            printWriter.flush();

            StringBuilder stringBuilder=new StringBuilder();
            BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line=in.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
            res=stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    protected void onPostExecute(String s){
        super.onPostExecute(s);
        ArrayList<UserInfo> userInfos=new ArrayList<UserInfo>();
        int count=0;
        try{
            count=JsonParser.getResultJson(s);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(count==0){}
        else
            new NetWorkGet(custom_adapter).equals("");
    }
}
