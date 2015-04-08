package com.maddux.assignmentthree;

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
 * Created by My Laptop on 4/7/2015.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbums;

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

        recyclerAlbums = (RecyclerView) view.findViewById((R.id.recycler_albums));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerAlbums.setLayoutManager(layoutManager);

        List<Album> albums = mockAlbums();

        recyclerAlbums.setAdapter(new AlbumAdapter(albums));

    }

    private List<Album> mockAlbums() {

        List<Album> albums = new ArrayList<>();
        albums.add(new Album(R.drawable.endgame, "Endgame", "Rise Against", 12, 2011, "DGC, Interscope"));
        albums.add(new Album(R.drawable.appeal_to_reason,"Appeal to Reason", "Rise Against", 13, 2008, "DGC, Interscope"));
        albums.add(new Album(R.drawable.sufferer_witness,"The Sufferer and the Witness", "Rise Against", 7, 2006, "DGC,Interscope"));
        albums.add(new Album(R.drawable.toxicity, "Toxicity", "System of a down", 14, 2001, "American"));
        albums.add(new Album(R.drawable.mezmerize, "Mezmerize", "System of a down", 11, 2004, "American"));
        albums.add(new Album(R.drawable.hypnotize, "Hypnotize", "System of a Down", 12, 2005, "American"));
        albums.add(new Album(R.drawable.black_market,"Black Market", "Rise Against", 7, 2014, "DGC, Interscope"));
        albums.add(new Album(R.drawable.minutes_to_midnight,"Minutes to Midnight", "Linkin Park", 7, 2007,"Warner Bros, Machine Shop"));
        albums.add(new Album(R.drawable.hybrid_theory,"Hybrid Theory", "Linkin Park", 12, 2000,"Warner Bros"));
        albums.add(new Album(R.drawable.meteora, "Endgame", "Linkin Park", 13, 2003,"Warner Bros, Machine Shop"));

        return albums;
    }
}
