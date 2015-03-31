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

        Drawable album_1 = res.getDrawable(R.drawable.album_1);

        albums.add(new Album(album_1,"Dookie","Green Day",12,1991,"Reprise Records"));

        return albums;

    }

}
