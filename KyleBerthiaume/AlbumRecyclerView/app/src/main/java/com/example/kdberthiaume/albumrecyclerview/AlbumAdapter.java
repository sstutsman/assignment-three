package com.example.kdberthiaume.albumrecyclerview;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
    Context context;

    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate layout to be repeated
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false);
        // Get current Context
        context = parent.getContext();

        // Creating instance of ViewHolder for handling click events
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener(){
            public void onItemClick(View view, int position){
                // We can handle click events in here, but only if we have
                // registered the listeners in the ViewHolder
                // create a new intent

                // Creating new intent to OnClickActivity
                Intent intent = new Intent(view.getContext(), OnClickActivity.class);

                // pass the description
                intent.putExtra("name", albums.get(position).getAlbumName() + "\n" +
                        albums.get(position).getArtist() + "\n" +
                        albums.get(position).getTrackCount() + " tracks" + "\n" +
                        albums.get(position).getPub() + "\n");

                intent.putExtra("tracks", albums.get(position).getTracks());

                // pass the image
                Bitmap image = ((BitmapDrawable)albums.get(position).getCoverArt()).getBitmap();

                // pass the image
                intent.putExtra("image", image);

                // start the new Activity
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Setting Text Description
        holder.tvAlbum.setText(albums.get(position).getAlbumName());
        holder.tvArtist.setText(albums.get(position).getArtist());
        holder.tvTrackAmount.setText(albums.get(position).getTrackCount());
        holder.tvPublisher.setText(albums.get(position).getPub());

        // Setting AlbumArt image
        holder.ivAlbumArt.setImageDrawable(albums.get(position).getCoverArt());

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
        ImageView ivAlbumArt;


        // Map views, and assigning listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;

            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist_name);
            tvAlbum = (TextView) itemView.findViewById(R.id.tv_album_name);
            tvTrackAmount = (TextView) itemView.findViewById(R.id.tv_track_amount);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher_name);
            ivAlbumArt = (ImageView) itemView.findViewById(R.id.iv_album_art);

            tvAlbum.setOnClickListener(this);
            ivAlbumArt.setOnClickListener(this);
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
