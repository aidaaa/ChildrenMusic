package com.example.childrenmusic.zehi_kamani;

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
import com.example.childrenmusic.zehi_kamani.datamodel.ZehiKamaniDataModel;
import com.example.childrenmusic.zehi_kamani.generator.ZehiKamaniDataGenerator;
import com.example.childrenmusic.zehi_kamani.player.QeychakActivity;

public class ZehiKamaniMainActivity extends AppCompatActivity implements ZehiKamaniAdapter.ZehiKamaniOnclick{

    RecyclerView recycler_zehi_kamani;
    Toolbar toolbar_ka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zehi_kamani_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        recycler_zehi_kamani=findViewById(R.id.recycler_zehi_kamani);
        toolbar_ka=findViewById(R.id.toolbar_ka);

        ViewCompat.setNestedScrollingEnabled(recycler_zehi_kamani, false);
        recycler_zehi_kamani.setHasFixedSize(true);

        ZehiKamaniAdapter adapter=new ZehiKamaniAdapter(this, ZehiKamaniDataGenerator.getZehiKamaniDataModel(this),this);
        adapter.notifyDataSetChanged();

        recycler_zehi_kamani.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false));
        recycler_zehi_kamani.setAdapter(adapter);

        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(R.drawable.qavaal);
        int imageHeight = bd.getBitmap().getHeight();
        int imageWidth = bd.getBitmap().getWidth();


        BitmapDrawable bd1 = (BitmapDrawable) this.getResources().getDrawable(R.drawable.koobei_inter_menu);
        int imageHeight1 = bd1.getBitmap().getHeight();
        int imageWidth1 = bd1.getBitmap().getWidth();

        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar_ka.getLayoutParams();
        int a=imageHeight-layoutParams.MATCH_PARENT;
        layoutParams.height =imageHeight1;
        toolbar_ka.setLayoutParams(layoutParams);
    }

    @Override
    public void onClick(ZehiKamaniDataModel model)
    {
        Intent intent=new Intent(ZehiKamaniMainActivity.this, QeychakActivity.class);
        switch (model.getId())
        {
            case 0:
                intent.putExtra("id",0);
                break;
            case 1:
                intent.putExtra("id",1);
                break;
        }
        ZehiKamaniMainActivity.this.startActivity(intent);
    }
}
