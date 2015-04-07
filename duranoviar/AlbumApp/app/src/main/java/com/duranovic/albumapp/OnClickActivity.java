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
        Bitmap image = (Bitmap)this.getIntent().getParcelableExtra("image");
        String description = (String)this.getIntent().getStringExtra("name");

        // map to the views
        tvDescription_onclick = (TextView) findViewById(R.id.tv_description_onclick);
        ivImage_onclick = (ImageView) findViewById(R.id.iv_image_onclick);


        // set the image
        ivImage_onclick.setImageBitmap(image);

        // set the description text
        tvDescription_onclick.setText(description);
    }
}
