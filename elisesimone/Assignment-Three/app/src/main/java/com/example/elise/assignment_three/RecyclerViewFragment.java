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
 * Created by Elise Johnson on 3/30/2015.
 */
public class RecyclerViewFragment extends Fragment {

    //Variables
    private RecyclerView recyclerAlbums;

    //Constructor
    public RecyclerViewFragment(){
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Decides layout the fragment will use
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    //View passed in contains all of the XML views
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Map the view
        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_albums);

        //Creating a LayoutManager for the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        //Setting the LayoutManager to the RecyclerView
        recyclerAlbums.setLayoutManager(layoutManager);

        //Creating a list of albums
        List<Album> albums = myAlbums();

        //Setting the adapter
        recyclerAlbums.setAdapter(new AlbumAdapter(albums,getActivity().getApplicationContext()));

    }

    private List<Album> myAlbums(){
        //Creating list of albums and filling with data
        List<Album> albums = new ArrayList<>();
        Resources res = getResources();

        Drawable album_1 = res.getDrawable(R.drawable.absolution);
        Drawable album_2 = res.getDrawable(R.drawable.american_idiot);
        Drawable album_3 = res.getDrawable(R.drawable.dookie);
        Drawable album_4 = res.getDrawable(R.drawable.for_those_who_have_heart);
        Drawable album_5 = res.getDrawable(R.drawable.homesick);
        Drawable album_6 = res.getDrawable(R.drawable.in_rainbows);
        Drawable album_7 = res.getDrawable(R.drawable.mylo_xyloto);
        Drawable album_8 = res.getDrawable(R.drawable.the_resistance);
        Drawable album_9 = res.getDrawable(R.drawable.ride_the_lightning);
        Drawable album_10 = res.getDrawable(R.drawable.century_breakdown);

        albums.add(new Album(album_1,"Absolution","Muse",14,2003,"Warner Bros."));
        albums.add(new Album(album_2,"American Idiot","Green Day",13,2004,"Reprise Records"));
        albums.add(new Album(album_3,"Dookie","Green Day",14,1994,"Reprise Records"));
        albums.add(new Album(album_4,"For Those Who Have Heart","A Day to Remember",12,2006,"Victory Records"));
        albums.add(new Album(album_5,"Homesick","A Day to Remember",12,2009,"Victory Records"));
        albums.add(new Album(album_6,"In Rainbows","Radiohead",10,2007,"TBD Records"));
        albums.add(new Album(album_7,"Mylo Xyloto","Coldplay",14,2011,"Capitol Records"));
        albums.add(new Album(album_8,"The Resistance","Muse",11,2009,"Warner Bros."));
        albums.add(new Album(album_9,"Ride the Lightning","Metallica",8,1984,"Megaforce"));
        albums.add(new Album(album_10,"21st Century Breakdown","Green Day",18,2009,"Reprise Records"));

        return albums;

    }

}
