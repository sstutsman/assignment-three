package com.example.elise.assignment_three;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class SecondActivity extends Activity {

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

        /*Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("cover");
        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);*/

        //cover = (ImageView) findViewById(R.id.cover_2);
        //int link = getIntent().getIntExtra("coverURL",R.id.cover_2);
        name = (TextView) findViewById(R.id.name_2);
        artist = (TextView) findViewById(R.id.artist_2);
        track_count = (TextView) findViewById(R.id.track_count_2);
        year = (TextView) findViewById(R.id.year_2);
        publisher = (TextView) findViewById(R.id.publisher_2);

        //cover.setImageBitmap(bitmap);
        //cover.setImageResource(link);
        name.setText(getIntent().getStringExtra("name"));
        artist.setText(getIntent().getStringExtra("artist"));
        track_count.setText(getIntent().getStringExtra("tracks"));
        year.setText(getIntent().getStringExtra("year"));
        publisher.setText(getIntent().getStringExtra("publisher"));

    }

}
