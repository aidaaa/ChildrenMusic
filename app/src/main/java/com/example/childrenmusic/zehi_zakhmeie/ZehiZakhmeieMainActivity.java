package com.example.childrenmusic.zehi_zakhmeie;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.example.childrenmusic.R;
import com.example.childrenmusic.zehi_kamani.adapter.ZehiKamaniAdapter;
import com.example.childrenmusic.zehi_zakhmeie.adapter.ZehiZakhmeieAdapter;
import com.example.childrenmusic.zehi_zakhmeie.datamodel.ZehiZakhmeieDataModel;
import com.example.childrenmusic.zehi_zakhmeie.generator.ZehiZakhmeieDataGenerator;
import com.example.childrenmusic.zehi_zakhmeie.player.BanjoActivity;

public class ZehiZakhmeieMainActivity extends AppCompatActivity implements ZehiZakhmeieAdapter.ZehiZakhmeieOnclick{

    RecyclerView zehi_zakhme_recycler;
    Toolbar toolbar_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zehi_zakhmeie_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        zehi_zakhme_recycler=findViewById(R.id.zehi_zakhme_recycler);
        toolbar_z=findViewById(R.id.toolbar_z);

        ViewCompat.setNestedScrollingEnabled(zehi_zakhme_recycler, false);
        zehi_zakhme_recycler.setHasFixedSize(true);

        ZehiZakhmeieAdapter adapter=new ZehiZakhmeieAdapter(this, ZehiZakhmeieDataGenerator.getZehiZakhmeieDataModel(this),this);
        adapter.notifyDataSetChanged();

        zehi_zakhme_recycler.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL,false));
        zehi_zakhme_recycler.setAdapter(adapter);

        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(R.drawable.qavaal);
        int imageHeight = bd.getBitmap().getHeight();
        int imageWidth = bd.getBitmap().getWidth();


        BitmapDrawable bd1 = (BitmapDrawable) this.getResources().getDrawable(R.drawable.koobei_inter_menu);
        int imageHeight1 = bd1.getBitmap().getHeight();
        int imageWidth1 = bd1.getBitmap().getWidth();

        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar_z.getLayoutParams();
        int a=imageHeight-layoutParams.MATCH_PARENT;
        layoutParams.height =imageHeight1;
        toolbar_z.setLayoutParams(layoutParams);
    }

    @Override
    public void onClick(ZehiZakhmeieDataModel model)
    {
        Intent intent=new Intent(ZehiZakhmeieMainActivity.this, BanjoActivity.class);
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
        ZehiZakhmeieMainActivity.this.startActivity(intent);
    }
}
