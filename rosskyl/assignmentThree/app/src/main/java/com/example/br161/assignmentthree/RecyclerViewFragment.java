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

        albums.add(new Album("Skid Row", "Skid Row", "Atlantic", "Rock",
                R.drawable.skid_row, 11, 1989));
        albums.add(new Album("Subhuman Race", "Skid Row", "Atlantic", "Rock",
                R.drawable.skidrow_subhuman, 14, 1994));
        albums.add(new Album("Slave to the Grind", "Skid Row", "Atlantic", "Rock",
                R.drawable.skidrow_slavecover, 16, 1991));
        albums.add(new Album("Theatre of Pain", "Motley Crue", "Elektra", "Rock",
                R.drawable.motleycrue_theatreofpain, 10, 1985));
        albums.add(new Album("Shout at the Devil", "Motley Crue", "Elektra", "Rock",
                R.drawable.motleycrue_shoutatthedevil, 11, 1983));
        albums.add(new Album("Girls, Girls, Girls", "Motley Crue", "Elektra", "Rock",
                R.drawable.motleycrue_girlsgirlsgirls, 10, 1987));
        albums.add(new Album("Chinese Democracy", "Guns N' Roses", "Geffen", "Rock",
                R.drawable.gnr_chinesedemocracy, 14, 2008));
        albums.add(new Album("Appetite for Destruction", "Guns N' Roses", "Geffen", "Rock",
                R.drawable.gnr_appetitefordestruction, 12, 1987));
        albums.add(new Album("Use Your Illusion 1", "Guns N' Roses", "Geffen", "Rock",
                R.drawable.gnr_useyourillusion1, 16, 1991));
        albums.add(new Album("This is just a really long album title that is long",
                "This is just a really long artist name", "Just a long producer name",
                "A long genre which is also long", R.drawable.ic_launcher, -8, 0));

        return albums;
    }//end mockAlbums method
}//end RecylcerViewFragment class
