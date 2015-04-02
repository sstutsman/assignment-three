package com.example.br161.assignmentthree;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class AlbumView extends Activity {

    private ImageView imageAlbum;

    private TextView tvTitle;

    private TextView tvArtist;

    private TextView tvPublisher;

    private TextView tvGenre;

    private TextView tvNumTracks;

    private TextView tvYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_view);

        imageAlbum = (ImageView) findViewById(R.id.image_album_cover_large);
        tvTitle = (TextView) findViewById(R.id.tv_title_large);
        tvArtist = (TextView) findViewById(R.id.tv_artist_large);
        tvPublisher = (TextView) findViewById(R.id.tv_publisher_large);
        tvGenre = (TextView) findViewById(R.id.tv_genre_large);
        tvNumTracks = (TextView) findViewById(R.id.tv_num_tracks_large);
        tvYear = (TextView) findViewById(R.id.tv_year_large);

        imageAlbum.setImageResource(getIntent().getIntExtra("albumCoverID", -1));
        tvTitle.setText(getIntent().getStringExtra("title"));
        tvArtist.setText(getIntent().getStringExtra("artist"));
        tvPublisher.setText(getIntent().getStringExtra("publisher"));
        tvGenre.setText(getIntent().getStringExtra("genre"));
        tvNumTracks.setText(getIntent().getIntExtra("numTracks", -1) + " tracks");
        tvYear.setText(getIntent().getIntExtra("year", -1) + "");
    }//end onCreate method
}//end AlbumView class