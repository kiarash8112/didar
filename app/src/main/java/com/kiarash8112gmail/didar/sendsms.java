package com.kiarash8112gmail.didar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by asus on 8/10/2017.
 */

public class sendsms extends AppCompatActivity {
    EditText text;
    EditText phone;
    Button btnsendsms;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendsms);
        phone=(EditText)findViewById(R.id.phone);
        text=(EditText)findViewById(R.id.text);
        btnsendsms=(Button)findViewById(R.id.btnsendsms);
       ImageView backimg=(ImageView)findViewById(R.id.backimg);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(sendsms.this,navigation.class);
                startActivity(intent);
                overridePendingTransition(R.anim.openscyle,R.anim.closescyle);
            }
        });
        btnsendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textsend=text.getText().toString();
                String number=phone.getText().toString();
                if(number.length()==11)
                {
                    if(textsend.equals(""))
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
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number));
                        intent.putExtra("sms_body", textsend);
                        startActivity(intent);
                    }

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
        });
    }
}
