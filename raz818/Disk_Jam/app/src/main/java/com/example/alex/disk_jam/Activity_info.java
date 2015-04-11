package com.example.alex.disk_jam;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alex on 4/10/2015.
 */
public class Activity_info extends Activity {

    ImageView albumArt;
    TextView title;
    TextView artist;
    TextView tracks;
    TextView year;
    TextView pub;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        albumArt = (ImageView) findViewById(R.id.ivAlbumArt2);
        title = (TextView) findViewById(R.id.tvTitle2);
        artist = (TextView) findViewById(R.id.tvArtist2);
        tracks = (TextView) findViewById(R.id.tvTracks2);
        year = (TextView) findViewById(R.id.tvYear2);
        pub = (TextView) findViewById(R.id.tvPublisher);

        albumArt.setImageResource(Integer.parseInt(getIntent().getStringExtra("albumArt")));
        title.setText("Title: "+getIntent().getStringExtra("title"));
        artist.setText("Artist: "+getIntent().getStringExtra("artist"));
        tracks.setText("Tracks: "+getIntent().getStringExtra("tracks"));
        year.setText("Year: "+Integer.parseInt(getIntent().getStringExtra("year")));
        pub.setText("Publisher: "+getIntent().getStringExtra("pub"));


    }
}
