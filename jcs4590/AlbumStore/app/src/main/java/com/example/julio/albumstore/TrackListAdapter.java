package com.example.julio.albumstore;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jcs on 4/5/15.
 */
public class TrackListAdapter extends ArrayAdapter<Album.Track> {
    private List<Album.Track> tracksList;
    private Context context;

     TrackListAdapter(Context context,Album.Track[] tracksList) {
        super(context,R.layout.track_custom_row,tracksList);
        this.context = context;
    }

//    @Override
//    public int getCount() {
//        return this.tracksList.size();
//    }
//
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView =  inflater.inflate(R.layout.track_custom_row,parent,false);
        TextView trackNameTextView = (TextView) customView.findViewById(R.id.trackNameTextView);
        TextView artistNameTextView = (TextView) customView.findViewById(R.id.artistNameTextView);
        ImageButton previewImageButton = (ImageButton) customView.findViewById(R.id.previewImageButton);
        Album.Track track = (Album.Track)getItem(position);
        trackNameTextView.setText(track.getName());
        artistNameTextView.setText(track.getArtists()[0].getName());
        return customView;
    }
}
