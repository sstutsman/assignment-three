package com.maddux.assignmentthree;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by My Laptop on 4/7/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    List<Album> albums;

    public AlbumAdapter(List<Album> albums) { this.albums = albums; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(view.getContext(), onClickActivity.class);
                intent.putExtra("Art", albums.get(position).getArt());
                view.getContext().startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.albumArt.setImageResource(albums.get(position).getArt());
        holder.albumName.setText(albums.get(position).getName());
        holder.albumArtist.setText(albums.get(position).getArtist());
        holder.albumTrackCount.setText("Track Count: " + albums.get(position).getTrackCount());
        holder.albumYear.setText("Year: " + albums.get(position).getYear());
        holder.albumPublisher.setText(albums.get(position).getPublisher());
    }

    @Override
    public int getItemCount() { return albums.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        ImageView albumArt;
        TextView albumName;
        TextView albumArtist;
        TextView albumTrackCount;
        TextView albumYear;
        TextView albumPublisher;


        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            albumArt = (ImageView) itemView.findViewById((R.id.album_cover_art));
            albumName = (TextView) itemView.findViewById(R.id.album_name);
            albumArtist = (TextView) itemView.findViewById(R.id.album_artist);
            albumTrackCount = (TextView) itemView.findViewById(R.id.album_track);
            albumYear = (TextView) itemView.findViewById(R.id.album_year);
            albumPublisher = (TextView) itemView.findViewById(R.id.album_publisher);

            albumArt.setOnClickListener(this);
            albumName.setOnClickListener(this);
            albumArtist.setOnClickListener(this);
            albumTrackCount.setOnClickListener(this);
            albumYear.setOnClickListener(this);
            albumPublisher.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getAdapterPosition());
        }

        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}
