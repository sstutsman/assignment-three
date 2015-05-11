package com.example.imac.myalbum;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.InflateException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclermyAlbums;

    private List<myAlbum> albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclermyAlbums = (RecyclerView) findViewById(R.id.recycler_albums);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclermyAlbums.setLayoutManager(layoutManager);

        albums = mockmyAlbums();

        recyclermyAlbums.setAdapter(new myAlbumAdapter(albums));
    }//end onCreate method

    private List<myAlbum> mockmyAlbums() {

        List<myAlbum> albums = new ArrayList<>();
        //String AlbumName, String artist, int trackCount, int year,
        albums.add(new myAlbum("Beyonce","Beyonce",10,1996,"Columbia",R.drawable.beyonce));
        albums.add(new myAlbum("Beyonce","Beyonce",10,1996,"Columbia",R.drawable.beyonce));
        albums.add(new myAlbum("Beyonce","Beyonce",10,1996,"Columbia",R.drawable.beyonce));
        albums.add(new myAlbum("Beyonce","Beyonce",10,1996,"Columbia",R.drawable.beyonce));
        albums.add(new myAlbum("Beyonce","Beyonce",10,1996,"Columbia",R.drawable.beyonce));



        return albums;
    }
}//end MainActivity class