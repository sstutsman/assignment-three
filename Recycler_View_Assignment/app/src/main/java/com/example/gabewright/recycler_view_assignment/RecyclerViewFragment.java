package com.example.gabewright.recycler_view_assignment;

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
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Strange Clouds", "B.o.B", "15", "2012", "Atlantic Recording Corporation"));
        albums.add(new Album("Boston", "Boston", "tcount", "8", "Epic Records"));
        albums.add(new Album("Greatest Hits, Vols. 1 & 2", "Billy Joel", "25", "1973", "Sony BMG Music Entertainment"));
        albums.add(new Album("Appetite for Destruction", "Guns N' Roses", "12", "1987", "Geffen Records"));
        albums.add(new Album("Led Zeppelin IV", "Led Zeppelin", "8", "1971", "Atlantic Recording Corporation"));
        albums.add(new Album("The Spirit of Radio: Greatest Hits (1974 - 1987)", "Rush", "16", "2013", "The Island Def Jam Music Group"));
        albums.add(new Album("Breakfast", "Chiddy Bang", "14", "2012", "Parlophone Records Ltd"));
        albums.add(new Album("Third Eye Blind: A Collection", "Third Eye Blind", "21", "2006", "Elektra Entertainment Co."));
        albums.add(new Album("B.o.B Presents: The Adventures of Bobby Ray (Deluxe Version)", "B.o.B", "16", "2010", "Atlantic Recording Corporation"));
        albums.add(new Album("Man On The Moon: The End of Day", "Kid Cudi", "15", "2009", "Universal Motown Records"));
        return albums;

    }
}
