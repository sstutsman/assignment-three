package com.duranovic.albumapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arnej on 3/30/15.
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_element, parent, false);

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

        // set the image
        holder.ivImage.setImageDrawable(albums.get(position).getalbumArt());
        // set the description text
        holder.tvDescription.setText(albums.get(position).getName() + "\n" +
                albums.get(position).getArtist() + "\n" +
                        albums.get(position).getYear() + "\n" +
                        albums.get(position).getTrackCount() + " tracks" + "\n" +
                        albums.get(position).getPublisher() + "\n"
        );
    }

    @Override
    // This simple method is needed for the RecyclerView.
    public int getItemCount() {
        return albums.size();
    }

    // This is our ViewHolder inner class. Very important!
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        TextView tvDescription;
        ImageView ivImage;


        // We map our views, and assign listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);

            tvDescription.setOnClickListener(this);
            ivImage.setOnClickListener(this);
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
