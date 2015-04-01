package com.example.br161.assignmentthree;


import android.content.Context;
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
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbums;

    private List<Album> albums;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }//end RecyclerViewFragment method


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }//end onCreateView method

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_albums);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbums.setLayoutManager(layoutManager);

        albums = mockAlbums();

        recyclerAlbums.setAdapter(new AlbumAdapter(albums));
    }//end onViewCreated method

    private List<Album> mockAlbums() {

        List<Album> albums = new ArrayList<>();
        int x = R.drawable.skid_row;
        albums.add(new Album("Skid Row", "Skid Row", "Atlantic", "Rock", R.drawable.skid_row, 11, 1989));

        return albums;
    }//end mockAlbums method
}//end RecylcerViewFragment class
