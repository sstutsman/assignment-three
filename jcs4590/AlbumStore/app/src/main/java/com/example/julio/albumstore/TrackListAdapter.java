package com.example.julio.albumstore;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

/**
 * Created by jcs on 4/5/15.
 */
public class TrackListAdapter extends ArrayAdapter<Album.Track>  {
    private List<Album.Track> tracksList;
    private Context context;
    private View customView;
    public static MediaPlayer mediaPlayer;
    private ImageButton previewImageButton;
    private ListView trackListView;
    private Album.Track track;
    private Integer currentTrackPlayingPosition;

     TrackListAdapter(final Context context,Album.Track[] tracksList) {
        super(context,R.layout.track_custom_row,tracksList);
         mediaPlayer =  new MediaPlayer();
         mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
         mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
             @Override
             public void onPrepared(MediaPlayer mp) {
                 mp.start();
             }
         });
         View view = View.inflate(context, R.layout.activity_album_detail, null);

         trackListView = (ListView) view.findViewById(R.id.trackslistView);



        this.context = context;






    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        customView =  inflater.inflate(R.layout.track_custom_row,parent,false);

        TextView trackNameTextView = (TextView) customView.findViewById(R.id.trackNameTextView);
        final TextView artistNameTextView = (TextView) customView.findViewById(R.id.artistNameTextView);
        previewImageButton = (ImageButton) customView.findViewById(R.id.previewImageButton);

         track = (Album.Track)getItem(position);
        trackNameTextView.setText(track.getName());
        artistNameTextView.setText(track.getArtists()[0].getName());




        previewImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()){

                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    if(currentTrackPlayingPosition != null && currentTrackPlayingPosition != position){
                        try {
                            mediaPlayer.setDataSource(customView.getContext(), Uri.parse(track.getPreview_url()));
                            mediaPlayer.prepareAsync();

                            previewImageButton.setImageResource(R.drawable.pauseicon);




                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        previewImageButton.setImageResource(R.drawable.playicon);

                    }

                }else {


                    try {
                        mediaPlayer.setDataSource(customView.getContext(), Uri.parse(track.getPreview_url()));
                        mediaPlayer.prepareAsync();
                        previewImageButton.setImageResource(R.drawable.pauseicon);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                currentTrackPlayingPosition = position;

            }
        });



            return customView;
    }


}
