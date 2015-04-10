package com.example.br161.peterassignment_cubed;

import android.app.Fragment;
import android.content.Intent;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )    {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //Links it to Recycler View created in file: item_albumlisting_brief.xml
        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_albums);

        //Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbums.setLayoutManager(layoutManager);


        List<CDAlbum> myCollection = importAlbums();
        recyclerAlbums.setAdapter(new CDAdapter(myCollection, getActivity()));

    }

//(String albumname, String artist, Integer trackCount, Integer year, String publisher, String genre, Drawable albumart)

private List<CDAlbum> importAlbums() {
    List<CDAlbum> myCollection = new ArrayList<>();
    myCollection.add(new CDAlbum("Beyoncé",             "Beyoncé",      14, 2013, "Colombia",       "Alternative R&B",  R.drawable.beyonce_albumcover));
    myCollection.add(new CDAlbum("1989",                "Taylor Swift", 13, 2014, "Big Machine",    "Garbage",          R.drawable.taylorswift_1989));
    myCollection.add(new CDAlbum("After Hours",         "Timeflies",    14, 2014, "Island Records", "Pop/Hip-Hop",      R.drawable.timeflies_afterhours));
    myCollection.add(new CDAlbum("Unleash The Dragon",  "Sisqó",        13, 1999, "Def Soul",       "R&B",              R.drawable.sisqo_unleashthedragon));
    myCollection.add(new CDAlbum("Astro Lounge",        "Smash Mouth",  15, 1999, "Interscope",     "Alternative Rock", R.drawable.smashmouth_astrolounge));
    myCollection.add(new CDAlbum("Bombs Away",          "Sheppard",     11, 2014, "Decca Records",  "Indie Pop",        R.drawable.sheppard_bombsaway));
    myCollection.add(new CDAlbum("Oops I Did It Again", "Britney Spears",12,2000, "Jive",           "Pop",              R.drawable.britneyspears_oopsididitagain));
    myCollection.add(new CDAlbum("No Strings Attached", "N*Sync",       14, 2000, "Jive",           "Pop",              R.drawable.nsync_nostringsattached));
    myCollection.add(new CDAlbum("Final Fantasy X Original Soundtrack", "Nobuo Uematsu", 91, 2001, "Tokyopop", "Game",  R.drawable.nobuouematsu_finalfantasyxoriginalsoundtrack));
    myCollection.add(new CDAlbum("Blue's Biggest Hits", "Blue's Clues", 15, 2006, "Nick Records",    "Soundtrack",        R.drawable.bluesclues_bluesbiggesthits));
    return myCollection;
}

}