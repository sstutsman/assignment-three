package com.example.elise.assignment_three;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Elise Johnson on 4/7/2015.
 */

public class SecondActivity extends Activity {

    //Variables
    ImageView cover;
    TextView name;
    TextView artist;
    TextView track_count;
    TextView year;
    TextView publisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Converting the byte array into a bitmap for the ImageView
        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("cover");
        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);

        //Mapping views
        cover = (ImageView) findViewById(R.id.cover_2);
        name = (TextView) findViewById(R.id.name_2);
        artist = (TextView) findViewById(R.id.artist_2);
        track_count = (TextView) findViewById(R.id.track_count_2);
        year = (TextView) findViewById(R.id.year_2);
        publisher = (TextView) findViewById(R.id.publisher_2);

        //Assign values from the albums list to the views
        cover.setImageBitmap(bitmap);
        name.setText("Album: "+getIntent().getStringExtra("name"));
        artist.setText("Artist: "+getIntent().getStringExtra("artist"));
        track_count.setText(getIntent().getStringExtra("tracks")+" tracks");
        year.setText("Released in "+getIntent().getStringExtra("year"));
        publisher.setText("Published by "+getIntent().getStringExtra("publisher"));

    }

}
