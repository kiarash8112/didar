package com.kiarash8112gmail.didar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    Button login;
    Button register;
    ImageView logoimg;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            Intent intent =new Intent(ActivityMain.this,register.class);
            startActivity(intent);
            overridePendingTransition(R.anim.openscyle,R.anim.openscyle);
        } else {
            logoimg=(ImageView)findViewById(R.id.logoimg);
            register = (Button) findViewById(R.id.register);
            login=(Button)findViewById(R.id.login);
            Animation animation= AnimationUtils.loadAnimation(ActivityMain.this,R.anim.animation);
            Animation animation1= AnimationUtils.loadAnimation(ActivityMain.this,R.anim.openscyle);
            register.startAnimation(animation);
            login.startAnimation(animation);
            logoimg.startAnimation(animation1);
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(ActivityMain.this, login.class);
               startActivity(intent);
               overridePendingTransition(R.anim.openscyle, R.anim.openscyle);
           }
       });
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ActivityMain.this, register.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.openscyle, R.anim.openscyle);
                }
            });
        }
    }





    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
     }