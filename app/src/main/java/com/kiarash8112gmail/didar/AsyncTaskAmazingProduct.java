package com.kiarash8112gmail.didar;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by asus on 7/26/2017.
 */

public class AsyncTaskAmazingProduct extends AsyncTask {
    public String link;
    public String name;
    public String phone;
    public String username;
    public String password;

    public AsyncTaskAmazingProduct(String link,String name,String phone,String username,String password) {
        this.link = link;
        this.name=name;
        this.phone=phone;
        this.username=username;
        this.password=password;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        try {
            String data= URLEncoder.encode("name","UTF8")+"="+URLEncoder.encode(name,"UTF8");
            data+="&"+URLEncoder.encode("phone","UTF8")+"="+URLEncoder.encode(phone,"UTF8");
            data+="&"+URLEncoder.encode("username","UTF8")+"="+URLEncoder.encode(username,"UTF8");
            data+="&"+URLEncoder.encode("password","UTF8")+"="+URLEncoder.encode(password,"UTF8");
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter writer=new OutputStreamWriter(connection.getOutputStream());
            writer.write(data);
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            Connect.amazingProduct = builder.toString();
        } catch (Exception e) {
        }
        return false;
    }
}