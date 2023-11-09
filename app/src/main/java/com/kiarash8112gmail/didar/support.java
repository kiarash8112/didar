package com.kiarash8112gmail.didar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by asus on 7/24/2017.
 */

public class support extends AppCompatActivity {
    Button btnsend;
    EditText bug;
    TextView text1;
    EditText support;
    ImageView backimg;
    Typeface typeface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);
        text1=(TextView)findViewById(R.id.text1);
        TextView text2=(TextView)findViewById(R.id.text2);
        TextView text3=(TextView)findViewById(R.id.text3);
        typeface=Typeface.createFromAsset(getAssets(),"BBardiya.ttf");
        text1.setTypeface(typeface);
        text2.setTypeface(typeface);
        text3.setTypeface(typeface);
        btnsend=(Button)findViewById(R.id.btnsend);
        support=(EditText) findViewById(R.id.support);
        bug=(EditText) findViewById(R.id.bug);
        backimg=(ImageView)findViewById(R.id.backimg);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(support.this,navigation.class);
                startActivity(intent);
            overridePendingTransition(R.anim.openscyle,R.anim.closescyle);
            }
        });
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(support.getText().toString().equals("") || support.getText().toString().length() < 15)
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
               else {
                    Context context=getApplicationContext();
                    LayoutInflater inflater=getLayoutInflater();
                    View view=inflater.inflate(R.layout.supportoktoast,null);
                    Toast toast=new Toast(context);
                    toast.setView(view);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();


                    String myemail="kiarash8112@gmail.com";
                    Intent  send=new Intent(Intent.ACTION_SEND);
                    send.putExtra(Intent.EXTRA_EMAIL,myemail);
                    send.setType("plain/text");
                    send.putExtra(Intent.EXTRA_TEXT,support.getText().toString());
                    send.putExtra(Intent.EXTRA_TEXT,bug.getText().toString());
                    startActivity(send);

                    Intent intent=new Intent(support.this,navigation.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.openscyle,R.anim.openscyle);

                }
            }
        });
    }
}
