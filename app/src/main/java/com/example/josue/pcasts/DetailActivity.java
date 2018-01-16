package com.example.josue.pcasts;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {
    Toolbar toolbar2;
    MediaPlayer mediaPlayer;
    TextView txtTitle, txtPubDate, txtContent, txtDuration;
    String txtURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        toolbar2.setTitle("");
        setSupportActionBar(toolbar2);

        Intent intent = getIntent();
        String txtTit = intent.getStringExtra("title");
        String txtPD = intent.getStringExtra("pubDate");
        String txtCont = intent.getStringExtra("content");
        Integer duration = intent.getIntExtra("duration", 0);
        String duracao = secondsToString(duration);


        txtURL = intent.getStringExtra("url");

        txtTitle = (TextView) findViewById(R.id.txtTitleD);
        txtPubDate = (TextView) findViewById(R.id.txtPubDateD);
        txtContent = (TextView) findViewById(R.id.txtContentD);
        txtDuration = (TextView) findViewById(R.id.txtDuration);
        txtTitle.setSelected(true);
        txtTitle.setText(txtTit);
        txtPubDate.setText(txtPD);
        txtContent.setText(txtCont);
        txtDuration.setText("Duração: " + duracao);

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(txtURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void goBack() {
        mediaPlayer.reset();
        mediaPlayer.release();
        finish();
    }

    public void playMedia(View v) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(30000);
        } else {
            mediaPlayer.seekTo(30000);
            mediaPlayer.start();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    private String secondsToString(int pTime) {
        return String.format("%02d:%02d", pTime / 60, pTime % 60);
    }

}
