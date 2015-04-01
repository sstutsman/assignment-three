package com.example.julio.albumstore;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {


    private RecyclerView albumsRecyclerView;
    private RecyclerView.Adapter albumReyclerViewAdpter;
    LinearLayoutManager layoutManager;
    private  List<Album> dataSet;

    private String[] albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albumsRecyclerView = (RecyclerView) findViewById(R.id.albumRecycleView);
        albumsRecyclerView.setHasFixedSize(true);



        dataSet = new ArrayList<Album>();
        dataSet.add(new Album("BLITZ","Julio Salamanca","http://www.faithmemorialchurch.org/wp-content/uploads/2013/12/Blitz.jpg"));
        dataSet.add(new Album("CRAZYBITCH","Jennie Beldo","https://s-media-cache-ak0.pinimg.com/236x/2f/bf/6a/2fbf6ace6e9b4ccca5e09ac8d6c90055.jpg"));


        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        albumsRecyclerView.setLayoutManager(layoutManager);

        albumReyclerViewAdpter = new AlbumAdapter(this,dataSet);
        albumsRecyclerView.setAdapter(albumReyclerViewAdpter);
//        albumRecylerViewLayoutManger = new LinearLayoutManager(this);
//        albumsRecyclerView.setLayoutManager(albumRecylerViewLayoutManger);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
