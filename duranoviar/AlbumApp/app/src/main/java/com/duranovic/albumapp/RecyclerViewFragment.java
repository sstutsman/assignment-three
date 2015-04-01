package com.duranovic.albumapp;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnej on 3/30/15.
 */

public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbums;

    public RecyclerViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // This decides which layout the fragment will use.
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    // The view passed to us in this parameter contains all of the views we created in XML
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Map our view
        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_albums);

        // Every RecyclerView needs a LayoutManager. Notice that it's an inner class.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // Don't forget to set the manager on your RecyclerView!
        recyclerAlbums.setLayoutManager(layoutManager);

        // create data
        List<Album> albums = mockAlbums();

        // set the adapter
        recyclerAlbums.setAdapter(new AlbumAdapter(albums));
    }

    private List<Album> mockAlbums() {
        // Creates a list of Contacts and fills them up with data
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey), "Title1",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title2",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title3",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title4",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title5",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title6",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title7",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title8",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title9",
                "Artist", "15", "1987","Publisher"));
        albums.add(new Album(getResources().getDrawable(R.drawable.monkey),"Title10",
                "Artist", "15", "1987","Publisher"));

        return albums;
    }
}
