package com.example.user.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 2016-12-16.
 */

public class JsonParser {

    static public int getUserInfoJson(String responese, ArrayList<UserInfo> userList) throws JSONException{

        String strID;
        String strName;
        String strPublish;
        String strPrice;

        JSONObject rootJSON=new JSONObject(responese);
        JSONArray jsonArray=new JSONArray(rootJSON.getString("datas"));

        for(int i=0; i<jsonArray.length();i++){
            JSONObject jsonObject=(JSONObject)jsonArray.getJSONObject(i);

            if(jsonObject.getString("BOOKID").toString().equals("null"))
                strID="-";
            else
                strID=jsonObject.getString("BOOKID").toString();


            if(jsonObject.getString("BOOKNAME").toString().equals("null"))
                strName="-";
            else
                strName=jsonObject.getString("BOOKNAME").toString();



            if(jsonObject.getString("PUBLISH").toString().equals("null"))
                strPublish="-";
            else
                strPublish=jsonObject.getString("PUBLISH").toString();


            if(jsonObject.getString("PRICE").toString().equals("null"))
                strPrice="-";
            else
                strPrice = jsonObject.getString("PRICE").toString();

            userList.add(new UserInfo(strID,strName,strPublish,strPrice));

        }
        return jsonArray.length();
    }

    static public int getResultJson(String response) throws JSONException{
        JSONArray jsonArray=new JSONArray(response);
        JSONObject jsonObject=new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }
}
