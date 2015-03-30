package com.example.kdberthiaume.albumrecyclerview;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumRecyclerFragment extends Fragment {

    private RecyclerView recyclerAlbums;


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
        List<Album> albums;

        // Setting adapter



    }
}
