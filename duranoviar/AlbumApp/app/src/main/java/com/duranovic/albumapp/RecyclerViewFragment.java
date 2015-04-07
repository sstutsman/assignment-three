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
        albums.add(new Album(getResources().getDrawable(R.drawable.darkside),
                "Dark Side of the Moon",
                "Pink Floyd",
                "10",
                "1973",
                "Harvest",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.poison1),
                "Open Up and Say... Ahh!",
                "Poison",
                "10",
                "1988",
                "Enigma",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.rsz_wslide),
                "Slide It In",
                "Whitesnake",
                "10",
                "1984",
                "Warner Bros.",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.philc),
                "No Jacket Required",
                "Phil Collins",
                "10",
                "1985",
                "Atlantic",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.u2),
                "The Joshua Tree",
                "U2",
                "11",
                "1987",
                "Island",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.googoo),
                "Dizzy Up the Girl",
                "Goo Goo Dolls",
                "13",
                "1988",
                "Warner Bros.",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.thepolice),
                "Synchronicity",
                "The Police",
                "10",
                "1987",
                "A&M",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.toto),
                "Toto IV",
                "Toto",
                "10",
                "1982",
                "Columbia",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.kansas),
                "Leftoverture",
                "Kansas",
                "8",
                "1976",
                "Kirshner",
                "track\ntrack\nrack\ntrack\ntrack"));
        albums.add(new Album(getResources().getDrawable(R.drawable.styx),
                "The Grand Illusion",
                "Styx",
                "8",
                "1977",
                "A&M",
                "track\ntrack\nrack\ntrack\ntrack"));

        return albums;
    }
}
