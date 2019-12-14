package com.example.childrenmusic.badi.player;

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
import com.example.childrenmusic.badi.BadyMainActivity;
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

public class SurnaActivity extends AppCompatActivity {
    private SimpleExoPlayer player;
    private PlayerControlView player_view_surna;
    ImageView surna_img;
    String uri ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surna);

        player_view_surna=findViewById(R.id.player_view_surna);
        surna_img=findViewById(R.id.surna_img);

        Intent intent=getIntent();
        int id = intent.getIntExtra("id",0);

        switch (id)
        {
            case 0:
               surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qerne_player,null));
               uri="http://192.168.10.85:8099/sorna.mp3";
                break;
            case 1:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.surna_player,null));
                uri="http://192.168.10.85:8099/sorna.mp3";
                break;
            case 2:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.ney_jofti_player,null));
                uri="http://192.168.10.85:8099/ney7band.mp3";
                break;
            case 3:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.ney_player,null));
                uri="http://192.168.10.85:8099/sorna.mp3";
                break;
            case 4:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.boq_player,null));
                uri="http://192.168.10.85:8099/sorna.mp3";
                break;
            case 5:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.ney_anbone,null));
                uri="http://192.168.10.85:8099/neyanbune.mp3";
                break;
            case 6:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.korna_player,null));
                uri="http://192.168.10.85:8099/karna.mp3";
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        surna_img.startAnimation(animation1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TrackSelector trackSelector=new DefaultTrackSelector();
        player= ExoPlayerFactory.newSimpleInstance(this,trackSelector);

        player_view_surna.setPlayer(player);

        DataSource.Factory daFactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,"EXOPlayer"));

       // Uri audioUri=Uri.parse("http://192.168.10.182:8099/sorna.mp3");
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
