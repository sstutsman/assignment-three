package com.example.br161.peterassignment_cubed;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Peter Thompson on 3/30/2015.
 */
public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerAlbums;

    public RecyclerViewFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        return inflater.inflate(R.layout.SOMETHING_HERE, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        recyclerAlbums = (RecyclerView) view.findViewById(R.id.SOMETHINGE_ELSE_HERE);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerAlbums.setLayoutManager(layoutManager);

    }
}
