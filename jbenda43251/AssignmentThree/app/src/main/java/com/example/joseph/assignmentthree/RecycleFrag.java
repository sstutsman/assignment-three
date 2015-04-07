package com.example.joseph.assignmentthree;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class RecycleFrag extends Fragment {
    private RecyclerView recyclerAlbum;

    public RecycleFrag() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycle, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerAlbum = (RecyclerView) view.findViewById(R.id.recycler_albums);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbum.setLayoutManager(layoutManager);

        List<Album> albums = mockAlbums();

        recyclerAlbum.setAdapter(new AlbumAdapter(albums, getActivity()));


    }

    private List<Album> mockAlbums() {
        List<Album> albums = new ArrayList<>();
        List<String> genres = new ArrayList<>();
        albums.add(new Album("The Middle of Nowhere", "Adam Warrock",
                "Independtly Produced", 14,2013,R.drawable.middleofnowherecover));
        albums.add(new Album("Gifted Student", "Adam Warrock",
                "Mikal Khill", 8,2015,R.drawable.giftedstudentcover));
        albums.add(new Album("You Dare Call that Thing Human?!?", "Adam Warrock",
                "Independtly Produced", 14,2012,R.drawable.youdarecover));
        albums.add(new Album("Because the Internet", "Childish Gambino",
                "Glassnote, Island", 19,2014,R.drawable.becausetheinternetcover));
        albums.add(new Album("Parachutes", "Coldplay",
                "Parlophone", 10,2000,R.drawable.parachutescover));
        albums.add(new Album("X&Y", "Coldplay",
                "Parlophone", 13,2005,R.drawable.xucover));
        albums.add(new Album("Stadium Arcadium", "Red Hot Chilli Peppers",
                "Warner Bros", 28,2006,R.drawable.stadiumarcadiumcover));
        albums.add(new Album("Demon Days", "Gorillaz",
                "Capitol Records", 15, 20015, R.drawable.demondayscover));
        albums.add(new Album("American Idiot", "Green Day",
                "Reprise", 13, 2004, R.drawable.americanidiotcover));
        albums.add(new Album("Drunken Lullabies", "Flogging Molly",
                "SideOneDummy", 12, 2002, R.drawable.drunkenlullabyscoer));
        return albums;
    }
}
