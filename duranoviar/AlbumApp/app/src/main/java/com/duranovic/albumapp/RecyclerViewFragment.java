package com.duranovic.albumapp;

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
 * Created by arnej on 3/30/15.
 */

public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerContacts;

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
        recyclerContacts = (RecyclerView) view.findViewById(R.id.recycler_contacts);

        // Every RecyclerView needs a LayoutManager. Notice that it's an inner class.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // Don't forget to set the manager on your RecyclerView!
        recyclerContacts.setLayoutManager(layoutManager);

        // create data
        List<Album> albums = mockAlbums();

        // set the adapter
        recyclerContacts.setAdapter(new AlbumAdapter(albums));
    }

    private List<Album> mockAlbums() {
        // Creates a list of Contacts and fills them up with data
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Title", "Artist", "15", "1987","Publisher"));

        return albums;

    }
}
