package com.example.br161.newapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

/**
 * Created by oa5579pw on 4/8/2015.
 * updated
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    List<Album> albums;

    // Constructor class creates the adapter and passses in what we will need from our Fragment
    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // This line inflates the layout which will be repeated
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        // We create an instance of our ViewHolder so we can handle click events.
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // We can handle click events in here, but only if we have
                // registered the listeners in the ViewHolder
            }
        });
        return viewHolder;
    }

    @Override
    // This method assigns the values from the contacts list we passed in to the views
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAlbumCoverArt.setText(albums.get(position).getAlbumCoverArt());
        holder.tvName.setText(albums.get(position).getName());
        holder.tvArtist.setText(albums.get(position).getArtist());
        holder.tvTrackCount.setText(albums.get(position).getTrackCount());
        holder.tvYear.setText(albums.get(position).getYear());
        holder.tvPublisher.setText(albums.get(position).getPublisher());
    }

    @Override
    // This simple method is needed for the RecyclerView.
    public int getItemCount() {
        return albums.size();
    }

    // This is our ViewHolder inner class. Very important!
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        TextView tvAlbumCoverArt;
        TextView tvName;
        TextView tvArtist;
        TextView tvTrackCount;
        TextView tvYear;
        TextView tvPublisher;


        // We map our views, and assign listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            tvAlbumCoverArt = (TextView) itemView.findViewById(R.id.tv_albumCoverArt);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            tvTrackCount = (TextView) itemView.findViewById(R.id.tv_trackCount);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher);

            itemView.setOnClickListener(this);



            tvAlbumCoverArt.setOnClickListener(this);
            tvName.setOnClickListener(this);
            tvArtist.setOnClickListener(this);
            tvTrackCount.setOnClickListener(this);
            tvYear.setOnClickListener(this);
            tvPublisher.setOnClickListener(this);

        }

        // This method is just to pass on the onClick event to our individual items! Neat!
        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }

        // This is the interface which forces our Adapter to implement the OnClickListener
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }

}

