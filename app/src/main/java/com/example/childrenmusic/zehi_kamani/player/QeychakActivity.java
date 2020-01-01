package com.example.childrenmusic.zehi_kamani.player;

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

public class QeychakActivity extends AppCompatActivity {

    private SimpleExoPlayer player;
    private PlayerControlView player_view_qeychak;
    ImageView qeychak_img;
    String uri;
    TextView txt_qeychak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qeychak);
        player_view_qeychak=findViewById(R.id.player_view_qeychak);
        qeychak_img=findViewById(R.id.qeychak_img);

        txt_qeychak=findViewById(R.id.txt_qeychak);
        Typeface typface=Typeface.createFromAsset(getAssets(),"fonts/iransans.ttf");
        txt_qeychak.setTypeface(typface);
        txt_qeychak.setMovementMethod(new ScrollingMovementMethod());

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id) {
            case 0:
                qeychak_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.kamanche_player, null));
                uri = "http://192.168.10.85:8099/kamanche.mp3";
                txt_qeychak.setText("«کمانچه\u200C»ي لرستان یا «قِجَقِ» ترکمن، شامل یک کاسه\u200Cي صوتی است که روی آن پوست کشیده می\u200Cشود. انتهای کاسه یک میله\u200Cی فلزی نازک دارد. وقتی نوازنده این ساز را می\u200Cنوازد آن را عمودی می\u200Cگیرد، نوک میله را روی زمین می\u200Cگذارد و با یک دست کمانه را روی سیم\u200Cها می\u200Cکشد. نوازنده می\u200Cتواند هنگام مالشِ کمانه ساز را روی پایه\u200Cي فلزی کمی بچرخاند و با این کار صدای متفاوتی ایجاد کند. کاسه\u200Cي کمانچه ترکه\u200Cای است. پشت کاسه\u200Cي کمانچه\u200Cي لرستان باز است.");
                break;
            case 1:
                qeychak_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qeychak_player, null));
                txt_qeychak.setText("قیچک سازی کمانی است و مربوط به سيستان و بلوچستان. جلوی کاسه\u200Cي قیچک شبیه لنگر کشتی است. کمانه\u200Cي قیچک خمیده است و قیچک را هم مثل کمانچه موقع نواختن عمودی می\u200Cگیرند.");
                uri = "http://192.168.10.85:8099/ghezhak.mp3";
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        qeychak_img.startAnimation(animation1);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}

