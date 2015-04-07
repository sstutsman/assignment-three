package com.example.elise.assignment_three;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by Elise Johnson on 3/30/2015.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragment transaction for the recycler view fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new RecyclerViewFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

}
