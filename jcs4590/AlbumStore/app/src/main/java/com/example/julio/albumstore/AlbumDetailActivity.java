package com.example.julio.albumstore;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;


public class AlbumDetailActivity extends Activity {

    Album.Paging trackPaging;
    Album.Track[] tracks;
    TrackListAdapter trackListAdapter;

    Album album;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_album_detail);
        String albumString = getIntent().getExtras().getString("album");
        Gson gson = new Gson();

        album = gson.fromJson(albumString,Album.class);
        trackPaging = album.getTracks();

        //Data source for tracks list view
        tracks = gson.fromJson(gson.toJson(trackPaging.getItems()), Album.Track[].class);
        //trackListAdapter = new TrackListAdapter(getApplicationContext(),tracks);
        ListAdapter trackListAdapter =  new TrackListAdapter(getApplicationContext(),tracks);
        ListView trackListView = (ListView) findViewById(R.id.trackslistView);
        trackListView.setAdapter(trackListAdapter);

        //set up top view items
        TextView albumNameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView artistNameTextView = (TextView) findViewById(R.id.artistNameTextView);
        ImageView albumImageView = (ImageView) findViewById(R.id.albumImageView);
        TextView publisherTextView = (TextView) findViewById(R.id.publisherTextView);
        Picasso.with(albumImageView.getContext()).load(album.getImages()[0].getUrl()).into(albumImageView);
        albumNameTextView.setText(album.getName());
        publisherTextView.setText(album.getCopyrights()[0].getText());
        artistNameTextView.setText(album.getArtists()[0].getName());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_album_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("Kobe the CAT","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        TrackListAdapter.mediaPlayer.release();
        Log.w("Kobe the CAT", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Kobe the CAT","onPause");

    }
}

