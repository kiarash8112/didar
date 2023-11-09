package com.kiarash8112gmail.didar;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
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

public class telegram extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telegram);
        ImageView backimg = (ImageView) findViewById(R.id.backimg);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telegram.this, navigation.class);
                startActivity(intent);
                overridePendingTransition(R.anim.openscyle, R.anim.closescyle);
            }
        } );
        final EditText massage=(EditText)findViewById(R.id.massage);
        Button send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,massage.getText().toString());
                sendIntent.setType("text/plain");
                sendIntent.setPackage("org.telegram.messenger");
                try{
                    startActivity(sendIntent);
                }
                catch (ActivityNotFoundException ex){
                    Context context=getApplicationContext();
                    LayoutInflater inflater=getLayoutInflater();
                    View view=inflater.inflate(R.layout.telegramtoast,null);
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
