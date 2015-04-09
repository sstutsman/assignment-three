package com.example.charlesflaten.assign301;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles Flaten on 3/30/2015.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbum;

    public RecyclerViewFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerAlbum = (RecyclerView) view.findViewById(R.id.recycler_albums);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbum.setLayoutManager(layoutManager);
        List<Album> albums = mockAlbums();
        recyclerAlbum.setAdapter(new AlbumAdapter(albums));
    }


    private List<Album> mockAlbums() {
        List<Album> albums = new ArrayList<>();
        //String albumCoverArt,String name, String artist,String trackCount, String year, String publisher)
        albums.add(new Album(R.drawable.motm,"Man On The Moon I","Kid Cudi",15,2009,"G.O.O.D"));
        albums.add(new Album(R.drawable.two,"Tha Carter III","Lil Wayne",16,2008,"YMCMB"));
        albums.add(new Album(R.drawable.three,"O.N.I.F.C","Wiz Khalifa",17,2012,"Taylor Gang"));
        albums.add(new Album(R.drawable.four,"Greatest Hits","Journey",16,1988,"Columbia"));
        albums.add(new Album(R.drawable.five,"Blue Slide Park","Mac Miller",16,2011,"Rostrum Records"));
        albums.add(new Album(R.drawable.six,"So Far Gone","Drake",15,2009,"October's Very Own"));
        albums.add(new Album(R.drawable.seven,"Take Care","Drake",18,2011,"Young Money"));
        albums.add(new Album(R.drawable.eight,"Cabin Fever","Wiz Khalifa",9,2011,"Taylor Gang"));
        albums.add(new Album(R.drawable.nine,"Chicken-n-Beer","Ludacris",17,2003,"Def Jam"));
        albums.add(new Album(R.drawable.ten,"Man On The Moon II","Kid Cudi",17,2010,"G.O.O.D"));

        return albums;

    }
}
