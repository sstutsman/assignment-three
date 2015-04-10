package com.example.br161.peterassignment_cubed;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class FullAlbumActivity extends ActionBarActivity {

    ImageView imgAlbumCover_full;
    TextView artistName_full,
            albumName_full,
            publisher_full,
            year_full,
            genre_full,
            track_static_full,
            trackAmt_full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_albumlisting_full2);

        imgAlbumCover_full  = (ImageView) findViewById(R.id.draw_albumcover_full);
        imgAlbumCover_full.setImageResource(Integer.parseInt(getIntent().getStringExtra("albumArt")));

        artistName_full     = (TextView) findViewById(R.id.tv_artistName_full);
        artistName_full.setText(getIntent().getStringExtra("artistName"));

        albumName_full      = (TextView) findViewById(R.id.tv_albumName_full);
        albumName_full.setText(getIntent().getStringExtra("albumName"));

        publisher_full      = (TextView) findViewById(R.id.tv_publisher_full);
        publisher_full.setText(getIntent().getStringExtra("publisher"));

        year_full           = (TextView) findViewById(R.id.tv_year_full);
        year_full.setText(getIntent().getStringExtra("year"));

        genre_full          = (TextView) findViewById(R.id.tv_genre_full);
        genre_full.setText(getIntent().getStringExtra("genre"));

        track_static_full   = (TextView) findViewById(R.id.tv_static_track);
        //It has a value in values/strings.xml

        trackAmt_full       = (TextView) findViewById(R.id.tv_trackAmt_full);
        trackAmt_full.setText(getIntent().getStringExtra("trackCt"));


    }


}
