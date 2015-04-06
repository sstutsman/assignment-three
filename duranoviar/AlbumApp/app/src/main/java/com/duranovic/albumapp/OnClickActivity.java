package com.duranovic.albumapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class OnClickActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);

        // retrieve the Data
        Bitmap image = (Bitmap)this.getIntent().getParcelableExtra("image");
        String description = (String)this.getIntent().getStringExtra("description");
    }
}
