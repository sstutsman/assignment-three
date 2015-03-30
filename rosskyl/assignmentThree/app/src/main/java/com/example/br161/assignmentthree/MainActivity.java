package com.example.br161.assignmentthree;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerAlbums;

    private List<Album> albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerAlbums = (RecyclerView) findViewById(R.id.recycler_albums);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerAlbums.setLayoutManager(layoutManager);

        albums = mockAlbums();


    }//end onCreate method

    private List<Album> mockAlbums() {

        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Skid Row", "Skid Row", "Atlantic", "Rock", "skidRow", 11, 1989));

        return albums;
    }//end mockAlbums method
}//end MainActivity class