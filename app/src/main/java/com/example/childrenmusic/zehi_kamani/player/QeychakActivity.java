package com.example.childrenmusic.zehi_kamani.player;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.childrenmusic.R;
import com.example.childrenmusic.radifi.player.QanonActivity;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class QeychakActivity extends AppCompatActivity {

    private SimpleExoPlayer player;
    private PlayerControlView player_view_qeychak;
    ImageView qeychak_img;
    String uri;
    TextView txt_qeychak,txt_controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qeychak);
        player_view_qeychak=findViewById(R.id.player_view_qeychak);
        qeychak_img=findViewById(R.id.qeychak_img);
        txt_controller=findViewById(R.id.txt);

        txt_qeychak=findViewById(R.id.txt_qeychak);
        Typeface typface=Typeface.createFromAsset(getAssets(),"fonts/iransans.ttf");
        txt_qeychak.setTypeface(typface);
        txt_controller.setTypeface(typface);
        txt_qeychak.setMovementMethod(new ScrollingMovementMethod());

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id) {
            case 0:
                qeychak_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.kamanche_player, null));
                uri = "http://79.175.176.185:7589/kamanche.mp3";
                txt_controller.setText("نوایی از ساز کمانچه");
                txt_qeychak.setText("«کمانچه\u200C»ي لرستان یا «قِجَقِ» ترکمن، شامل یک کاسه\u200Cي صوتی است که روی آن پوست کشیده می\u200Cشود. انتهای کاسه یک میله\u200Cی فلزی نازک دارد. وقتی نوازنده این ساز را می\u200Cنوازد آن را عمودی می\u200Cگیرد، نوک میله را روی زمین می\u200Cگذارد و با یک دست کمانه را روی سیم\u200Cها می\u200Cکشد. نوازنده می\u200Cتواند هنگام مالشِ کمانه ساز را روی پایه\u200Cي فلزی کمی بچرخاند و با این کار صدای متفاوتی ایجاد کند. کاسه\u200Cي کمانچه ترکه\u200Cای است. پشت کاسه\u200Cي کمانچه\u200Cي لرستان باز است.");
                break;
            case 1:
                qeychak_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qeychak_player, null));
                txt_qeychak.setText("قیچک سازی کمانی است و مربوط به سيستان و بلوچستان. جلوی کاسه\u200Cي قیچک شبیه لنگر کشتی است. کمانه\u200Cي قیچک خمیده است و قیچک را هم مثل کمانچه موقع نواختن عمودی می\u200Cگیرند.");
                txt_controller.setText("نوایی از ساز قیچک");
                uri = "http://79.175.176.185:7589/ghezhak.mp3";
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        qeychak_img.startAnimation(animation1);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animation2 =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.animation);
                qeychak_img.setAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        qeychak_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qeychak_img.startAnimation(animation1);
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TrackSelector trackSelector=new DefaultTrackSelector();
        player= ExoPlayerFactory.newSimpleInstance(this,trackSelector);

        player_view_qeychak.setPlayer(player);

        DataSource.Factory daFactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,"EXOPlayer"));

        //  Uri audioUri=Uri.parse("file:///android_asset/dohol.mp3");
        Uri audioUri=Uri.parse(uri);

        MediaSource mediaSource=new ExtractorMediaSource.Factory(daFactory)
                .createMediaSource(audioUri);

        player.prepare(mediaSource);

        player.addListener(new Player.EventListener() {

            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {
                AlertDialog.Builder builder = new AlertDialog.Builder(QeychakActivity.this);
                builder.setTitle("مشکل در پخش ");
                builder.setIcon(R.drawable.nheadphones);
                builder.setMessage("در پخش موزیک مشکل پیش آمده لطفا مجدد تلاش کنید");

                builder.setNegativeButton("باشه", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}

