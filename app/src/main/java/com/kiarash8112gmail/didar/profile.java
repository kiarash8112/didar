package com.kiarash8112gmail.didar;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.telecom.ConnectionRequest;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.kiarash8112gmail.didar.R.id.imageView;
import static com.kiarash8112gmail.didar.R.id.user;

/**
 * Created by asus on 8/20/2017.
 */

public class profile extends AppCompatActivity {
    public static Bitmap userpicture;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        TextView name=(TextView)findViewById(R.id.name);
        TextView phone=(TextView)findViewById(R.id.phone);
        TextView username=(TextView)findViewById(R.id.username);
        TextView password=(TextView)findViewById(R.id.password);


        name.setText(navigation.name);
        phone.setText(navigation.phone);
        username.setText(navigation.username);
        password.setText(navigation.password);
        Button btnchangepicture=(Button)findViewById(R.id.btnchangepicture);
        btnchangepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final AlertDialog.Builder builder=new AlertDialog.Builder(profile.this);
                View view=getLayoutInflater().inflate(R.layout.gallaryorcamera,null);
                builder.setView(view);
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
                ImageView camera=(ImageView)view.findViewById(R.id.camera);
                camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, 18888);
                    }
                });
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 18888 && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            final ImageView user=(ImageView)findViewById(R.id.user);
            userpicture=photo;
            user.setImageBitmap(photo);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(profile.this,navigation.class);
        startActivity(intent);
        overridePendingTransition(R.anim.openscyle,R.anim.openscyle);
    }
}
