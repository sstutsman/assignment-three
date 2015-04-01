package com.example.joseph.assignmentthree;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joseph on 3/30/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    List<Album> albums;
    Activity main;

    public AlbumAdapter(List<Album> albums, Activity aba) {
        this.albums = albums;
        main = aba;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(main, AlbumActivity.class);
                intent.putExtra("name", albums.get(position).getName());
                intent.putExtra("artist", albums.get(position).getArtist());
                intent.putExtra("track_count", albums.get(position).getTrack_count());
                intent.putExtra("year", albums.get(position).getYear());
                intent.putExtra("publisher", albums.get(position).getPublisher());
                intent.putExtra("cover", albums.get(position).getCover_art());
                main.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(albums.get(position).getName());
        holder.tvArtist.setText(albums.get(position).getArtist());
        holder.tvTrack_count.setText(Integer.toString(albums.get(position).getTrack_count()));
        holder.tvYear.setText(Integer.toString(albums.get(position).getYear()));
        holder.tvPubliser.setText(albums.get(position).getPublisher());
        holder.ivCover.setImageResource(albums.get(position).getCover_art());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        TextView tvName;
        TextView tvArtist;
        TextView tvTrack_count;
        TextView tvYear;
        TextView tvPubliser;
        ImageView ivCover;


        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            tvTrack_count = (TextView) itemView.findViewById(R.id.tv_track_count);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
            tvPubliser = (TextView) itemView.findViewById(R.id.tv_publisher);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover_art);

            tvName.setOnClickListener(this);
            tvArtist.setOnClickListener(this);
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

