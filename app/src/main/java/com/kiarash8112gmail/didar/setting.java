package com.kiarash8112gmail.didar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by asus on 7/14/2017.
 */

public class setting extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,new settingxml()).commit();
    }

    public static class settingxml extends PreferenceFragment
        {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting);
        }
    }

    @Override
    public void onBackPressed() {
       Intent intent =new Intent(setting.this,navigation.class);
        startActivity(intent);
        overridePendingTransition(R.anim.openscyle,R.anim.openscyle);
    }
}

