package com.example.imac.myalbum;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class myAlbumView extends Activity {

    private ImageView albumImage;
    private TextView TvAlbumName;
    private TextView TvArtist;
    private TextView TvTrackCount;
    private TextView TvYear;
    private TextView TvPublisher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_album_view);

        albumImage = (ImageView) findViewById(R.id.image_album_cover);
        TvAlbumName = (TextView) findViewById(R.id.Tv_albumName);
        TvArtist = (TextView) findViewById(R.id.Tv_artist);
        TvTrackCount = (TextView) findViewById(R.id.Tv_trackCount);
        TvYear = (TextView) findViewById(R.id.Tv_year);
        TvPublisher = (TextView) findViewById(R.id.Tv_publisher);

        albumImage.setImageResource(getIntent().getIntExtra("albumCoverID", -1));
        TvAlbumName.setText(getIntent().getStringExtra("title"));
        TvArtist.setText(getIntent().getStringExtra("artist"));
        TvTrackCount.setText(getIntent().getStringExtra("genre"));
        TvYear.setText(getIntent().getIntExtra("numTracks", -1) + " tracks");
        TvPublisher.setText(getIntent().getIntExtra("year", -1) + "");
    }//end onCreate method
}//end AlbumView class