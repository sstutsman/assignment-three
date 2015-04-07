package com.albumlist.albumlist;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;

public class SecondaryActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        AlbumData itemsData[] = {
                new AlbumData("Xscape",R.drawable.escape),
                new AlbumData("Born To Run",R.drawable.Born_to_Run),
                new AlbumData("The Dark Side of The Moon",R.drawable.The_Dark_Side_of_The_Moon),
                new AlbumData("Houses of The Holy",R.drawable.Houses_of_the_Holy),
                new AlbumData("Combat Rock",R.drawable.The_Clash),
                new AlbumData("Abbey Road",R.drawable.Abbey_Road),
                new AlbumData("Late Registration",R.drawable.Late_Registration),
                new AlbumData("Smash Mouth",R.drawable.SmashMouth),
                new AlbumData("Learning How to Smile",R.drawable.Learning_to_smile),
                new AlbumData("Bleed American",R.drawable.Bleed_American)};

    }
}
