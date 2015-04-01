package com.example.julio.albumstore;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {


    private RecyclerView albumsRecyclerView;
    private RecyclerView.Adapter albumReyclerViewAdpter;
    private RecyclerView.LayoutManager albumRecylerViewLayoutManger;

    private String[] albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albumsRecyclerView = (RecyclerView) findViewById(R.id.albumRecycleView);
        albumsRecyclerView.setHasFixedSize(true);

        albumRecylerViewLayoutManger = new LinearLayoutManager(this);
        albumsRecyclerView.setLayoutManager(albumRecylerViewLayoutManger);


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
