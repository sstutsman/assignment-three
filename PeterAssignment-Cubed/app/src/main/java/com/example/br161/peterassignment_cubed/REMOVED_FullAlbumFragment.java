package com.example.br161.peterassignment_cubed;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class REMOVED_FullAlbumFragment extends Fragment {
    ImageView imgAlbumCover_full;
    TextView artistName_full,
            albumName_full,
            publisher_full,
            year_full,
            genre_full,
            track_static_full,
            trackAmt_full;

    public REMOVED_FullAlbumFragment() {
    //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_albumlisting_full, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)    {
        super.onViewCreated(view, savedInstanceState);
        imgAlbumCover_full = (ImageView) view.findViewById(R.id.draw_albumcover_full);
        artistName_full = (TextView) view.findViewById(R.id.tv_artistName_full);
        albumName_full = (TextView) view.findViewById(R.id.tv_albumName_full);
        publisher_full = (TextView) view.findViewById(R.id.tv_publisher_full);
        year_full = (TextView) view.findViewById(R.id.tv_year_full);
        genre_full = (TextView) view.findViewById(R.id.tv_genre_full);
        track_static_full = (TextView) view.findViewById(R.id.tv_static_track);
        trackAmt_full = (TextView) view.findViewById(R.id.tv_trackAmt_full);

    }


} //End FullAlbumFragment class
