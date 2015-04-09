package com.example.br161.peterassignment_cubed;

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
 * Created by Peter Thompson on 3/30/2015.
 */
public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerAlbums;

    public RecyclerViewFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        return inflater.inflate(R.layout.item_albumlisting_brief, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //Links it to Recycler View created in file: fragment_recycler_view.xml
        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_oneAlbumBrief);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbums.setLayoutManager(layoutManager);

        List<CDAlbum> myCollection = importAlbums();
        recyclerAlbums.setAdapter(new CDAdapter(myCollection));

    }


    //(String albumname, String artist, String trackCount, String year, String publisher, String genre, Drawable albumart)

private List<CDAlbum> importAlbums() {
    List<CDAlbum> myCollection = new ArrayList<>();
    myCollection.add(new CDAlbum("Beyonce", "Beyonce", "14", "2013", "Colombia", "Alternative R&B", R.drawable.beyonce_albumcover_xxhd));

    return myCollection;
}

}