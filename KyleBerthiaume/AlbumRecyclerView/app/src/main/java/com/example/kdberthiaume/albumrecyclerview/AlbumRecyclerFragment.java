package com.example.kdberthiaume.albumrecyclerview;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumRecyclerFragment extends Fragment {

    private RecyclerView recyclerAlbums;

    List<Album> albums;


    public AlbumRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Mapping view
        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_album);

        // Need a LayoutManager.
        // Creating LayoutManger
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        // Setting layoutManger
        recyclerAlbums.setLayoutManager(layoutManager);

        // Creating mock data
        List<Album> albums = mockData();

        // Setting adapter
        recyclerAlbums.setAdapter(new AlbumAdapter(albums));

    }

    private List<Album> mockData (){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(getResources().getDrawable(R.drawable.pretty_reckless2),
                "Going to Hell", "The Pretty reckless", "12", "Interscope Records"));
        albums.add(new Album(getResources().getDrawable(R.drawable.avenged_sevenfold),
                "Hail to the King", "Avenged Sevenfold", "10", "Warner Bros."));
        albums.add(new Album(getResources().getDrawable(R.drawable.charlie_hunt), "Steady Groovin",
                "Charlie Hunt", "12", "Blue Note Records"));
        albums.add(new Album(getResources().getDrawable(R.drawable.three_years_hollow),
                "The Cracks", "Three Years Hollow", "12", "Imagine Records"));
        albums.add(new Album(getResources().getDrawable(R.drawable.romantic_rebel),
                "Romantic Rebel", "Romantic Rebel", "11", "Interscope Records"));
        albums.add(new Album(getResources().getDrawable(R.drawable.demon_days), "Demon Days",
                "Gorillaz", "15", "Parlophone"));
        albums.add(new Album(getResources().getDrawable(R.drawable.dreamshade_photographs),
                "The Gift of Life", "Dreamshade", "10", "Spinefarm"));

        return albums;

    }
}
