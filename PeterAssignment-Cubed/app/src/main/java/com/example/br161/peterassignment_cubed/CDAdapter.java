package com.example.br161.peterassignment_cubed;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Peter Thompson on 4/1/2015.
 */
public class CDAdapter extends RecyclerView.Adapter<CDAdapter.ViewHolder> {
    List<CDAlbum> myCollection;
    Activity main;

    //Constructor. Passes data from fragment
    public CDAdapter(List<CDAlbum> myCollection, Activity something) {
        this.myCollection = myCollection;
        main = something;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_albumlisting_brief, parent, false);

        // We create an instance of our ViewHolder so we can handle click events.
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(main, FullAlbumActivity.class);
                intent.putExtra("albumArt", myCollection.get(position).getAlbumCover());  //Integer
                intent.putExtra("artistName", myCollection.get(position).getAlbumArtist());
                intent.putExtra("albumName",myCollection.get(position).getAlbumName());
                intent.putExtra("publisher",myCollection.get(position).getAlbumPublisher());
                intent.putExtra("year",myCollection.get(position).getAlbumYear());
                intent.putExtra("genre", myCollection.get(position).getAlbumGenre());
                intent.putExtra("trackCt", myCollection.get(position).getAlbumTrackCount());
            }
        });
        return viewHolder;

    }

    @Override
    // This method assigns the values from the contacts list we passed in to the views
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvArtist.setText(myCollection.get(position).getAlbumArtist());
        holder.tvAlbum.setText(myCollection.get(position).getAlbumName());
        holder.imgAlbumCover.setImageResource(myCollection.get(position).getAlbumCover());
    }

    public int getItemCount() {
        return myCollection.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemClickListener listener;

        ImageView imgAlbumCover;
        TextView tvArtist;
        TextView tvAlbum;
        LinearLayout layout;


        // We map our views, and assign listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;

            layout = (LinearLayout) itemView.findViewById(R.id.recycler_oneAlbum_brief);
            imgAlbumCover = (ImageView) itemView.findViewById(R.id.draw_albumcover);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artistName);
            tvAlbum = (TextView) itemView.findViewById(R.id.tv_albumName);

            tvArtist.setOnClickListener(this);
            tvAlbum.setOnClickListener(this);
        }



        // This method is just to pass on the onClick event to our individual items! Neat!
        @Override
        public void onClick(View view) {
                    //listener.onItemClick(view, getPosition());
            if(listener!=null) {
                listener.onItemClick(view, getPosition());

            }
        }

        // This is the interface which forces our Adapter to implement the OnClickListener
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}


