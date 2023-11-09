package com.kiarash8112gmail.didar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by asus on 7/13/2017.
 */

public class register extends AppCompatActivity {
    EditText name;
    EditText phone;
    EditText username;
    EditText password;
    Button btnregister;
    public static String pphone;
    public static String pusername;
    public static String ppassword;
public  static String myname;

    public  static boolean registerend=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            registerend=true;
            Intent intent =new Intent(register.this,checknet.class);
            startActivity(intent);
            overridePendingTransition(R.anim.openscyle,R.anim.openscyle);

        } else {
            password = (EditText) findViewById(R.id.password);
            username = (EditText) findViewById(R.id.username);
            phone = (EditText) findViewById(R.id.phone);
            name = (EditText) findViewById(R.id.name);
            btnregister = (Button) findViewById(R.id.btnregister);


            btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (name.getText().toString().equals("") || phone.getText().toString().equals("") || username.getText().toString().equals("") || password.getText().toString().equals("")) {
                        Context context=getApplicationContext();
                        LayoutInflater inflater=getLayoutInflater();
                        View view=inflater.inflate(R.layout.typetoast,null);
                        Toast toast=new Toast(context);
                        toast.setView(view);
                        toast.setGravity(Gravity.BOTTOM,0,0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        if (phone.getText().toString().length() == 11) {
                            if (password.getText().toString().length() < 5) {
                                Toast.makeText(register.this, "رمز عبور باید بیشتر از 5 حرف باشد", Toast.LENGTH_SHORT).show();
                            } else {
                                pphone=phone.getText().toString();
                                pusername =username.getText().toString();
                                ppassword=password.getText().toString();
                                SharedPreferences.Editor ed = pref.edit();
                                ed.putBoolean("activity_executed", true);
                                ed.commit();
                                myname=name.getText().toString();
                                Intent intent = new Intent(register.this, checknet.class);
                                startActivity(intent);
                                new AsyncTaskAmazingProduct("http://localhost:8080/clicksite_shop/check",name.getText().toString(),phone.getText().toString(),username.getText().toString(),password.getText().toString()).execute();
                                overridePendingTransition(R.anim.openscyle,R.anim.closescyle);
                            }

                        } else {
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


    }
}
