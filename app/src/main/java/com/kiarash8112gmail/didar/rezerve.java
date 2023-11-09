package com.kiarash8112gmail.didar;

/**
 * Created by asus on 8/22/2017.
 */

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
public class rezerve extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezerve);
        Button btnsetdata=(Button)findViewById(R.id.btnsetdata);
        Button btnsettime=(Button)findViewById(R.id.btnsettime);
        Button rezerve=(Button)findViewById(R.id.rezerve);
        EditText edtnumberofperson=(EditText) findViewById(R.id.edtnumberofperson);
        btnsetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog a=new DatePickerDialog(rezerve.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                },2017,1,1);
                a.show();
            }
        });
    }
}
