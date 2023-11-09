package com.kiarash8112gmail.didar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by asus on 7/12/2017.
 */

public class login extends AppCompatActivity {
    TextView password;
    TextView username;
    Button btncome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        password = (TextView) findViewById(R.id.password);
        username = (TextView) findViewById(R.id.username);
        btncome = (Button) findViewById(R.id.btncome);

        btncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginfunction();
            }
        });
    }

    public void loginfunction() {
        if (username.getText().toString().equals("MMkk") && password.getText().toString().equals("M50M59k81k84")) {

            Toast.makeText(this, "hello admin", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "you are not admin", Toast.LENGTH_SHORT).show();
        }
    }
}
