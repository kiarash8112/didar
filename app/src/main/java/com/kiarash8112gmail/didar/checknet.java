package com.kiarash8112gmail.didar;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.List;

/**
 * Created by asus on 7/25/2017.
 */

public class checknet extends AppCompatActivity {
    public static boolean checklogin=false;
   TextView neterror;
    Button phonenet;
    Button wifi;
    Button again;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ConnectivityManager manager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo=manager.getActiveNetworkInfo();
        SharedPreferences check= PreferenceManager.getDefaultSharedPreferences(checknet.this);
        checklogin=check.getBoolean("checklogin",true);
        if(networkinfo != null && networkinfo.isConnected())
        {
           Intent intent=new Intent(checknet.this, checkpermisson.class);
            startActivity(intent);
        }
        else
        {
            setContentView(R.layout.checknetview);
            final AlertDialog.Builder builder=new AlertDialog.Builder(checknet.this);
            builder.setCancelable(false);
            View view=getLayoutInflater().inflate(R.layout.checknet,null);
            builder.setView(view);
            AlertDialog dialog=builder.create();
            builder.show();
            neterror=(TextView)findViewById(R.id.neterror);
            wifi=(Button) view.findViewById(R.id.wifi);
            phonenet=(Button)view.findViewById(R.id.phonenet);
            again=(Button)view.findViewById(R.id.again);
            wifi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                }
            });
            phonenet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                }
            });
            ConnectivityManager manager1=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
            NetworkInfo networkinfo1=manager.getActiveNetworkInfo();
            if(networkinfo != null && networkinfo.isConnected())
            {
                Intent intent=new Intent(checknet.this,friend.class);
                startActivity(intent);
            }
            again.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent intent=new Intent(checknet.this,checknet.class);
                    startActivity(intent);
                }
            });

        }
    }

    }


