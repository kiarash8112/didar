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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
/**
 * Created by asus on 7/19/2017.
 */

public class navigation extends AppCompatActivity implements OnMapReadyCallback{

    boolean mall;
    boolean gym;
    boolean restraunt;
    boolean park;
    boolean coffee;
    public static boolean circlemy=false;
    public static boolean circlefreind=false;
    Button opennavigation;
    DrawerLayout drawer;
    NavigationView navigation;
    GoogleMap mMap;
    Circle shape;
    public static String freindname;
    public static String freindaddress;
    public static String freindphone;
    public static String name=register.myname;
    public static String phone=register.pphone;
    public static String username=register.pusername;
    public static String password=register.ppassword;
    public static String user;
    SharedPreferences sharedPreferences;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
            Intent intent=new Intent(navigation.this,rezerve.class);
        startActivity(intent);
            ///////////////////////////////////////////////////shareprefaces
            if (friend.getfreindvalenu) {
                Intent intent2 = new Intent(navigation.this, friend.class);
                startActivity(intent2);
            }
            SharedPreferences savestring = getSharedPreferences("string", 0);
            name = savestring.getString("tvale", register.myname);


            SharedPreferences savestring3 = getSharedPreferences("string3", 0);
            phone = savestring3.getString("tvale3", register.pphone);


            SharedPreferences savestring4 = getSharedPreferences("string4", 0);
            username = savestring4.getString("tvale4", register.pusername);

            Toast.makeText(this, profile.userpicture + "", Toast.LENGTH_SHORT).show();

            SharedPreferences savestring5 = getSharedPreferences("string5", 0);
            password = savestring5.getString("tvale5", register.ppassword);


            SharedPreferences savestring1 = getSharedPreferences("string1", 0);
            friend.freindaddresss = savestring1.getString("tvale1", friend.freindaddresss);
            ///////////////////////music play

            ///////////////////////////////////////////////////////shareprefaces


            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(navigation.this);
            boolean mycircle = sharedPreferences.getBoolean("mycircle", false);
            boolean freindcircle = sharedPreferences.getBoolean("freindcircle", false);
            if (freindcircle) {
                circlefreind = true;
                ///Toast.makeText(this,"freind circle is true", Toast.LENGTH_SHORT).show();
            }
            if (freindcircle == false) {
                circlefreind = false;
                /// Toast.makeText(this, "freind circle is false", Toast.LENGTH_SHORT).show();
            }
            if (mycircle) {
                circlemy = true;
                // Toast.makeText(this, "my circle is true", Toast.LENGTH_SHORT).show();
            } else if (mycircle == false) {
                //Toast.makeText(this, "my circle is false", Toast.LENGTH_SHORT).show();
                circlemy = false;
            }


