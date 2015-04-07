package com.example.elise.assignment_three;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by Elise Johnson on 3/30/2015.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    //Variables
    Context context;
    List<Album> albums;

    //Constructor to create the adapter and pass in necessary values from recycler view fragment
    public AlbumAdapter(List<Album> albums, Context context){
        this.albums = albums;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflates layout to repeat for each album in the list
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        //Create instance of the ViewHolder to handle when the user clicks on an album
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener(){
            @Override
            public void onItemClick(View view, int position){

                //Converting drawable to a byte array to add to the new intent
                Drawable cover = albums.get(position).getCover();
                Bitmap bitmap = ((BitmapDrawable)cover).getBitmap();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
                byte[] b = output.toByteArray();

                //Getting the album information for the item clicked on
                String name = albums.get(position).getName();
                String artist = albums.get(position).getArtist();
                String track_count = albums.get(position).getTrackCount().toString();
                String year = albums.get(position).getYear().toString();
                String publisher = albums.get(position).getPublisher();

                //Adding a new intent with flags because the adapter is not an activity
                Intent intent = new Intent(context, SecondActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //Adding the byte array and the strings to the new intent
                intent.putExtra("cover",b);
                intent.putExtra("name", name);
                intent.putExtra("artist", artist);
                intent.putExtra("tracks", track_count);
                intent.putExtra("year", year);
                intent.putExtra("publisher", publisher);

                //Start the second activity
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    //Assigns values from the albums list to the views
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivCover.setImageDrawable(albums.get(position).getCover());
        holder.tvName.setText(albums.get(position).getName());
        holder.tvArtist.setText(albums.get(position).getArtist());
        holder.tvTrackCount.setText(albums.get(position).getTrackCount()+" tracks");
        holder.tvYear.setText("Released in "+albums.get(position).getYear());
        holder.tvPublisher.setText("Published by "+albums.get(position).getPublisher());
    }

    @Override
    //Required method for RecyclerView
    public int getItemCount() {
        return albums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Variables
        ItemClickListener listener;

        ImageView ivCover;
        TextView tvName;
        TextView tvArtist;
        TextView tvTrackCount;
        TextView tvYear;
        TextView tvPublisher;

        //ViewHolder constructor maps views and assigns listeners to each view
        public ViewHolder (View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;

            //Mapping views
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            tvTrackCount = (TextView) itemView.findViewById(R.id.tv_track_count);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher);

            //Assigning listeners
            ivCover.setOnClickListener(this);
            tvName.setOnClickListener(this);
            tvArtist.setOnClickListener(this);
            tvTrackCount.setOnClickListener(this);
            tvYear.setOnClickListener(this);
            tvPublisher.setOnClickListener(this);
            
        }

        @Override
        //Passes the onClick event to individual items
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }

        //Interface which forces the adapter to implement the OnClickListener
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}
