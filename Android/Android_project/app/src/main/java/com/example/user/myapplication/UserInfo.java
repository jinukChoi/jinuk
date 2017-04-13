package com.example.user.myapplication;

/**
 * Created by user on 2016-12-16.
 */
public class UserInfo {
    String id,name,publish,price;

    public  UserInfo(String id,String name,String publish,String price){
        this.id=id;
        this.name=name;
        this.publish=publish;
        this.price=price;
    }
    public String getName() {
        return this.name;
    }
}
