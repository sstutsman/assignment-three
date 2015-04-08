package com.example.freitagamb.assignmentthree;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    protected List<TrackInfo> trackList;

    public TrackAdapter(List<TrackInfo> trackList) {
        this.trackList = trackList;
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int i) {
        TrackInfo current = trackList.get(i);
        holder.title.setText(current.title);
        holder.time.setText(current.time);
        holder.trackNum.setText((i + 1) + ".");
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.track_tile, viewGroup, false);
        LinearLayoutManager lmgr = new LinearLayoutManager(viewGroup.getContext());
        return new TrackViewHolder(itemView);
    }

    class TrackViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        TextView trackNum;

        public TrackViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtTrackTitle);
            time = (TextView) itemView.findViewById(R.id.txtTrackLength);
            trackNum = (TextView) itemView.findViewById(R.id.txtTrackNum);
        }
    }

}
