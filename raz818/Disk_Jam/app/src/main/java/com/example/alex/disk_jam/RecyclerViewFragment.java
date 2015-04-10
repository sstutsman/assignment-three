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

        recyclerAlbum.setAdapter(new AlbumAdapter(albumList));

    }

    private  List<Album> mockAlbums(){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Gorillaz", "Gorillaz", 21, 2001, "Parlophone, Virgin, Warner Bros",R.drawable.gorillaz_albums));

        return albums;
    }
}
