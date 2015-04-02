package com.example.br161.peterassignment_cubed;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Peter Thompson on 4/1/2015.
 */
public class CDAdapter extends RecyclerView.Adapter<CDAdapter.ViewHolder> {
    List<CDAlbum> myCollection;

    //Constructor. Passes data from fragment
    public CDAdapter(List<CDAlbum> myCollection) {
        this.myCollection = myCollection;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // This line inflates the layout which will be repeated
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_albumlisting_brief, parent, false);

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
        holder.tvArtist.setText(myCollection.get(position).getAlbumArtist());
        holder.tvAlbum.setText(myCollection.get(position).getAlbumName());
        holder.imgAlbumCover.setImageResource(myCollection.get(position).getAlbumCover());
    }

    /*
     *
     * VISUAL BREAK OF CODE
     *
     *
     */
    public int getItemCount() {
        return myCollection.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        ImageView imgAlbumCover;
        TextView tvArtist;
        TextView tvAlbum;


        // We map our views, and assign listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            imgAlbumCover = (ImageView) itemView.findViewById(R.id.draw_albumcover);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artistname);
            tvAlbum = (TextView) itemView.findViewById(R.id.tv_albumName);

            tvArtist.setOnClickListener(this);
            tvAlbum.setOnClickListener(this);
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



