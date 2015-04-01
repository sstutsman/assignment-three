package com.example.julio.albumstore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;

import java.io.InputStream;
import java.util.List;

/**
 * Created by jcs on 4/1/15.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private List<Album> albumList;
    protected LayoutInflater inflater;
    private Bitmap bitmap;
    private ImageView tempImageView;
    private RecyclerView albumRecyclerView;



    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        public TextView nameView;
        public TextView artistView;
        public ImageView imageView;

        public AlbumViewHolder(View v) {
            super(v);

            nameView = (TextView) v.findViewById(R.id.nameTextView);
            artistView = (TextView) v.findViewById(R.id.artistNameTextView);
            imageView = (ImageView) v.findViewById(R.id.albumImageView);
            albumRecyclerView = (RecyclerView) v.findViewById(R.id.albumRecycleView);




        }

    }

    public AlbumAdapter(Context context, List<Album> list){

        inflater = LayoutInflater.from(context);
        this.albumList = list;
        tempImageView = new ImageView(context);

    }


    @Override
    public int getItemCount(){
        return albumList.size();
    }




@Override
public AlbumAdapter.AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

    View view = inflater.inflate(R.layout.album_layout,viewGroup,false);



return new AlbumViewHolder(view);

}

    @Override
    public void onBindViewHolder(AlbumViewHolder albumViewHolder, int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Album album = albumList.get(i);
        albumViewHolder.nameView.setText(album.name);
        albumViewHolder.artistView.setText(album.artistName);


        Picasso.with(albumViewHolder.imageView.getContext()).load(album.coverArtURLString).into(albumViewHolder.imageView);



    }






}
