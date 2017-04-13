package com.example.user.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button NewBtn,InsetBtn,searchbtn;
    private ListView listView;
    private EditText edit;
    private Custom_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.ListView);
        adapter=new Custom_Adapter(MainActivity.this,R.layout.adapter_userinfo,
                new ArrayList<UserInfo>());
        listView.setAdapter(adapter);
        new NetWorkGet((Custom_Adapter)listView.getAdapter()).execute("");


        InsetBtn=(Button)findViewById(R.id.InsertBtn);
        searchbtn=(Button)findViewById(R.id.searchbtn);

        edit=(EditText)findViewById(R.id.searchtv);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NetWorkGet((Custom_Adapter)listView.getAdapter()).execute("");

                ArrayList<UserInfo> fList=new ArrayList<UserInfo>();
                ArrayList<UserInfo> fList2=new ArrayList<UserInfo>();

                String filterText = edit.getText().toString().toLowerCase(Locale.getDefault());
                fList=adapter.getList();

                if(fList==null){
                    new NetWorkGet((Custom_Adapter)listView.getAdapter()).execute("");
                }
                if(filterText.equals(""))
                    new NetWorkGet((Custom_Adapter)listView.getAdapter()).execute("");
                else{
                    if(fList==null) {
                        Toast.makeText(MainActivity.this, "검색을 제대로 해주세여", Toast.LENGTH_SHORT).show();
                    }
                    for(int i=0;i<fList.size();i++){
                        fList=adapter.getList();
                        String compare=fList.get(i).name.trim();
                        if(compare.toLowerCase().contains(filterText.toString())){
                            fList2.add(fList.get(i));
                        }
                    }
                    adapter=new Custom_Adapter(MainActivity.this,R.layout.adapter_userinfo,
                            fList2);
                    listView.setAdapter(adapter);
                }
            }
        });


        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                new NetWorkGet((Custom_Adapter)listView.getAdapter()).execute("");
            }
        });


        InsetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  View v=getLayoutInflater().inflate(R.layout.dialog_add,null);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("멤버추가")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String BOOKID=((EditText)v.findViewById(R.id.IdEdit)).getText().toString();
                                String BOOKNAME=((EditText)v.findViewById(R.id.NameEdit)).getText().toString();
                                String PUBLISH=((EditText)v.findViewById(R.id.PhoneEdit)).getText().toString();
                                String PRICE=((EditText)v.findViewById(R.id.GradeEdit)).getText().toString();
                                new NetWorkInsert(adapter).execute(BOOKID,BOOKNAME,PUBLISH,PRICE);
                                new NetWorkGet(adapter).execute("");

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

    }
}
