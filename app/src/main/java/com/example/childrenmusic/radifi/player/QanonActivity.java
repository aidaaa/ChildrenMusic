package com.example.childrenmusic.radifi.player;

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

public class QanonActivity extends AppCompatActivity {


    private SimpleExoPlayer player;
    private PlayerControlView player_view_qanon;
    ImageView qanon_img;
    String uri;
    TextView txt_qanon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qanon);

        player_view_qanon=findViewById(R.id.player_view_qanon);
        qanon_img=findViewById(R.id.qanon_img);

        txt_qanon=findViewById(R.id.txt_qanon);
        Typeface typface=Typeface.createFromAsset(getAssets(),"fonts/iransans.ttf");
        txt_qanon.setTypeface(typface);
        txt_qanon.setMovementMethod(new ScrollingMovementMethod());

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);

        switch (id)
        {
            case 0:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.setar_player, null));
                txt_qanon.setText("«سه\u200Cتار» هم جزء آن سازهایی است که یک دسته و یک کاسه به شکل نصف\u200Cگلابی دارد. سه\u200Cتار را بیشتر با ناخنِ انگشتِ اشاره می\u200Cنوازند.\n" +
                        "اگر به سه\u200Cتار نگاهی بیندازید می\u200Cبینید که چهار سیم دارد و نه سه تا! امّا خوب حق دارد اسمش سه\u200Cتار باشد، چون در گذشته سه تار (سیم يا رشته) داشته و گفته می\u200Cشود بعدها فردی به نام مشتاق علیشاه یک سیم دیگر را برای زیباتر شدنِ صدا به آن اضافه کرد.\n" +
                        "در قدیم سه\u200Cتاری هم وجود داشت که کاسه\u200Cي آن شبیه جعبه بود تا کوچک\u200Cتر باشد و به\u200Cراحتی و بدون جلب توجّه بتوان آن را جابه\u200Cجا کرد؛ اسم این سه\u200Cتار «سه\u200Cتار کتابی» بود و در آستين گشاد لباس\u200Cهاي آن زمان جا مي\u200Cگرفت. هنوز هم عدّه\u200Cاي به اين شکل از سه\u200Cتار علاقه دارند.\n");
                uri = "http://79.175.176.185:7589/setar.mp3";
                break;
            case 1:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.tar_player, null));
                txt_qanon.setText("«تار» نیز مانند سه\u200Cتار کاسه\u200Cي صوتی و دسته دارد. اما کاسه\u200Cي تار دوطبقه است؛ یعنی از روبه\u200Cرو تقریباً شبیه 8 است.\n" +
                        "در قدیم اغلب موقعِ نواختن، تار را روی سینه قرار می\u200Cدادند (آن را بالا نگه می\u200Cداشتند) اما اکنون دیگر آن را روی پا قرار می\u200Cدهند.\n" +
                        "برای نواختن تار یک تکّه فلز را که انتهای آن بين کمی موم فرو شده است بین انگشتانِ شست و اشاره می\u200Cگیرند و با آن به سیم\u200Cهای تار زخمه می\u200Cزنند. تار هم در قديم پنج سيم داشت و حدود صد سالي است که شش سيم دارد. مردم بعضي مناطق ايران به آن ، ششتار نيز مي\u200Cگويند.\n");
                uri = "http://79.175.176.185:7589/tar.mp3";
                break;
            case 2:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.tombak_player, null));
                txt_qanon.setText("«تنبک» از چوب ساخته مي\u200Cشود و شبیه گلدانی پایه\u200Cدار است. روی بعضی از تنبک\u200Cها خاتم\u200Cکاری شده است. در قسمتِ سمتِ چپِ تنبک ـ با توجّه به جهت قرار گرفتن تنبک در شکلِ بالاـ پوستِ حیوان نصب می\u200Cشود. نوازنده پای راستش را روی یک زیرپایی می\u200Cگذارد تا پایش کمی بالاتر قرار بگیرد. پای چپش را هم کمی جلوتر می\u200Cگذارد. بعد تنبک را افقی روی پایش قرار می\u200Cدهد باکوبيدن انگشتان و قسمت\u200Cهای دیگرِ دستش به اطراف و وسطِ پوست، تنبک\u200Cنوازی می\u200Cکند. \n" +
                        "اسم تنبک یاد\u200Cآور صدای ساز است: «تن» یا «تم» برای ضربه به وسط پوست و «بک» برای ضربه به اطراف آن.\n");
                uri = "http://79.175.176.185:7589/tombak.mp3";
                break;
            case 3:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.qanon_player, null));
                txt_qanon.setText("«قانون» به شکل ذوزنقه\u200Cای قائم\u200Cالزّاویه و جنس آن از چوب است. البتّه در قسمتی از روی آن پوست حیوان کشیده شده است.\n" +
                        "روی سطح آن هفتاد و دو سیم از چپ به راست کشیده شده است.\n" +
                        "قانون دو مضراب کوچک دارد که نوازنده آن را بین انگشتان شست و حلقه\u200Cای که در انگشت اشاره کرده است نگه می\u200Cدارد. موقع نواختن قانون، نوازنده طرف درازتر ساز می\u200Cایستد و یا می\u200Cنشیند و ساز را روی زانوها، زمین یا میز قرار می\u200Cدهد.\n");
                uri = "http://79.175.176.185:7589/ghanun.mp3";
                break;
            case 4:
                qanon_img.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.santor_player, null));
                txt_qanon.setText("«سنتور» به شکل ذوزنقه\u200Cای متساوی\u200Cالسّاقین است و جنسش از چوب است. روی سطح آن تعداد هفتاد و دو سیم از چپ به راست کشیده شده است. بعضي سنتورها، تعداد سيم\u200Cهايشان کمي بيشتر است. \n" +
                        "برای نواختنِ سنتور با دو مضرابِ شبیه میله\u200Cي چوبی به سیم\u200Cها ضربه می\u200Cزنند. مضراب\u200Cهای سنتور کمی مایل است و یک سر آن\u200Cها طرح دایره\u200Cشکلی دارد که بتوان انگشتان را درون آن\u200Cها قرار داد و مضراب را به\u200Cراحتی گرفت. موقع نواختن سنتور نوازنده طرف درازترِ ساز می\u200Cایستد و یا می\u200Cنشیند و ساز را روی زانوها، زمین یا میز قرار می\u200Cدهد.\n");
                uri = "http://79.175.176.185:7589/santur.mp3";
                break;
        }

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.myanimation);
        qanon_img.startAnimation(animation1);


        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animation2 =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.animation);
                qanon_img.setAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        qanon_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qanon_img.startAnimation(animation1);
            }
        });


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

