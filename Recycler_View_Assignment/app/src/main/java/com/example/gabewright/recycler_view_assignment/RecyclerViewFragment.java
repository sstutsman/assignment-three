package com.example.gabewright.recycler_view_assignment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerAlbum;

    public RecyclerViewFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerAlbum = (RecyclerView) view.findViewById(R.id.recycler_album);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbum.setLayoutManager(layoutManager);
        List<Album> albums = mockAlbums();
        recyclerAlbum.setAdapter(new AlbumAdapter(albums));
    }

    private List<Album> mockAlbums(){

        Resources res = getResources();
        Drawable strangeclouds = res.getDrawable(R.drawable.strangeclouds);
        Drawable boston = res.getDrawable(R.drawable.boston);
        Drawable billyjoel = res.getDrawable(R.drawable.billyjoel);
        Drawable gnr = res.getDrawable(R.drawable.gnr);
        Drawable iv = res.getDrawable(R.drawable.iv);
        Drawable rush = res.getDrawable(R.drawable.rush);
        Drawable breakfast = res.getDrawable(R.drawable.breakfast); //they're coming for cornstock!
        Drawable third = res.getDrawable(R.drawable.third);
        Drawable adventures = res.getDrawable(R.drawable.adventures);
        Drawable manonmoon = res.getDrawable(R.drawable.manonmoon);
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Strange Clouds", "B.o.B", "15 Songs", "2012", "Atlantic Recording Corporation", strangeclouds));
        albums.add(new Album("Boston", "Boston", "8 Songs", "1976", "Epic Records", boston));
        albums.add(new Album("Greatest Hits, Vols. 1 & 2", "Billy Joel", "25 Songs", "1973", "Sony BMG Music Entertainment", billyjoel));
        albums.add(new Album("Appetite for Destruction", "Guns N' Roses", "12 Songs", "1987", "Geffen Records", gnr));
        albums.add(new Album("Led Zeppelin IV", "Led Zeppelin", "8 Songs", "1971", "Atlantic Recording Corporation", iv));
        albums.add(new Album("The Spirit of Radio: Greatest Hits (1974 - 1987)", "Rush", "16 Songs", "2013", "The Island Def Jam Music Group", rush));
        albums.add(new Album("Breakfast", "Chiddy Bang", "14 Songs", "2012", "Parlophone Records Ltd", breakfast));
        albums.add(new Album("Third Eye Blind: A Collection", "Third Eye Blind", "21 Songs", "2006", "Elektra Entertainment Co.", third));
        albums.add(new Album("B.o.B Presents: The Adventures of Bobby Ray (Deluxe Version)", "B.o.B", "16 Songs", "2010", "Atlantic Recording Corporation", adventures));
        albums.add(new Album("Man On The Moon: The End of Day", "Kid Cudi", "15 Songs", "2009", "Universal Motown Records", manonmoon));
        return albums;

    }
}
