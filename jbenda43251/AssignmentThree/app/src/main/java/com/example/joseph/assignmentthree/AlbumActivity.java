package com.example.joseph.assignmentthree;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class AlbumActivity extends ActionBarActivity {

    TextView tvName;
    TextView tvArtist;
    TextView tvTrack_count;
    TextView tvYear;
    TextView tvPubliser;
    ImageView ivCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(getIntent().getStringExtra("name"));

        tvArtist = (TextView) findViewById(R.id.tv_artist);
        tvArtist.setText(getIntent().getStringExtra("artist"));

        tvTrack_count = (TextView) findViewById(R.id.tv_track_count);
        tvTrack_count.setText(getIntent().getStringExtra("track_count"));

        tvYear = (TextView) findViewById(R.id.tv_year);
        tvYear.setText(getIntent().getStringExtra("year"));

        tvPubliser = (TextView) findViewById(R.id.tv_publisher);
        tvPubliser.setText(getIntent().getStringExtra("publisher"));

        ivCover = (ImageView) findViewById(R.id.iv_cover_art);
        ivCover.setImageResource(Integer.parseInt(getIntent().getStringExtra("cover")));

    }
}
