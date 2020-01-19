package com.example.childrenmusic.kobeie.player;

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
import com.example.childrenmusic.badi.player.SurnaActivity;
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

public class DoholActivity extends AppCompatActivity {

    private PlayerControlView player_view_dohol;
    private SimpleExoPlayer player;
    private ImageView dohol_img;
    String uri;
    TextView txt_dohol,txt_controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dohol);
        player_view_dohol=findViewById(R.id.player_view_dohol);
        dohol_img=findViewById(R.id.dohol_img);
        txt_controller=findViewById(R.id.txt);

        txt_dohol=findViewById(R.id.txt_dohol);
        Typeface typface=Typeface.createFromAsset(getAssets(),"fonts/iransans.ttf");
        txt_dohol.setTypeface(typface);
        txt_controller.setTypeface(typface);
        txt_dohol.setMovementMethod(new ScrollingMovementMethod());

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id) {
            case 0:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qaval_player, null));
                txt_dohol.setText("«قاوالِ» آذربایجان و «دایره» یا «دفِ» کردستان شامل یک حلقه\u200Cي چوبی به شکل دایره است که یک طرف آن را پوست یا تلق می\u200Cکشند. درون دایره هم حلقه\u200Cهایی فلزی آویزان است که با پوست در تماس\u200Cاند. نوازنده ساز را از طریق ضربه زدنِ (کوبیدنِ) دست به پوست می\u200Cنوازد.");
                uri = "http://79.175.176.185:7589/ghaval.mp3";
                txt_controller.setText("موسیقی قاوال");
                break;
            case 1:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.naqare_player, null));
                txt_controller.setText("موسیقی نقاره");
                uri = "http://79.175.176.185:7589/naghare.mp3";
                txt_dohol.setText("«نقّاره»\u200Cي خراسان، «ناقاره\u200C»ي  قشقایی و بختیاری و «دوسَرکوتِن» گیلان و مازندران بسیار به هم شبیه\u200Cاند و در واقع سازهایی هستند که دو سر دارد و بر سر آن کوبیده می\u200Cشود. \n" +
                        "اين ساز، دو طبل دارد که با ریسمان به هم متّصل\u200Cاند. یکی از طبل\u200Cها بزرگ\u200Cتر است. نوازنده، ساز را با دو مضراب چوبی می\u200Cنوازد. چوب بزرگ\u200Cتر برای دست راست و طبل بزرگ\u200Cتر است و چوب کوچک\u200Cتر برای دست چپ و طبل کوچک\u200Cتر. (خوب شاید ما چپ\u200Cدست\u200Cها بتوانیم برعکس عمل کنیم!) پوست رويه\u200Cي طبل\u200Cها از پوست گاو است و بدنه\u200Cي آن هم از مس و یا سفال.\n");
                break;
            case 2:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.dohol_player, null));
                txt_controller.setText("موسیقی دهل");
                uri = "http://79.175.176.185:7589/dohol.mp3";
                txt_dohol.setText("«دُهُلِ» بندرعباس و خراسان و بوشهر، «دَمّام» بوشهر، «تیمبکِ (طمبوکِ)» سیستان و «دُهُلَکِ» بلوچستان از این نظر به هم شبیه\u200Cاند که بدنه\u200Cي استوانه\u200Cشکلی دارند و دو طرف این بدنه پوست کشیده شده و نوازنده روی پوست می\u200Cکوبد.\n" +
                        " البته سازهایی که در این صفحه نام برده شدند، با هم تفاوت\u200Cهایی دارند؛ از جمله تفاوت در اندازه و یا در شیوه\u200Cي نواختن. مثلاً دهلک را روی زمین مي\u200Cگذارند و می\u200Cنوازند اما تیمبوک را با تسمه\u200Cای روی شانه آویزان می\u200Cکنند. دهل را با کوبیدن دو چوب به دو طرف آن می\u200Cنوازند امّا در مورد تیمبوک طرف راست را با چوب و طرف چپ را با دست می\u200Cکوبند.\n");
                break;
            case 3:
                dohol_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.senj_player, null));
                txt_controller.setText("موسیقی سنج");
                uri = "http://79.175.176.185:7589/senj.mp3";
                txt_dohol.setText("فلزی دایره\u200Cشکل است که وسطش کمی تو رفته است تا دسته\u200Cي ساز را تشکیل بدهد. نوازنده دسته\u200Cي ساز را در دست می\u200Cگیرد و دو سنج را به هم می\u200Cکوبد.");
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        dohol_img.startAnimation(animation1);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animation2 =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.animation);
                dohol_img.setAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TrackSelector trackSelector=new DefaultTrackSelector();
        player= ExoPlayerFactory.newSimpleInstance(this,trackSelector);
        player_view_dohol.setPlayer(player);

        player_view_dohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_view_dohol.startAnimation(animation1);
            }
        });

        DataSource.Factory dataSourceFactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,"EXOPlayer"));

        Uri audioSourceUri= Uri.parse(uri);

        MediaSource audioSource=new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(audioSourceUri);

        player.prepare(audioSource);

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
                AlertDialog.Builder builder = new AlertDialog.Builder(DoholActivity.this);
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