            ////////////////////////////////////////////////////////////////////////////////////////////////////checkgps
            final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(navigation.this);
                View view = getLayoutInflater().inflate(R.layout.gps, null);
                builder.setView(view);
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
                Button againgps = (Button) view.findViewById(R.id.againgps);
                againgps.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(navigation.this, navigation.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.openscyle);
                    }
                });
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////setbooleanforchoseplace


            Animation animation = AnimationUtils.loadAnimation(navigation.this, R.anim.animation);
            /////////////////////////////////////////////////////////////////////////////////////////navigation


            navigation = (NavigationView) findViewById(R.id.navigation);
            drawer = (DrawerLayout) findViewById(R.id.drawer);
            opennavigation = (Button) findViewById(R.id.opennavigation);
            final Button findplace = (Button) findViewById(R.id.findplace);
            //Animation animation= AnimationUtils.loadAnimation(navigation.this,R.anim.animation);
            opennavigation.startAnimation(animation);
            findplace.startAnimation(animation);

            opennavigation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation = AnimationUtils.loadAnimation(navigation.this, R.anim.true_rotate);
                    opennavigation.startAnimation(animation);
                    drawer.openDrawer(Gravity.RIGHT);
                }
            });

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);


            navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.me) {
                        Intent intent = new Intent(navigation.this, profile.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.openscyle);
                    }
                    if (id == R.id.opentelegram) {
                        Intent intent = new Intent(navigation.this, telegram.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.closescyle);
                    }
                    if (id == R.id.callmenu) {
                        Intent intent = new Intent(navigation.this, call.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.closescyle);
                    }
                    if (id == R.id.sms) {
                        Intent intent = new Intent(navigation.this, sendsms.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.closescyle);
                    }
                    if (id == R.id.home) {
                        drawer.closeDrawer(Gravity.RIGHT);
                    }
                    if (id == R.id.setting) {
                        Intent intent = new Intent(navigation.this, setting.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.closescyle);
                    }
                    if (id == R.id.addfreind) {
                        Intent intent = new Intent(navigation.this, friend.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.closescyle);
                    }
                    if (id == R.id.support) {
                        Intent intent = new Intent(navigation.this, support.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.openscyle, R.anim.closescyle);
                    }
                    return false;
                }
            });

            ////////////////////////////////////////////////findplace

            findplace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(navigation.this);
                    View view = getLayoutInflater().inflate(R.layout.kindofmeet, null);
                    builder.setView(view);
                    builder.setCancelable(false);
                    final AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    final Button lovemeet = (Button) view.findViewById(R.id.lovemeet);
                    final Button freindmeet = (Button) view.findViewById(R.id.freindmeet);
                    final Button fmeet = (Button) view.findViewById(R.id.fmeet);
                    final TextView txtkindofmeet=(TextView)view.findViewById(R.id.txtkindofmeet);
                    //final TextView introdius=(TextView)view.findViewById(R.id.introdius);
                    final Button workmeet = (Button) view.findViewById(R.id.workmeet);
                    lovemeet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Animation animation = AnimationUtils.loadAnimation(navigation.this, R.anim.animation);
                            //      introdius.startAnimation(animation);
                            freindmeet.startAnimation(animation);
                            fmeet.startAnimation(animation);
                            workmeet.startAnimation(animation);
                            lovemeet.startAnimation(animation);
                            txtkindofmeet.startAnimation(animation);
                            fmeet.setText("کافی شاپ");
                            freindmeet.setText("رستوران");
                            lovemeet.setText("پارک");
                            workmeet.setText("فروشگاه");
                            txtkindofmeet.setText("مکان های دیدار پیشنهادی برای شما :");
                            fmeet.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(navigation.this, "coffe shop clicked", Toast.LENGTH_SHORT).show();
                                }
                            });
                            workmeet.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(navigation.this, "mall clicked", Toast.LENGTH_SHORT).show();
                                }
                            });
                            freindmeet.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(navigation.this, "restraunt clicked", Toast.LENGTH_SHORT).show();
                                }
                            });
                            lovemeet.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(navigation.this, "park clicked", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    workmeet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(navigation.this, "work ckicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                    fmeet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(navigation.this, "f clicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                    freindmeet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(navigation.this, "freind clicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when tethe map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(ServiceOk())
        {
            onSearch();

            try {
                addfreind();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         else
        {
            Toast.makeText(this, "متاسفانه به سرویس گوگل متصل نشد", Toast.LENGTH_SHORT).show();
        }

    }
    ///////////////////////////////////////////////service ok
    public boolean ServiceOk()
    {
        int isAvailbale= GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(isAvailbale== ConnectionResult.SUCCESS)
        {
            return true;
        }
        else if(GooglePlayServicesUtil.isUserRecoverableError(isAvailbale))
        {
            int gpserrorload=9001;
            Dialog dialog=GooglePlayServicesUtil.getErrorDialog(isAvailbale,this,gpserrorload);
        }
        else
        {
            Toast.makeText(this, "???????? ????????? ?? ?????? ???? ???? ????" , Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    //////////////////////////////////////////////////////onsearch
    public void onSearch() {
        GPSTracker gps = new GPSTracker(this);
        double latitude = gps.getLatitude();
        double longitude = gps.getLongitude();
        LatLng latLng = new LatLng( gps.getLatitude(), gps.getLongitude());
        MarkerOptions option=new MarkerOptions();
        option.position(latLng);
        option.title(name);
        option.icon(BitmapDescriptorFactory.fromResource(R.drawable.meeticonmap));
        option.anchor(.5f,.5f);
        option.draggable(true);
        mMap.addMarker(option);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14.0f));
        if(circlemy)
        drawecircle(latLng);
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View view=getLayoutInflater().inflate(R.layout.meonmap,null);
                TextView usertext=(TextView)view.findViewById(R.id.usertext);
                ImageView imguser=(ImageView)view.findViewById(R.id.imguser);
                usertext.setText(name);
                if(profile.userpicture!=null)
                    imguser.setImageBitmap(profile.userpicture);
                 if(profile.userpicture==null)
                {
                    imguser.setImageResource(R.drawable.users);
                }
                return view;
            }
        });
    }
    //////////////////////////////////////////////////////circle
    public void drawecircle(LatLng latLng)
    {
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(latLng)
                .radius(1000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.GREEN));
    }
    //////////////////////////////////////////////////////markeradd
   public void addmarker(LatLng latLng, final String title)
   {
       MarkerOptions options=new MarkerOptions();
       options.title(title);
       options.position(latLng);
       options.anchor(.5f,.5f);
       options.draggable(true);
       options.anchor(.5f,.5f);
       options.draggable(true);
       mMap.addMarker(options);
       options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
       mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));

       mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
           @Override
           public View getInfoWindow(Marker marker) {
               return null;
           }

           @Override
           public View getInfoContents(Marker marker) {
               View view=getLayoutInflater().inflate(R.layout.mapwindowsinfo,null);
               TextView meetplacename=(TextView)view.findViewById(R.id.meetplacename);
               meetplacename.setText(title);
               return view;
           }
       });
   }
   //////////////////////////////////////////////////////////addfreind
    public void addfreind() throws IOException {
        for (int i = 0; i<=friend.i; i++)
        {
            freindname=friend.pfname;
          freindaddress=friend.pfaddress;
          freindphone=friend.pfphone;
            ///////////////////////////////////////name
           mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
               @Override
               public void onInfoWindowClick(Marker marker) {
                   Toast.makeText(navigation.this, "ارین هم به دیدار اضافه شد", Toast.LENGTH_SHORT).show();
               }
           });
            ////////////////////////////////////////////
            Geocoder gc=new Geocoder(navigation.this);
            ArrayList<Address> addresses= (ArrayList<Address>) gc.getFromLocationName(freindaddress,1000);
            Address add=addresses.get(friend.i);
            double lat=add.getLatitude();
            double lot=add.getLongitude();
            LatLng latLng=new LatLng(lat,lot);
            MarkerOptions options=new MarkerOptions();
            options.title(freindname);
            options.position(latLng);
            options.anchor(.5f,.5f);
            options.draggable(true);
            mMap.addMarker(options);
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));

            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                   final View view=getLayoutInflater().inflate(R.layout.freindinfowindows,null);
                    TextView freindtext=(TextView)view.findViewById(R.id.freindtext);
                    final Switch swichhangout=(Switch)view.findViewById(R.id.swichhangout);
                    ImageView imgfreind=(ImageView)view.findViewById(R.id.imgfreind);
                    freindtext.setText(freindname);
                    swichhangout.setChecked(true);
                    return view;
                }
            });
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    final View view=getLayoutInflater().inflate(R.layout.freindinfowindows,null);
                    final Switch swichhangout=(Switch)view.findViewById(R.id.swichhangout);
                    swichhangout.setChecked(true);
                    Toast.makeText(navigation.this, "salam", Toast.LENGTH_SHORT).show();
                }
            });
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14.0f));
            if(circlefreind)
            drawecircle(latLng);

        }

    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        }
        else
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,2,1,"حالت معمولی");
        menu.add(0,3,2,"حالت SATELLITE");
        menu.add(0,4,3,"حالت مرز");
        menu.add(0,5,4,"حالت ترکیبی");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case 3:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case 4:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case 5:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case 1: {
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {

                }
                else
                {

                }
            }

        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences savestring=getSharedPreferences("string",0);
        SharedPreferences.Editor editor=savestring.edit();
        editor.putString("tvale",name);
        editor.commit();


        SharedPreferences savestring3=getSharedPreferences("string3",0);
        SharedPreferences.Editor editor3=savestring3.edit();
        editor3.putString("tvale3",phone);
        editor3.commit();



        SharedPreferences savestring4=getSharedPreferences("string4",0);
        SharedPreferences.Editor editor4=savestring4.edit();
        editor4.putString("tvale4",username);
        editor4.commit();

        SharedPreferences savestring5=getSharedPreferences("string5",0);
        SharedPreferences.Editor editor5=savestring5.edit();
        editor5.putString("tvale5",password);
        editor5.commit();

        SharedPreferences savestring1=getSharedPreferences("string1",0);
        SharedPreferences.Editor editor1=savestring1.edit();
        editor1.putString("tvale1",friend.freindaddresss);
        editor1.commit();

    }
}