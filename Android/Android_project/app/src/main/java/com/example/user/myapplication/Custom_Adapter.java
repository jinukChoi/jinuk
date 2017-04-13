package com.example.user.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

/**
 * Created by user on 2016-12-16.
 */
public class Custom_Adapter extends BaseAdapter {

    private Activity mAct;
    LayoutInflater mlayoutInflater;
    ArrayList<UserInfo> List = null;
    ArrayList<UserInfo> mUserInfoObjArr;
    int mListLayout;

    public Custom_Adapter(Activity a,int list,ArrayList<UserInfo> userInfoT){
        mAct=a;
        mListLayout=list;
        mUserInfoObjArr=userInfoT;
        List=userInfoT;
        mlayoutInflater=(LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<UserInfo> arrayList){
        mUserInfoObjArr=arrayList;
        List=arrayList;

    }
    @Override

    public int getCount() {
        return mUserInfoObjArr.size();
    }

    @Override
    public Object getItem(int i) {
        return mUserInfoObjArr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public ArrayList<UserInfo> getList(){
        return mUserInfoObjArr;
    }
    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {

        if(view==null)
            view=mlayoutInflater.inflate(mListLayout,viewGroup,false);

        final TextView tvID=(TextView)view.findViewById(R.id.IdText);
        tvID.setText(mUserInfoObjArr.get(i).id);

        final TextView tvName=(TextView)view.findViewById(R.id.NameText);
        tvName.setText(mUserInfoObjArr.get(i).name);

        final TextView tvPhone=(TextView)view.findViewById(R.id.PhoneText);
        tvPhone.setText(mUserInfoObjArr.get(i).publish);

        final TextView tvGrade=(TextView)view.findViewById(R.id.GradeText);
        tvGrade.setText(mUserInfoObjArr.get(i).price);


        Button updateBtn=(Button)view.findViewById(R.id.FixBtn);
        Button deleteBtn=(Button)view.findViewById(R.id.DeleteBtn);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  View v=mAct.getLayoutInflater().inflate(R.layout.dialog_upate,null);

                final String USERID= tvID.getText().toString();

                new android.support.v7.app.AlertDialog.Builder(mAct)
                        .setTitle("수정하기")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String BOOKID=((EditText)v.findViewById(R.id.IdEdit2)).getText().toString();
                                String BOOKNAME=((EditText)v.findViewById(R.id.NameEdit2)).getText().toString();
                                String PUBLISH=((EditText)v.findViewById(R.id.PhoneEdit2)).getText().toString();
                                String PRICE=((EditText)v.findViewById(R.id.GradeEdit2)).getText().toString();
                                new NetWorkUpdate(Custom_Adapter.this).execute(BOOKID,BOOKNAME,PUBLISH,PRICE,USERID);
                                new NetWorkGet(Custom_Adapter.this).execute("");
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID=tvID.getText().toString();
                AlertDialog.Builder ad=new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage("사용자 ID: "+userID+"를(을) 정말 삭제하겠습니까?");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new NetworkDelete(Custom_Adapter.this).
                                execute(tvID.getText().toString());
                        new NetWorkGet(Custom_Adapter.this).execute("");

                    }
                });
                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mAct, "취소하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });

        return view;
    }
}
