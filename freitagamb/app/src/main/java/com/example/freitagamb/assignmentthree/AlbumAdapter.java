package com.example.freitagamb.assignmentthree;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<AlbumInfo> albumList;

    public AlbumAdapter(List<AlbumInfo> albumList) {
        this.albumList = albumList;
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int i) {
        AlbumInfo current = albumList.get(i);
        holder.title.setText(current.artist + " - " + current.album);
        holder.coverArt.setImageResource(current.artID);
        holder.artistName.setText(current.artist);
        holder.albumName.setText(current.album);
        holder.year.setText("("+Integer.toString(current.year)+")");
        holder.publisher.setText(current.publisher);
        holder.trackCnt.setText(Integer.toString(current.trackCnt)+ " tracks on disc");
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.album_tile, viewGroup, false);

        return new AlbumViewHolder(itemView);
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView coverArt;
        TextView artistName;
        TextView albumName;
        TextView year;
        TextView publisher;
        TextView trackCnt;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            coverArt = (ImageView) itemView.findViewById(R.id.coverArt);
            artistName = (TextView) itemView.findViewById(R.id.txtArtistName);
            albumName = (TextView) itemView.findViewById(R.id.txtAlbumName);
            year = (TextView) itemView.findViewById(R.id.txtYear);
            publisher = (TextView) itemView.findViewById(R.id.txtPublisher);
            trackCnt = (TextView) itemView.findViewById(R.id.txtTrackCnt);
        }
    }
}
