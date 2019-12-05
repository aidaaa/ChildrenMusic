package com.example.childrenmusic.radifi.player;

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

public class QanonActivity extends AppCompatActivity {


    private SimpleExoPlayer player;
    private PlayerControlView player_view_qanon;
    ImageView qanon_img;
    String uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qanon);

        player_view_qanon=findViewById(R.id.player_view_qanon);
        qanon_img=findViewById(R.id.qanon_img);

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id)
        {
            case 0:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.setar_player, null));
                uri = "http://192.168.10.184:8099/setar.mp3";
                break;
            case 1:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.tar_player, null));
                uri = "http://192.168.10.184:8099/tar.mp3";
                break;
            case 2:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.tombak_player, null));
                uri = "http://192.168.10.184:8099/tombak.mp3";
                break;
            case 3:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qanon_player, null));
                uri = "http://192.168.10.184:8099/ghanun.mp3";
                break;
            case 4:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.santor_player, null));
                uri = "http://192.168.10.184:8099/santur.mp3";
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        qanon_img.startAnimation(animation1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TrackSelector trackSelector=new DefaultTrackSelector();
        player= ExoPlayerFactory.newSimpleInstance(this,trackSelector);

        player_view_qanon.setPlayer(player);

        DataSource.Factory daFactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,"EXOPlayer"));

        //  Uri audioUri=Uri.parse("file:///android_asset/dohol.mp3");
        Uri audioUri=Uri.parse(uri);

        MediaSource mediaSource=new ExtractorMediaSource.Factory(daFactory)
                .createMediaSource(audioUri);

        player.prepare(mediaSource);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}

