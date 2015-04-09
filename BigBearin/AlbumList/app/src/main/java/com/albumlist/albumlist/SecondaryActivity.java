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
                new AlbumData("Xscape", R.drawable.escape),
                new AlbumData("Born To Run", R.drawable.born_to_run),
                new AlbumData("The Dark Side of The Moon", R.drawable.dark_moon),
                new AlbumData("Houses of The Holy", R.drawable.houses_holy),
                new AlbumData("Combat Rock", R.drawable.the_clash),
                new AlbumData("Abbey Road", R.drawable.abbey_road),
                new AlbumData("Late Registration", R.drawable.late_registration),
                new AlbumData("Smash Mouth", R.drawable.smash_mouth),
                new AlbumData("Learning How to Smile", R.drawable.learning_smile),
                new AlbumData("Bleed American", R.drawable.bleed_american)};

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter mAdapter = new MyAdapter(itemsData);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
