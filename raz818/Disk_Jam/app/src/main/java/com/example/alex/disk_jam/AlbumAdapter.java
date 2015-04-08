package com.example.alex.disk_jam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alex on 4/1/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    List<Album> albums;

    public AlbumAdapter(List<Album> albums){
        this.albums = albums;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener(){
            public void onItemClick(View view, int position){

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_Title.setText(albums.get(position).getTitle());
        holder.tv_Artist.setText(albums.get(position).getArtist());
        holder.tv_Tracks.setText(albums.get(position).getTrackCt());
        holder.tv_Year.setText(albums.get(position).getPubYr());
        holder.tv_Pub.setText(albums.get(position).getPublisher());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ItemClickListener listener;

        ImageView iv_AlbumArt;
        TextView tv_Title;
        TextView tv_Artist;
        TextView tv_Tracks;
        TextView tv_Year;
        TextView tv_Pub;
        LinearLayout layout_Album;

        public ViewHolder(View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;
            iv_AlbumArt = (ImageView) itemView.findViewById(R.id.ivAlbumArt);
            tv_Title = (TextView) itemView.findViewById(R.id.tvTitle);
            tv_Artist = (TextView) itemView.findViewById(R.id.tvArtist);
            tv_Tracks = (TextView) itemView.findViewById(R.id.tvTracks);
            tv_Year = (TextView) itemView.findViewById(R.id.tvYear);
            tv_Pub = (TextView) itemView.findViewById(R.id.tvPub);
            layout_Album = (LinearLayout) itemView.findViewById(R.id.layoutAlbum);

            layout_Album.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }

        public interface ItemClickListener{
            void onItemClick(View view, int position);
        }
    }
}
