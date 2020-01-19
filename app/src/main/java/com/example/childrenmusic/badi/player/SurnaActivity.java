package com.example.childrenmusic.badi.player;

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

public class SurnaActivity extends AppCompatActivity {
    private SimpleExoPlayer player;
    private PlayerControlView player_view_surna;
    ImageView surna_img;
    String uri ;
    TextView txt_surna,txt_controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surna);

        player_view_surna=findViewById(R.id.player_view_surna);
        surna_img=findViewById(R.id.surna_img);
        txt_surna=findViewById(R.id.txt_surna);
        txt_controller=findViewById(R.id.txt);
        txt_surna.setMovementMethod(new ScrollingMovementMethod());

        Typeface typface=Typeface.createFromAsset(getAssets(),"fonts/iransans.ttf");
        txt_surna.setTypeface(typface);
        txt_controller.setTypeface(typface);

        Intent intent=getIntent();
        int id = intent.getIntExtra("id",0);

        switch (id)
        {
            case 0:
               surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qerne_player,null));
               uri="http://79.175.176.185:7589/ghare_ney.mp3";
               txt_controller.setText("موسیقی قرنه");
               txt_surna.setText("قِرْنهِ ساز گیلان که گاهی به جای سورنا استفاده می\u200Cشود، مثل سورنا، لوله\u200Cای\u200Cشکل و انتهایش بازشده (مخروطی) است. قِرْنه دوتکّه است. لوله\u200Cي آن از نی و قسمت مخروطی آن از شاخ گاو ساخته شده است. چهار سوراخ در جلوی آن و یک سوراخ در پشت آن وجود دارد.");
                break;
            case 1:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.surna_player,null));
                txt_controller.setText("موسیقی سورنا");
                uri="http://79.175.176.185:7589/sorna.mp3";
                txt_surna.setText("سازی که در آذربایجان، بندرعباس، خراسان، کردستان، لرستان، قشقایی و بختیاری استفاده می\u200Cشود.\n" +
                        "لوله\u200Cای استوانه\u200Cای و از جنس چوب دارد که انتهای آن کمی باز شده است (به شکل مخروط است). گاهی در انتهای آن فلز یا کنده\u200Cکاریِ چوب (منبّت) برای تزئین اضافه می\u200Cکنند.\n" +
                        "هفت یا هشت سوراخ در جلو و یک سوراخ هم در پشت برای انگشت شست دارد.\n" +
                        "نوازنده موقع نواختن در آن می\u200Cدمد و انگشتانش را روی سوراخ\u200Cهای مختلف قرار می\u200Cدهد.\n" +
                        "دوست صمیمی سورنا «دُهُل» است. حتماً به صفحه\u200Cي دوستِ سرنا هم سَری بزنید.");
                break;
            case 2:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.ney_jofti_player,null));
                uri="http://79.175.176.185:7589/ney7band.mp3";
                txt_controller.setText("موسیقی نی\u200Cجفتی");

                txt_surna.setText("«نی جفتی» بوشهر، «قوشمَه\u200C (قوچمَه\u200C)»ي خراسان، «دونَلیِ» سیستان و بلوچستان، «دوزَلِه»\u200Cي کردستان و «لَلـِه\u200Cوا»ی گیلان و مازندران با این\u200Cکه با هم تفاوت\u200Cهایی دارند، اما همه دو لوله\u200Cي استوانه\u200Cای (نی) دارند و این دو نی، دو رفیق جدانشدنی و همیشه در کنار یکدیگرند.\n" +
                        "معمولاً دو لوله توسط موم و به همراه تسمه\u200Cهایی (بندهای چرمی) که دور آن\u200Cها بسته می\u200Cشود در کنار یکدیگر نگه داشته می\u200Cشوند. گاهی درون موم دانه\u200Cهای ریز صدفی و رنگین برای تزئین قرار می\u200Cدهند.\n" +
                        "نی جفتی شش سوراخ دارد. نوازنده موقع نواختن از بینی نفس می\u200Cکشد و با دهان می\u200Cدمد. بنابراین صداي ساز قطع نمی\u200Cشود.\n" +
                        " دو لوله\u200Cي قوشمه با هفت بست به هم وصل شده\u200Cاند و یک تفاوت مهم با بقیه\u200Cي سازهای این صفحه دارد؛ این\u200Cکه جنس آن از استخوان پرنده\u200Cي قوش (و یا فلز) است.\n" +
                        " نام لَلـِه\u200Cوا از دو بخش «لَلـِه» به معنی لوله یا چوبِ استوانه\u200Cایِ توخالی و «وا» به معنی باد تشکیل شده است.\n");
                break;
            case 3:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.ney_player,null));
                txt_controller.setText("موسیقی نی");
                uri="http://79.175.176.185:7589/ney.mp3";
                txt_surna.setText("قِرْنهِ ساز گیلان که گاهی به جای سورنا استفاده می\u200Cشود، مثل سورنا، لوله\u200Cای\u200Cشکل و انتهایش بازشده (مخروطی) است. قِرْنه دوتکّه است. لوله\u200Cي آن از نی و قسمت مخروطی آن از شاخ گاو ساخته شده است. چهار سوراخ در جلوی آن و یک سوراخ در پشت آن وجود دارد.");
                break;
            case 4:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.boq_player,null));
                uri="http://79.175.176.185:7589/boogh.mp3";
                txt_controller.setText("موسیقی بوق");
                txt_surna.setText("بوق بوشهر، از جنس شاخ و شکل آن هم مثل شکل شاخ است. موقع نواختن، به خواننده آن\u200Cقدر فشار می\u200Cآید که ممکن است رگ\u200Cهای گردنش هم باد کند.");
                break;
            case 5:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.ney_anbone,null));
                uri="http://79.175.176.185:7589/neyanbune.mp3";
                txt_controller.setText("موسیقی نی\u200Cانبونه");
                txt_surna.setText("در این سازِ بوشهری، این دو نیِ جدانشدنی همیشه یک مَشک به دوش دارند. نوازنده درون مشک می\u200Cدمد. با فشارِ دست هوای مشک را به لوله\u200Cها هدایت می\u200Cکند و انگشتانش را روی سوراخ\u200Cهای لوله\u200Cها قرار می\u200Cدهد. هواي جمع\u200Cشده در مَشك، به نوازنده كمك مي\u200Cكند تا ساز را بدونِ قطع شدنِ صدايش بنوازد. هر\u200Cيك از نی\u200Cها شش سوراخ دارند. معمولاً به سَرِ مَشک یک منگوله آویزان است.");
                break;
            case 6:
                surna_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.korna_player,null));
                uri="http://79.175.176.185:7589/karna.mp3";
                txt_controller.setText("موسیقی کرنا");
                txt_surna.setText("کَرنای قشقایی و بختیاری و مسجد\u200Cسلیمان از دو قسمت «لوله\u200Cي صوتی» و «انتهای شیپوری برنجی» تشکیل شده است. جلوی آن هفت سوراخ و پشت آن هم یک سوراخ برای انگشت شست دارد.\n" +
                        "اگرچه شکل ظاهری کرنا و سورنا شبیه هم به نظر می\u200Cرسد، کرنا بسیار قدبلندتر از سورنا است و اگر کنار هم بایستند سرنا تقریباً نصف کرنا است.\n");
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        surna_img.startAnimation(animation1);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animation2 =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.animation);
                surna_img.setAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        surna_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surna_img.startAnimation(animation1);
            }
        });

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
                AlertDialog.Builder builder = new AlertDialog.Builder(SurnaActivity.this);
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
