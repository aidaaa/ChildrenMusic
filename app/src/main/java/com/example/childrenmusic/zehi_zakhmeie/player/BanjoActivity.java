package com.example.childrenmusic.zehi_zakhmeie.player;

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
        txt_banjo.setMovementMethod(new ScrollingMovementMethod());

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id) {
            case 0:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.oud_player, null));
                uri = "http://192.168.10.85:8099/oud.mp3";
                txt_banjo.setText("«عودِ» بندرعباس_ و يا بطور کلّي در جنوب ايران_ سازی است که یک کاسه\u200Cي صوتی بسیار بزرگ و یک دسته\u200Cي بسیار کوتاه دارد. کاسه\u200Cي صوتی عود شبیه گلابی\u200Cای است که از وسط نصف شده است.\n" +
                        "کنجکاوی: در مورد این موضوع تحقیق کنید: سفرِ سازِ عود و جدّ و نوادگانش. \n" +
                        "اشاره: ساز عود همان «بربتِ»  ایرانی است که بعدها به «عود» تبدیل شد. \n");
                break;
            case 1:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.robab_player, null));
                txt_banjo.setText("کاسه\u200Cي صوتی «رُبابِ» سیستان و بَلوچستان دو بخش بالایی و پایینی دارد. روی قسمت پایینی پوست کشیده می\u200Cشود؛ یعنی سطح رویی کاسه از چوب نیست بلکه از پوست حیوان است. دسته\u200Cي ساز رباب نسبتاً کوتاه است و گوشی\u200Cهاي زیادی براي کوک دارد.");
                uri = "http://192.168.10.85:8099/robab.mp3";
                break;
            case 2:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.banjo_player, null));
                txt_banjo.setText("قسمت سمتِ چپِ بنجوی سیستان و بلوچستان یعنی کاسه\u200Cي صوتی آن مستطیل\u200Cشکل است و یک سوراخ در وسط دارد. در سازهایی که در صفحات قبل معرِّفی شد نوازنده برای کوتاه کردن طول قسمتی از سیم که می\u200Cلرزد انگشتش را روی سیم و بر «پرده»\u200Cي روی دسته قرار می\u200Cداد. ولی این ساز کمی متفاوت است و روی قسمت بالایی آن پر از دکمه (شستي، کلاویه) است و نوازنده با دست راستش و با تکّه\u200Cای چوب یا کائوچو به سیم\u200Cها زخمه می\u200Cزند و با دست چپش هم دکمه\u200Cها را فشار می\u200Cدهد.");
                uri = "http://192.168.10.85:8099/banjo.mp3";
                break;
            case 3:
                banjo_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.zanborak_player, null));
                txt_banjo.setText("آیا شده تکّه\u200Cای برگ یا علف میان انگشتان دو دستتان قرار بدهید و طوری به آن فوت کنید که لرزش برگ صدای سوت ایجاد کند. زنبورک هم بر اساس چنین ایده\u200Cای کار می\u200Cکند. نوازنده قسمتی از زنبورک را در دهان مي\u200Cگذارد و می\u200Cدمد و به میله\u200Cي نازک آن زخمه می\u200Cزند. \n" +
                        "برخی زنبورک را جزء هیچ\u200Cيك از دسته\u200Cهاي سازهای بادی، زهی و کوبه\u200Cای نمی\u200Cدانند. شاید ما بتوانیم برای این ساز یک دسته\u200Cي جدید «بادی-زخمه\u200Cای» ایجاد کنیم و زنبورک را سازی بادی-زخمه\u200Cای به حساب آوریم!\n" +
                        "زنبورکِ ترکمن «قاویز» نام دارد و در بلوچستان به زنبورک «چَنگِ دَهَن» گفته می\u200Cشود.\n");
                uri = "http://192.168.10.85:8099/zanburak.mp3";
                break;
        }


        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        banjo_img.startAnimation(animation1);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animation2 =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.animation);
                banjo_img.setAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        banjo_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banjo_img.startAnimation(animation1);
            }
        });

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

