package com.example.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Word[] words;
    private int mColorResourceId;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;


    // Provide a suitable constructor (depends on the kind of dataset)
    public WordAdapter(Word[] words, int newColor) {
        this.words = words;
        this.mColorResourceId = newColor;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView miwokTextView;
        private TextView defaultTextView;
        private ImageView imageResourceId;
        private LinearLayout linearLayout;
        private ImageView playButtonImageView;
        private RelativeLayout relativeLayout;

        private ViewHolder(View itemView) {
            super(itemView);
            miwokTextView = (TextView) itemView.findViewById(R.id.miwok_text_view);
            defaultTextView = (TextView) itemView.findViewById(R.id.default_text_view);
            imageResourceId = (ImageView) itemView.findViewById(R.id.image_view);
            playButtonImageView = (ImageView) itemView.findViewById(R.id.play_button_image_view);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.text_container);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =     new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mMediaPlayer.stop();
                releaseMediaPlayer();
            }
        }
    };


    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Word currentWord = words[position];
        //setting the text views of miwok and default translation
        holder.miwokTextView.setText(currentWord.getMiwokTranslation());
        holder.defaultTextView.setText(currentWord.getDefaultTranslation());

        //checking to see whether the function in Word class comes true/false and show
        // image in Numbers, colors, family activity except phrases activity
        if (currentWord.hasImage()) {
            holder.imageResourceId.setImageResource(currentWord.getImageResource());
            holder.imageResourceId.setVisibility(View.VISIBLE);
        } else {
            holder.imageResourceId.setVisibility(View.GONE);
        }

        //setting a click listener on linear layout
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create and setup the {@link AudioManager} to request audio focus
                mAudioManager= (AudioManager) v.getContext().getSystemService(Context.AUDIO_SERVICE);
                // Release the media player if it currently exists because we are about to
                // play a different sound file. If a user clicks on too many sound files at once,
                // onCompletionListener might not get triggered so we need to free up the mediaplayer everytime user clicks on an
                // audio to play to clean the memory.
                releaseMediaPlayer();

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result= mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create(v.getContext(), currentWord.getmAudioResourceId());
                    // Start the audio file
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        //Setting the background color in linear layout attached
        // (using setBackgroundResources instead of setBackgroundColor)
        holder.linearLayout.setBackgroundResource(mColorResourceId);
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        // When the activity is stopped, release the media player resources because we won't
//        // be playing any more sounds.
//        releaseMediaPlayer();
//    }



    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    public int getItemCount() {
        return words.length;
    }


}