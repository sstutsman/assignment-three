package com.example.br161.newapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oa5579pw on 4/8/2015.
 * updated
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbums;

    public RecyclerViewFragment() {
        //Required empty constructor
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

        //Create data
        List<Album> albums = mockAlbums();

        //Set the adapter
        recyclerAlbums.setAdapter(new AlbumAdapter(albums));

    }

    private List<Album> mockAlbums() {
        // Creates a list of Albums and fills them up with data
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Album Art", "Magna Carta","Jay z","16 tracks","2013","Jay z"));
        albums.add(new Album("Album Art", "The blue print","Jay z","15 tracks","2001","Jay z"));
        albums.add(new Album("Album Art", "The Pinkprint", "Nicki Minaj","21 tracks","2014","Nicki Minaj"));
        albums.add(new Album("Album Art", "Pink friday", "Nicki Minaj,","22 tracks","2010","Nicki Minaj"));
        albums.add(new Album("Album Art", "Recovery","Eminem","16 tracks","2010","Eminem"));
        albums.add(new Album("Album Art", "The Marshall Mathers","Eminem","21 tracks","2013","Eminem"));
        albums.add(new Album("Album Art", "Fortune","Chris Brown","14 tracks","2012","Chris Brown"));
        albums.add(new Album("Album Art", "Exclusive","Chris Brown","19 tracks","2007","Chris Brown"));
        albums.add(new Album("Album Art", "Unapologetic","Rihanna","18 tracks","2012","Rihanna"));
        albums.add(new Album("Album Art", "Talk that Talk","Rihanna","15 tracks","2010","Rihanna"));

        return albums;
    }
}
