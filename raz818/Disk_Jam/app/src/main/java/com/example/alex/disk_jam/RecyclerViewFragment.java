package com.example.alex.disk_jam;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/8/2015.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbum;

    public RecyclerViewFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerAlbum = (RecyclerView) view.findViewById(R.id.recycler_albums);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbum.setLayoutManager(layoutManager);

        List<Album> albumList = mockAlbums();

        recyclerAlbum.setAdapter(new AlbumAdapter(albumList,getActivity().getApplicationContext()));

    }

    private  List<Album> mockAlbums(){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Gorillaz", "Gorillaz", 21, 2001, "Parlophone, Virgin, Warner Bros",R.drawable.gorillaz_albums));
        albums.add(new Album("Demon Days", "Gorillaz", 15, 2005, "Capitol Records",R.drawable.demon_days));
        albums.add(new Album("Plastic Beach", "Gorillaz", 17, 2010, "EMI",R.drawable.plasticbeach));
        albums.add(new Album("Green River", "Creedence Clearwater Revival", 9, 1969, "DCC Compact Classics",R.drawable.creedence_c));
        albums.add(new Album("Boston", "Boston", 8, 1976, "Epic Records",R.drawable.bostonboston));
        albums.add(new Album("Cage the Elephant", "Cage the Elephant", 12, 2008, "Cage the Elephant",R.drawable.cagetheelephant));
        albums.add(new Album("Melophobia", "Cage the Elephant", 10, 2013, "RCA Records",R.drawable.cage_the_elephant_m));
        albums.add(new Album("Backstreet's Back", "Backstreet Boys", 13, 1997, "Jive, Trans Continental Records",R.drawable.backstreets_back));
        albums.add(new Album("Back in Black", "AC/DC", 10, 1980, "Atlantic Records, Epic Records",R.drawable.acdc_backinblack_cover));
        albums.add(new Album("Highway to Hell", "AC/DC", 10, 1979, "Atlantic Records",R.drawable.acdc_highway));

        return albums;
    }
}
