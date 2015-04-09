package com.example.charlesflaten.assign301;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Charles Flaten on 3/30/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>  {

    List<Album> albums;
   Context context;


    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view,new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ///// Extra
                Intent intent = new Intent(view.getContext(), View.OnClickListener.class);


                intent.putExtra("Album Cover Art", albums.get(position).getAlbumCoverArt());
                intent.putExtra("Name", albums.get(position).getName());
                intent.putExtra("Artist", albums.get(position).getArtist());
                intent.putExtra("Track Count", albums.get(position).getTrackCount());
                intent.putExtra("Year", albums.get(position).getYear());
                intent.putExtra("Publisher", albums.get(position).getPublisher());

                context.startActivity(intent);

                ////

            }
        });
        return viewHolder;

    }
    @Override
    // This method assigns the values from the contacts list we passed in to the views
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.albumCoverArt.setImageResource(albums.get(position).getAlbumCoverArt());
        holder.albumName.setText(albums.get(position).getName());
        holder.albumArtist.setText(albums.get(position).getArtist());
        holder.albumTrackCount.setText(Integer.toString(albums.get(position).getTrackCount()));
        holder.albumYear.setText(Integer.toString(albums.get(position).getYear()));
        holder.albumPublisher.setText(albums.get(position).getPublisher());
    }

    @Override
    // This simple method is needed for the RecyclerView.
    public int getItemCount() {

        return albums.size();
    }

    // This is our ViewHolder inner class. Very important!
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        ImageView albumCoverArt;
        TextView albumName;
        TextView albumArtist;
        TextView albumTrackCount;
        TextView albumYear;
        TextView albumPublisher;


        // We map our views, and assign listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            albumCoverArt = (ImageView) itemView.findViewById(R.id.album_cover_art);
            albumName = (TextView) itemView.findViewById(R.id.album_name);
            albumArtist = (TextView) itemView.findViewById(R.id.album_artist);
            albumTrackCount = (TextView) itemView.findViewById(R.id.album_track_count);
            albumYear = (TextView) itemView.findViewById(R.id.album_year);
            albumPublisher = (TextView) itemView.findViewById(R.id.album_publisher);

            albumCoverArt.setOnClickListener(this);

            //albumName.setOnClickListener(this);
           // albumArtist.setOnClickListener(this);
           // albumTrackCount.setOnClickListener(this);
            //albumYear.setOnClickListener(this);
            //albumPublisher.setOnClickListener(this);
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
