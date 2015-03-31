package com.example.elise.assignment_three;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Elise on 3/30/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    List<Album> albums;

    public AlbumAdapter(List<Album> albums){
        this.albums = albums;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext().inflate(R.layout.item_album,parent,false));

        RecyclerView.ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener(){
            public void onItemClick(View view, int position){

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivAlbum.setDrawable();

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ItemClickListener listener;

        ImageView ivCover;
        TextView tvName;
        TextView tvArtist;
        TextView tvTrackCount;
        TextView tvYear;
        TextView tvPublisher;

        public ViewHolder (View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;

            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            tvTrackCount = (TextView) itemView.findViewById(R.id.tv_track_count);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher);

            ivCover.setOnClickListener(this);
            tvName.setOnClickListener(this);
            tvArtist.setOnClickListener(this);
            tvTrackCount.setOnClickListener(this);
            tvYear.setOnClickListener(this);
            tvPublisher.setOnClickListener(this);
            
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
