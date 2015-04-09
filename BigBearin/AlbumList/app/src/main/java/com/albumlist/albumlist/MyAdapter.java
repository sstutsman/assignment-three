package com.albumlist.albumlist;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private AlbumData[] itemsData;

    public MyAdapter(AlbumData[] itemsData){
        this.itemsData = itemsData;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView, new ViewHolder.ItemClickListener(){
            @Override
            public void onItemClick(View view, int position){

            }
        });
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

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;
        TextView txtViewTitle;
        ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView,ItemClickListener listener) {
            super(itemLayoutView);
            this.listener = listener;
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.album_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.album_icon);

            txtViewTitle.setOnClickListener(this);
            imgViewIcon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
//            Toast.makeText(v.getContext(),String.valueOf(getAdapterPosition()),Toast.LENGTH_LONG).show();

           if(getAdapterPosition() == 0){
               Intent myIntent = new Intent(v.getContext(), EscapeActivity.class);
               v.getContext().startActivity(myIntent);
           }
           else if (getAdapterPosition() == 1) {
                Intent myIntent = new Intent(v.getContext(), BornActivity.class);
                v.getContext().startActivity(myIntent);
           }
            else {
               Intent myIntent = new Intent(v.getContext(), DarkActivity.class);
               v.getContext().startActivity(myIntent);
           }
        }


        public interface ItemClickListener{
            void onItemClick(View view, int position);
        }

    }



}
