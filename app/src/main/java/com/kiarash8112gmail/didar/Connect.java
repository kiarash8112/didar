package com.kiarash8112gmail.didar;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;

/**
 * Created by asus on 7/26/2017.
 */

public class Connect extends AppCompatActivity {
    public static String amazingProduct;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new AsyncTaskAmazingProduct("http://localhost:8080/clicksite_shop/addmember.php","","","","").execute();
    }
}
