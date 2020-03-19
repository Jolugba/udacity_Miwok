package com.example.udacity_miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    AudioManager audioManager;
    private MediaPlayer mediaPlayer;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                        // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                        // our app is allowed to continue playing sound but at a lower volume. We'll treat
                        // both cases the same way because our app is playing short sound files.

                        // Pause playback and reset player to the start of the file. That way, we can
                        // play the word from the beginning when we resume playback.
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                        // Stop playback and clean up resources
                        releaseMediaPlayer();

                    }

                }
            };
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        ListView listView = findViewById(R.id.list_item_View);


        //an ArrayList of words
        final ArrayList<Word> listOfNumbers = new ArrayList<Word>();

        listOfNumbers.add(new Word(R.drawable.color_red, "red", "wetetti", R.raw.color_red));
        listOfNumbers.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow", "chiwiite", R.raw.color_mustard_yellow));
        listOfNumbers.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow", "topiisa", R.raw.color_dusty_yellow));
        listOfNumbers.add(new Word(R.drawable.color_green, "green", "chokokki", R.raw.color_green));
        listOfNumbers.add(new Word(R.drawable.color_brown, "brown", "takaakki", R.raw.color_brown));
        listOfNumbers.add(new Word(R.drawable.color_gray, "gray", "topoppi", R.raw.color_gray));
        listOfNumbers.add(new Word(R.drawable.color_black, "black", "kululli", R.raw.color_black));
        listOfNumbers.add(new Word(R.drawable.color_white, "white", "kelelli", R.raw.color_white));


        WordAdapter adapter =
                new WordAdapter(this, listOfNumbers, R.color.category_colors);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = listOfNumbers.get(position);
                releaseMediaPlayer();

                //Request audioFocus for playback
                int result = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.
                                STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // audioManager.registerMediaButtonEventReceiver(RemoteControlReceiver);

                    mediaPlayer = MediaPlayer.create(Colors.this, word.getmAudioResource());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            //abandon audiofocus when playBack is complete
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }
}
