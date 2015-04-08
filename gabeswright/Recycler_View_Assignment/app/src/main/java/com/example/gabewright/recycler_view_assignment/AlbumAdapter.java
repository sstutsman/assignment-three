package com.example.gabewright.recycler_view_assignment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by GabeWright on 4/6/15.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    List<Album> albums;

    public AlbumAdapter(List<Album> albums) {this.albums = albums;}

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {

                //create intent and put in stuff to be passed to new activity

                Intent intent = new Intent(parent.getContext(), activity2.class);
                String name  = albums.get(position).getName();
                String year = albums.get(position).getYear();
                String publisher = albums.get(position).getPublisher();
                String tcount = albums.get(position).getTcount();
                String artist = albums.get(position).getArtist();
                String artint = Integer.toString(albums.get(position).getDrawableint());
                String funfact = albums.get(position).getFunFacts();

                intent.putExtra("name", name);
                intent.putExtra("year", year);
                intent.putExtra("publisher", publisher);
                intent.putExtra("tcount", tcount);
                intent.putExtra("artist", artist);
                intent.putExtra("artint", artint);
                intent.putExtra("funfact", funfact);

                //call intent
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //sets the info in the recycler view
        holder.tvName.setText(albums.get(position).getName());
        holder.tvArtist.setText(albums.get(position).getArtist());
        holder.tvTcount.setText(albums.get(position).getTcount());
        holder.tvPublisher.setText(albums.get(position).getPublisher());
        holder.tvYear.setText(albums.get(position).getYear());
        holder.ivArt.setImageDrawable(albums.get(position).getArt());

    }

    public int getItemCount() {return albums.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;
        TextView tvName;
        TextView tvArtist;
        TextView tvYear;
        TextView tvPublisher;
        TextView tvTcount;
        ImageView ivArt;

        public ViewHolder(View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;

            //set views in recyclerview
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher);
            tvTcount = (TextView) itemView.findViewById(R.id.tv_tcount);
            ivArt = (ImageView) itemView.findViewById(R.id.iv_art);

            //set onclick listener
            tvName.setOnClickListener(this);
            tvArtist.setOnClickListener(this);
            tvYear.setOnClickListener(this);
            tvPublisher.setOnClickListener(this);
            tvTcount.setOnClickListener(this);
            ivArt.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());


        }

        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}


