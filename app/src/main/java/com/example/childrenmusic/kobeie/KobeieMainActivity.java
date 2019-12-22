package com.example.childrenmusic.kobeie;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.childrenmusic.R;
import com.example.childrenmusic.badi.BadyMainActivity;
import com.example.childrenmusic.badi.player.SurnaActivity;
import com.example.childrenmusic.kobeie.adapter.KobeieAdapter;
import com.example.childrenmusic.kobeie.datamodel.KobeieDataModel;
import com.example.childrenmusic.kobeie.generator.KobeieDataGenerator;
import com.example.childrenmusic.kobeie.player.DoholActivity;

public class KobeieMainActivity extends AppCompatActivity implements KobeieAdapter.KobeieOnClick {

    private RecyclerView recyclerView;
    Toolbar toolbar_k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kobeie_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        recyclerView=findViewById(R.id.recycler_kobeie);
        toolbar_k=findViewById(R.id.toolbar_k);

        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        recyclerView.setHasFixedSize(true);

        KobeieAdapter adapter=new KobeieAdapter(this, KobeieDataGenerator.getKobeieDataModel(this),this);
        adapter.notifyDataSetChanged();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(R.drawable.qavaal);
        int imageHeight = bd.getBitmap().getHeight();
        int finalImageHeghit=imageHeight;
        int imageWidth = bd.getBitmap().getWidth();


        BitmapDrawable bd1 = (BitmapDrawable) this.getResources().getDrawable(R.drawable.koobei_inter_menu);
        int imageHeight1 = bd1.getBitmap().getHeight();
        int imageWidth1 = bd1.getBitmap().getWidth();

        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar_k.getLayoutParams();
        int a=imageHeight-layoutParams.MATCH_PARENT;
        layoutParams.height =imageHeight1-finalImageHeghit;
        //layoutParams.height =imageHeight1;
        toolbar_k.setLayoutParams(layoutParams);
    }

    @Override
    public void onClick(KobeieDataModel model)
    {
        Intent intent=new Intent(KobeieMainActivity.this, DoholActivity.class);
        switch (model.getId())
        {
            case 0:
                intent.putExtra("id",0);
                break;
            case 1:
                intent.putExtra("id",1);
                break;
            case 2:
                intent.putExtra("id",2);
                break;
            case 3:
                intent.putExtra("id",3);
                break;
        }
        KobeieMainActivity.this.startActivity(intent);
    }
}
