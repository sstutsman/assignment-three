package com.example.julio.albumstore;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by jcs on 4/1/15.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private List<Album> albumList;
    protected LayoutInflater inflater;
    private CardView cardView;



    public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nameView;
        public TextView artistView;
        public ImageView imageView;



        public AlbumViewHolder(View v) {
            super(v);

            nameView = (TextView) v.findViewById(R.id.nameTextView);
            artistView = (TextView) v.findViewById(R.id.artistNameTextView);
            imageView = (ImageView) v.findViewById(R.id.albumImageView);
            cardView = (CardView) v.findViewById(R.id.card_view);
            cardView.setOnClickListener(this);
            imageView.setOnClickListener(this);
            artistView.setOnClickListener(this);
            nameView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Gson gson = new Gson();
            String albumString = gson.toJson(albumList.get(getPosition()));
            Intent intent = new Intent(v.getContext(), AlbumDetailActivity.class);
            intent.putExtra("album",albumString);
            v.getContext().startActivity(intent);
        }
    }

    public AlbumAdapter(Context context, List<Album> list){

        inflater = LayoutInflater.from(context);
        this.albumList = list;

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
    public void onBindViewHolder(AlbumViewHolder albumViewHolder, final int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Album album = albumList.get(i);
        albumViewHolder.nameView.setText(album.getName());
        albumViewHolder.artistView.setText(album.getArtists()[0].getName());




        Picasso.with(albumViewHolder.imageView.getContext()).load(album.getImages()[0].getUrl()).into(albumViewHolder.imageView);



    }






}
