package com.example.elise.assignment_three;

import android.app.Fragment;
import android.content.res.Resources;
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
 * Created by Elise on 3/30/2015.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbums;

    public RecyclerViewFragment(){
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_albums);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerAlbums.setLayoutManager(layoutManager);

        List<Album> albums = myAlbums();

        recyclerAlbums.setAdapter(new AlbumAdapter(albums));

    }

    private List<Album> myAlbums(){
        List<Album> albums = new ArrayList<>();
        Resources res = getResources();

        Drawable album_1 = res.getDrawable(R.drawable.dookie);
        Drawable album_2 = res.getDrawable(R.drawable.american_idiot);
        Drawable album_3 = res.getDrawable(R.drawable.century_breakdown);
        Drawable album_4 = res.getDrawable(R.drawable.absolution);
        Drawable album_5 = res.getDrawable(R.drawable.the_resistance);
        Drawable album_6 = res.getDrawable(R.drawable.ride_the_lightning);
        Drawable album_7 = res.getDrawable(R.drawable.in_rainbows);
        Drawable album_8 = res.getDrawable(R.drawable.mylo_xyloto);
        Drawable album_9 = res.getDrawable(R.drawable.for_those_who_have_heart);
        Drawable album_10 = res.getDrawable(R.drawable.homesick);

        albums.add(new Album(album_1,"Dookie","Green Day",14,1994,"Reprise Records"));
        albums.add(new Album(album_2,"American Idiot","Green Day",13,2004,"Reprise Records"));
        albums.add(new Album(album_3,"21st Century Breakdown","Green Day",18,2009,"Reprise Records"));
        albums.add(new Album(album_4,"Absolution","Muse",14,2003,"East West Records, Taste Media"));
        albums.add(new Album(album_5,"The Resistance","Muse",11,2009,"Warner Bros., Helium-3"));
        albums.add(new Album(album_6,"Ride the Lightning","Metallica",8,1984,"Megaforce"));
        albums.add(new Album(album_7,"In Rainbows","Radiohead",10,2007,"TBD Records, XL Recordings"));
        albums.add(new Album(album_8,"Mylo Xyloto","Coldplay",14,2011,"Parlophone, Capitol Records"));
        albums.add(new Album(album_9,"For Those Who Have Heart","A Day to Remember",12,2006,"Victory Records"));
        albums.add(new Album(album_10,"Homesick","A Day to Remember",12,2009,"Victory Records"));

        return albums;

    }

}
