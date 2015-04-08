package com.example.freitagamb.assignmentthree;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class more_info extends Activity {
    private RecyclerView tracksRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<AlbumInfo> albums;
        albums = AlbumInfo.setData();
        int i = getIntent().getExtras().getInt("pos");

        setContentView(R.layout.more_info);

        tracksRV = (RecyclerView) findViewById(R.id.trackRecyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        tracksRV.setLayoutManager(llm);
        tracksRV.setHasFixedSize(true);
        TrackAdapter adapter = new TrackAdapter(AlbumInfo.getTracks(albums, i));
        tracksRV.setAdapter(adapter);

        TextView artist = (TextView) findViewById(R.id.txtArtistName);
        ImageView coverArt = (ImageView) findViewById(R.id.coverArt);
        TextView albumName = (TextView) findViewById(R.id.txtAlbumName);
        TextView year = (TextView) findViewById(R.id.txtYear);
        TextView publisher = (TextView) findViewById(R.id.txtPublisher);
        TextView trackNum = (TextView) findViewById(R.id.txtTrackNum);

        coverArt.setImageResource(albums.get(i).artID);
        artist.setText(albums.get(i).artist);
        albumName.setText(albums.get(i).album);
        year.setText("(" + Integer.toString(albums.get(i).year) + ")");
        publisher.setText(albums.get(i).publisher);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}