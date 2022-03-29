package com.gunu.blackbox_v50;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        videoView = findViewById(R.id.videoView);

        Button btnPlay, btnStop, btnPause;
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPause = (Button) findViewById(R.id.btnPause);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        Intent inIntent = getIntent();
        String test = (inIntent.getStringExtra("Name"));

        Uri uri = Uri.parse(test);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                finish();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                videoView.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                videoView.pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
