package com.kiarash8112gmail.didar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;

import java.util.ArrayList;

/**
 * Created by asus on 7/14/2017.
 */

public class friend extends AppCompatActivity {
   EditText fname;
   EditText fphone;
   EditText faddress;
   Button   creat;
   ImageView backimg;
    public static String pfname;
    public static String pfphone;
    public static String pfaddress;
    public static int i=-1;
    public static String freindaddresss;
    public static String freindname;
    public static Boolean getfreindvalenu=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freind);
        if(getfreindvalenu)
        {
            Intent intent=new Intent(friend.this,navigation.class);
            startActivity(intent);
            getfreindvalenu=false;
        }
        Toast.makeText(this, freindaddresss, Toast.LENGTH_SHORT).show();
       fname=(EditText)findViewById(R.id.fname);
       fphone=(EditText)findViewById(R.id.fphone);
       faddress=(EditText)findViewById(R.id.faddress);
        backimg=(ImageView)findViewById(R.id.backimg);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(friend.this,navigation.class);
                startActivity(intent);
                overridePendingTransition(R.anim.openscyle,R.anim.openscyle);
            }
        });
        creat=(Button)findViewById(R.id.creat);

        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fname.getText().toString().equals("") || fphone.getText().toString().equals("") || faddress.getText().toString().equals(""))
                {
                    Context context=getApplicationContext();
                    LayoutInflater inflater=getLayoutInflater();
                    View view=inflater.inflate(R.layout.typetoast,null);
                    Toast toast=new Toast(context);
                    toast.setView(view);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    if(fphone.getText().toString().length() == 11)
                    {
                        Context context=getApplicationContext();
                        LayoutInflater inflater=getLayoutInflater();
                        View view=inflater.inflate(R.layout.plusfreindtoast,null);
                        Toast toast=new Toast(context);
                        toast.setView(view);
                        toast.setGravity(Gravity.BOTTOM,0,0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                        pfname=fname.getText().toString();
                        pfphone=fphone.getText().toString();
                        pfaddress=faddress.getText().toString();
                        i++;

                        SharedPreferences savestring1=getSharedPreferences("string1",0);
                        freindaddresss=savestring1.getString("tvale1",pfaddress);

                    }
                    else
                    {
                        Context context=getApplicationContext();
                        LayoutInflater inflater=getLayoutInflater();
                        View view=inflater.inflate(R.layout.phonetoast,null);
                        Toast toast=new Toast(context);
                        toast.setView(view);
                        toast.setGravity(Gravity.BOTTOM,0,0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
    }

    @Override
    protected void onStop() {
        SharedPreferences savestring1=getSharedPreferences("string1",0);
        SharedPreferences.Editor editor1=savestring1.edit();
        editor1.putString("tvale1",freindaddresss);
        editor1.commit();
        super.onStop();
    }
}
