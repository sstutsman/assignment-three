package com.example.br161.assignmentthree;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by al1694bc on 3/30/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> albums;

    public AlbumAdapter(List<Album> albums) {

        this.albums = albums;
    }//end AlbumAdapter method

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // This line inflates the layout which will be repeated
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        // We create an instance of our ViewHolder so we can handle click events.
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // We can handle click events in here, but only if we have
                // registered the listeners in the ViewHolder
            }//end onItemClick
        });//end ViewHolder viewHolder = new ViewHolder
        return viewHolder;
    }//end onCreateViewHolder method

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String imageName = albums.get(position).getAlbumCoverName();

        holder.tvTitle.setText(albums.get(position).getTitle());
        holder.tvArtist.setText(albums.get(position).getArtist());
        holder.tvGenre.setText(albums.get(position).getGenre());
        holder.tvPublisher.setText(albums.get(position).getPublisher());
        holder.tvNumTracks.setText(albums.get(position).getNumTracks() + " Tracks");
        holder.tvYear.setText(albums.get(position).getYear() + "");
        holder.albumCover.setImageDrawable(Drawable.createFromPath(imageName));
        //TODO fix the image path
    }//end onBindViewHolder method

    @Override
    public int getItemCount() {

        return albums.size();
    }//end getItemCount method


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        ImageView albumCover;

        TextView tvTitle;

        TextView tvArtist;

        TextView tvPublisher;

        TextView tvGenre;

        TextView tvNumTracks;

        TextView tvYear;

        // We map our views, and assign listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;

            albumCover = (ImageView) itemView.findViewById(R.id.image_album_cover);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_album_title);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_publisher);
            tvGenre = (TextView) itemView.findViewById(R.id.tv_genre);
            tvNumTracks = (TextView) itemView.findViewById(R.id.tv_num_tracks);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);

            albumCover.setOnClickListener(this);
        }//end ViewHolder method

        // This method is just to pass on the onClick event to our individual items! Neat!
        @Override
        public void onClick(View view) {

            listener.onItemClick(view, getPosition());
        }

        // This is the interface which forces our Adapter to implement the OnClickListener
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }//end ItemClickListener interface
    }//end ViewHolder class
}//end AlbumAdapter class
