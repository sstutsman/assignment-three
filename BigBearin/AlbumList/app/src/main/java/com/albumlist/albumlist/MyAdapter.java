package com.albumlist.albumlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private AlbumData[] itemsData;

    public MyAdapter(AlbumData[] itemsData){
        this.itemsData = itemsData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
//            implements View.OnClickListener (

        private TextView txtViewTitle;
        private ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
//            itemLayoutView.setOnClickListener(this);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.album_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.album_icon);
        }

//        @Override
//        public void onClick(View v) {
//
//        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_layout, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.txtViewTitle.setText(itemsData[position].getTitle());
        viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());
    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }

}
