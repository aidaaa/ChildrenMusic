package com.example.childrenmusic.zehi_zakhmeie.player;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

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

public class BanjoActivity extends AppCompatActivity {

    private SimpleExoPlayer player;
    private PlayerControlView player_view_banjo;
    ImageView banjo_img;
    String uri;
    TextView txt_banjo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banjo);
        player_view_banjo=findViewById(R.id.player_view_banjo);
        banjo_img=findViewById(R.id.banjo_img);

        txt_banjo=findViewById(R.id.txt_banjo);
        Typeface typface=Typeface.createFromAsset(getAssets(),"fonts/iransans.ttf");
        txt_banjo.setTypeface(typface);

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id) {
            case 0:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.oud_player, null));
                uri = "http://192.168.10.85:8099/oud.mp3";
                break;
            case 1:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.robab_player, null));
                uri = "http://192.168.10.85:8099/robab.mp3";
                break;
            case 2:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.banjo_player, null));
                uri = "http://192.168.10.85:8099/banjo.mp3";
                break;
            case 3:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.zanborak_player, null));
                uri = "http://192.168.10.85:8099/zanburak.mp3";
                break;
        }


        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        banjo_img.startAnimation(animation1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TrackSelector trackSelector=new DefaultTrackSelector();
        player= ExoPlayerFactory.newSimpleInstance(this,trackSelector);

        player_view_banjo.setPlayer(player);

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

