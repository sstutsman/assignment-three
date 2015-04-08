package com.example.gabewright.recycler_view_assignment;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class activity2 extends ActionBarActivity {

    TextView name;
    TextView artist;
    TextView tcount;
    TextView year;
    TextView publisher;
    ImageView art;
    TextView funFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting the views
        setContentView(R.layout.activity_activity2);
        name = (TextView) findViewById(R.id.name2);
        artist = (TextView) findViewById(R.id.artist2);
        tcount = (TextView) findViewById(R.id.tcount2);
        year = (TextView) findViewById(R.id.year2);
        publisher = (TextView) findViewById(R.id.publisher2);
        art = (ImageView) findViewById(R.id.art2);
        funFact = (TextView) findViewById(R.id.funfact);

        Resources res = getResources();

        //adding text to the views
        name.setText(getIntent().getStringExtra("name"));
        artist.setText(getIntent().getStringExtra("artist"));
        tcount.setText(getIntent().getStringExtra("tcount"));
        year.setText(getIntent().getStringExtra("year"));
        publisher.setText(getIntent().getStringExtra("publisher"));
        int artint = Integer.parseInt(getIntent().getStringExtra("artint"));
        art.setImageDrawable(res.getDrawable(artint));
        funFact.setText(getIntent().getStringExtra("funfact"));

    }



}
