package com.duranovic.albumapp;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
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
        // Map our view
        recyclerAlbums = (RecyclerView) view.findViewById(R.id.recycler_albums);

        // Every RecyclerView needs a LayoutManager. Notice that it's an inner class.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // Don't forget to set the manager on your RecyclerView!
        recyclerAlbums.setLayoutManager(layoutManager);

        // create data
        List<Album> albums = mockAlbums();

        // set the adapter
        recyclerAlbums.setAdapter(new AlbumAdapter(albums));
    }

    private List<Album> mockAlbums() {
        // Creates a list of Albums and fills them up with data
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(R.drawable.darkside,
                "Dark Side of the Moon",
                "Pink Floyd",
                "10",
                "1973",
                "Harvest",
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
        albums.add(new Album(R.drawable.poison1,
                "Open Up and Say... Ahh!",
                "Poison",
                "10",
                "1988",
                "Enigma",
                "1.  \"Love on the Rocks\"\n"+
                "2.  \"Nothin' but a Good Time\"\n" +
                "3.  \"Back to the Rocking Horse\"\n"+
                "4.  \"Good Love\"\n" +
                "5.  \"Tearin' Down the Walls\"\n" +
                "6.  \"Look But You Can't Touch\"\n" +
                "7.  \"Fallen Angel\"\n" +
                "8.  \"Every Rose Has Its Thorn\"\n" +
                "9.  \"Your Mama Don't Dance\"\n" +
                "10. \"Bad to Be Good\"\n"));
        albums.add(new Album(R.drawable.rsz_wslide,
                "Slide It In",
                "Whitesnake",
                "10",
                "1984",
                "Warner Bros.",
                "1.  \"Slide It In\"\n" +
                "2.  \"Slow an' Easy\"\n" +
                "3.  \"Love Ain't No Stranger\"\n" +
                "4.  \"All or Nothing\"\n" +
                "5.  \"Gambler\"\n" +
                "6.  \"Guilty of Love\"\n" +
                "7.  \"Hungry for Love\"\n" +
                "8.  \"Give Me More Time\"\n" +
                "9.  \"Spit It Out\"\n" +
                "10. \"Standing in the Shadow\"\n"));
        albums.add(new Album(R.drawable.philc,
                "No Jacket Required",
                "Phil Collins",
                "10",
                "1985",
                "Atlantic",
                "1.  \"Sussudio\"\n" +
                "2.  \"Only You Know and I Know\"\n" +
                "3.  \"Long Long Way to Go\"\n" +
                "4.  \"I Don't Wanna Know\"\n" +
                "5.  \"One More Night\"\n" +
                "6.  \"Don't Lose My Number\"\n" +
                "7.  \"Who Said I Would\"\n" +
                "8.  \"Doesn't Anybody Stay Together...\"\n" +
                "9.  \"Inside Out\"\n" +
                "10. \"Take Me Home\"\n" ));
        albums.add(new Album(R.drawable.u2,
                "The Joshua Tree",
                "U2",
                "11",
                "1987",
                "Island",
                "1.  \"Where the Streets Have No Name\"\n" +
                "2.  \"Haven't Found What I'm Looking For\"\n" +
                "3.  \"With or Without You\"\n" +
                "4.  \"Bullet the Blue Sky\"\n" +
                "5.  \"Running to Stand Still\"\n" +
                "6.  \"Red Hill Mining Town\"\n" +
                "7.  \"In God's Country\"\n" +
                "8.  \"Trip Through Your Wires\"\n" +
                "9.  \"One Tree Hill\"\n" +
                "10. \"Exit\"\n" +
                "11. \"Mothers of the Disappeared\"\n" ));
        albums.add(new Album(R.drawable.googoo,
                "Dizzy Up the Girl",
                "Goo Goo Dolls",
                "13",
                "1988",
                "Warner Bros.",
                "1.	 \"Dizzy\"\n" +
                "2.	 \"Slide\"\n" +
                "3.	 \"Broadway\"\n" +
                "4.	 \"January Friend\"\n" +
                "5.	 \"Black Balloon\"\n" +
                "6.	 \"Bullet Proof\"\n" +
                "7.	 \"Amigone\"\n" +
                "8.	 \"All Eyes on Me\"\n" +
                "9.	 \"Full Forever\"\n" +
                "10. \"Acoustic #3\"\n" +
                "11. \"Iris\"\n" +
                "12. \"Extra Pale\"\n" +
                "13. \"Hate This Place\"\n" ));
        albums.add(new Album(R.drawable.thepolice,
                "Synchronicity",
                "The Police",
                "10",
                "1987",
                "A&M",
                "1.	 \"Synchronicity I\"\n" +
                "2.	 \"Walking in Your Footsteps\"\n" +
                "3.	 \"O My God\"\n" +
                "4.	 \"Mother\"\n" +
                "5.	 \"Miss Gradenko\"\n" +
                "6.	 \"Synchronicity II\"\n" +
                "7.	 \"Every Breath You Take\"\n" +
                "8.	 \"King of Pain\"\n" +
                "9.	 \"Wrapped Around Your Finger\"\n" +
                "10. \"Tea in the Sahara\"\n" ));
        albums.add(new Album(R.drawable.toto,
                "Toto IV",
                "Toto",
                "10",
                "1982",
                "Columbia",
                "1.	 \"Rosanna\"\n" +
                "2.	 \"Make Believe\"\n" +
                "3.	 \"I Won't Hold You Back\"\n" +
                "4.	 \"Good for You\"\n" +
                "5.	 \"It's a Feeling\"\n" +
                "6.	 \"Afraid of Love\"\n" +
                "7.	 \"Lovers in the Night\"\n" +
                "8.	 \"We Made It\"\n" +
                "9.	 \"Waiting for Your Love\"\n" +
                "10. \"Africa\"\n" ));
        albums.add(new Album(R.drawable.kansas,
                "Leftoverture",
                "Kansas",
                "8",
                "1976",
                "Kirshner",
                "1.	\"Carry On Wayward Son\"\n" +
                "2.	\"The Wall\"\n" +
                "3.	\"What's On My Mind\"\n" +
                "4.	\"Miracles Out of Nowhere\"\n" +
                "5.	\"Opus Insert\"\n" +
                "6.	\"Questions of My Childhood\"\n" +
                "7.	\"Cheyenne Anthem\"\n" +
                "8.	\"Magnum Opus\"\n" ));
        albums.add(new Album(R.drawable.styx,
                "The Grand Illusion",
                "Styx",
                "8",
                "1977",
                "A&M",
                "1.	\"The Grand Illusion\"\n" +
                "2.	\"Fooling Yourself\"\n" +
                "3.	\"Superstars\"\n" +
                "4.	\"Come Sail Away\"\n" +
                "5.	\"Miss America\"\n" +
                "6.	\"Man in the Wilderness\"\n" +
                "7.	\"Castle Walls\"\n" +
                "8.	\"The Grand Finale\"\n" ));

        return albums;
    }
}
