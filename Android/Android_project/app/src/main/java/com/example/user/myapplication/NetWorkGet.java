package com.example.user.myapplication;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by user on 2016-12-16.
 */
public class NetWorkGet extends AsyncTask<String,Void,String> {
    private URL Url;
    private String URL_Adress="http://192.168.0.2:8080/Test/TestDB.jsp";
    private Custom_Adapter custom_adapter;


    public NetWorkGet(Custom_Adapter adapter) {
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

            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=UTF-8");

            StringBuffer buffer=new StringBuffer();
            buffer.append("BOOKID").append("=").append(strings[0]);

            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(conn.getOutputStream(),"UTF-8");

            PrintWriter printWriter=new PrintWriter(outputStreamWriter);
            printWriter.write(buffer.toString());
            printWriter.flush();

            StringBuilder stringBuilder=new StringBuilder();
            BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
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

        Log.d("Get result",res);
        return res;
    }

    protected void onPostExecute(String s){
        super.onPostExecute(s);

        ArrayList<UserInfo> userList =new ArrayList<UserInfo>();

        int count=0;

        try{
            count=JsonParser.getUserInfoJson(s,userList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(count==0){
            Log.d("Get result","nn");
        }
        else{
            custom_adapter.setDatas(userList);
            custom_adapter.notifyDataSetInvalidated();
        }
    }
}
