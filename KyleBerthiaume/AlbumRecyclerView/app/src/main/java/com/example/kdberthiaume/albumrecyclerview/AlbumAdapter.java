package com.example.kdberthiaume.albumrecyclerview;


import android.os.Bundle;
import android.app.Fragment;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    List<Album> albums;

    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate layout to be repeated
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false);

        // Creating instance of ViewHolder for handling click events
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener(){
            public void onItemClick(View view, int position){
                // We can handle click events in here, but only if we have
                // registered the listeners in the ViewHolder
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ItemClickListener listener;

        TextView tvArtist;
        TextView tvAlbum;
        TextView tvTrackAmount;
        TextView tvPublisher;
        ImageView tvAlbumArt;


        // Map views, and assigning listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;

            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist_name);
            tvAlbum = (TextView) itemView.findViewById(R.id.tv_album_name);
            tvTrackAmount = (TextView) itemView.findViewById(R.id.tv_track_amount);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher_name);
            tvAlbumArt = (ImageView) itemView.findViewById(R.id.iv_album_art);

            tvAlbum.setOnClickListener(this);
            tvAlbumArt.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }

        // Interface to force Adapter to implement the OnClickListener
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}
