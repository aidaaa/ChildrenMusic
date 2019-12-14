package com.example.childrenmusic.kobeie.player;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.childrenmusic.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class DoholActivity extends AppCompatActivity {

    private PlayerControlView player_view_dohol;
    private SimpleExoPlayer player;
    private ImageView dohol_img;
    String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dohol);
        player_view_dohol=findViewById(R.id.player_view_dohol);
        dohol_img=findViewById(R.id.dohol_img);

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id) {
            case 0:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qaval_player, null));
                uri = "http://192.168.10.85:8099/sorna.mp3";
                break;
            case 1:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.naqare_player, null));
                uri = "http://192.168.10.85:8099/naghare.mp3";
                break;
            case 2:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.dohol_player, null));
                uri = "http://192.168.10.85:8099/dohol.mp3";
                break;
            case 3:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.senj_player, null));
                uri = "http://192.168.10.85:8099/sorna.mp3";
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        dohol_img.startAnimation(animation1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TrackSelector trackSelector=new DefaultTrackSelector();
        player= ExoPlayerFactory.newSimpleInstance(this,trackSelector);
        player_view_dohol.setPlayer(player);

        DataSource.Factory dataSourceFactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,"EXOPlayer"));

        Uri audioSourceUri= Uri.parse(uri);

        MediaSource audioSource=new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(audioSourceUri);

        player.prepare(audioSource);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}

