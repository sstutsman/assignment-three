package com.example.kdberthiaume.albumrecyclerview;


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
public class AlbumRecyclerFragment extends Fragment {

    private RecyclerView recyclerAlbums;

    List<Album> albums;


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
        List<Album> albums = mockData();

        // Setting adapter
        recyclerAlbums.setAdapter(new AlbumAdapter(albums));

    }

    private List<Album> mockData (){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(getResources().getDrawable(R.drawable.pretty_reckless2),
                "Going to Hell", "The Pretty reckless", "12", "Interscope Records",
                "1.	 \"Follow Me Down\"\n"+
                "2.	 \"Going to Hell\"\n"+
                "3.	 \"Heaven Knows\"\n"+
                "4.	 \"House on a Hill\"\n"+
                "5.	 \"Sweet Things\"\n"+
                "6.	 \"Dear Sister\"\n"+
                "7.	 \"Absolution\"\n"+
                "8.	 \"Blame Me\"\n"+
                "9.	 \"Burn\"\n"+
                "10. \"Why'd You Bring a Shotgun to the Party\"\n"+
                "11. \"F****d Up World\"\n"+
                "12. \"Waiting for a Friend\"\n"));
        albums.add(new Album(getResources().getDrawable(R.drawable.avenged_sevenfold),
                "Hail to the King", "Avenged Sevenfold", "10", "Warner Bros.",
                "1.	 \"Shepherd of Fire\"\n"+
                "2.	 \"Hail to the King\"\n"+
                "3.	 \"Doing Time\"\n"+
                "4.	 \"This Means War\"\n"+
                "5.	 \"Requiem\"\n"+
                "6.	 \"Crimson Day\"\n"+
                "7.	 \"Heretic\"\n"+
                "8.	 \"Coming Home\"\n"+
                "9.	 \"Planets\"\n"+
                "10. \"Acid Rain\"\n"+
                "11. \"St. James\"\n"));
        albums.add(new Album(getResources().getDrawable(R.drawable.charlie_hunt), "Steady Groovin",
                "Charlie Hunt", "12", "Blue Note Records",
                "1.	 \"Kool\"\n"+
                "2.	 \"Do Like Eddie\"\n"+
                "3.	 \"Chariots\"\n"+
                "4.	 \"Lazy\"\n"+
                "5.	 \"Camp Out\"\n"+
                "6.	 \"7th Floor\"\n"+
                "7.	 \"Carlos\"\n"+
                "8.	 \"Big Top\"\n"+
                "9.	 \"She's So Lucky\"\n"+
                "10. \"Twang\"\n"+
                "11. \"Fat Lip\"\n"));
        albums.add(new Album(getResources().getDrawable(R.drawable.three_years_hollow),
                "The Cracks", "Three Years Hollow", "12", "Imagine Records",
                "1.	 \"The Devil's Slave\"\n"+
                "2.	 \"Chemical Ride\"\n"+
                "3.	 \"For Life (feat. Clint Lowery)\"\n"+
                "4.	 \"The Cracks\"\n"+
                "5.	 \"Fallen\"\n"+
                "6.	 \"Taken By All\"\n"+
                "7.	 \"Hungry\"\n"+
                "8.	 \"Run Away\"\n"+
                "9.	 \"We Belong\"\n"+
                "10. \"Take the World\"\n"+
                "11. \"Lost\"\n"+
                "12. \"Remember (Remastered)\"\n"));
        albums.add(new Album(getResources().getDrawable(R.drawable.romantic_rebel),
                "Romantic Rebel", "Romantic Rebel", "11", "Interscope Records",
                "1.	 \"Alive\"\n"+
                "2.	 \"Disappear\"\n"+
                "3.	 \"Lie (Feat. Brendon Small)\"\n"+
                "4.	 \"Nothing Left to Say\"\n"+
                "5.	 \"Believe\"\n"+
                "6.	 \"Over Again\"\n"+
                "7.	 \"Moment\"\n"+
                "8.	 \"Sorry\"\n"+
                "9.	 \"New Way to Sin\"\n"+
                "10. \"Bad for Me\"\n"+
                "11. \"Madness\"\n"));
        albums.add(new Album(getResources().getDrawable(R.drawable.demon_days), "Demon Days",
                "Gorillaz", "15", "Parlophone",
                "1.	 \"Speak to Me\"\n"+
                "2.	 \"Breathe\"\n"+
                "3.	 \"On the Run\"\n"+
                "4.	 \"Time\"\n"+
                "5.	 \"The Great Gig in the Sky\"\n"+
                "6.	 \"Money\"\n"+
                "7.	 \"Us and Them\"\n"+
                "8.	 \"Any Colour You Like\"\n"+
                "9.	 \"Brain Damage\"\n"+
                "10. \"Eclipse\"\n"));
        albums.add(new Album(getResources().getDrawable(R.drawable.dreamshade_photographs),
                "The Gift of Life", "Dreamshade", "10", "Spinefarm",
                "1.	 \"Intro\"\n"+
                "2.	 \"Last Living Souls\"\n"+
                "3.	 \"Kids With Guns\"\n"+
                "4.	 \"O Green World\"\n"+
                "5.	 \"Dirty Harry\"\n"+
                "6.	 \"Feel Good Inc\"\n"+
                "7.	 \"El Manana\"\n"+
                "8.	 \"Every Planet We Reach Is Dead\"\n"+
                "9.	 \"November Has Come\"\n"+
                "10. \"All Alone\"\n"+
                "11. \"White Light\"\n"+
                "12. \"DARE\"\n"+
                "13. \"Fire Coming Out of the Monkey's Head\"\n"+
                "14. \"Don't Get Lost in Heaven\"\n"+
                "15. \"Demon Days\"\n"));

        return albums;

    }
}
