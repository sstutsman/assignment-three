package com.duranovic.albumapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class OnClickActivity extends Activity {

    TextView tvDescription_onclick;
    TextView tvTracks;
    ImageView ivImage_onclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);

        // retrieve the Data
        String description = (String)this.getIntent().getStringExtra("name");
        String tracks = (String)this.getIntent().getStringExtra("tracks");

        // map to the views
        tvDescription_onclick = (TextView) findViewById(R.id.tv_description_onclick);
        tvTracks = (TextView) findViewById(R.id.tv_description_tracks);
        ivImage_onclick = (ImageView) findViewById(R.id.iv_image_onclick);


        // set the image
        ivImage_onclick.setImageResource((Integer.parseInt(getIntent().getStringExtra("image"))));

        // set the description text
        tvDescription_onclick.setText(description);

        // set the tracks
        tvTracks.setText("--------------------TRACKS--------------------\n" + tracks);
    }
}
