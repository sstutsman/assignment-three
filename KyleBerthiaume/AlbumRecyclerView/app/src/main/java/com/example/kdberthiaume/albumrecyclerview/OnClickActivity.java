package com.example.kdberthiaume.albumrecyclerview;

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
    TextView tvTracksList;
    ImageView ivImage_onclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);

        // Acquiring the Data
        Bitmap image = (Bitmap)this.getIntent().getParcelableExtra("image");
        String description = (String)this.getIntent().getStringExtra("name");
        String tracks = (String)this.getIntent().getStringExtra("tracks");

        // Mapping views
        tvDescription_onclick = (TextView) findViewById(R.id.tv_onclick);
        tvTracksList = (TextView) findViewById(R.id.tv_tracks_list);
        ivImage_onclick = (ImageView) findViewById(R.id.iv_art_image);


        // setting image
        ivImage_onclick.setImageBitmap(image);

        // set text
        tvDescription_onclick.setText(description);

        // set the tracks
        tvTracksList.setText("Track List:\n" + tracks);
    }
}
