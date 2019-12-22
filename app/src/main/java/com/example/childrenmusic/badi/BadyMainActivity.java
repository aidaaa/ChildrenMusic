package com.example.childrenmusic.badi;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.childrenmusic.R;
import com.example.childrenmusic.badi.adapter.BadyAdapter;
import com.example.childrenmusic.badi.datamodel.BadyDataModel;
import com.example.childrenmusic.badi.generator.DataGenerator;
import com.example.childrenmusic.badi.player.SurnaActivity;

public class BadyMainActivity extends AppCompatActivity implements BadyAdapter.OnItemClickListener {

    RecyclerView recyclerView;

    NestedScrollView net;
    Toolbar toolbar1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bady_main);

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // appBarLayout=findViewById(R.id.appBarLayout);


        recyclerView=findViewById(R.id.recycler);
        net=findViewById(R.id.netset);
        toolbar1=findViewById(R.id.toolbar1);

        /*if (!recyclerView.hasNestedScrollingParent(ViewCompat.TYPE_NON_TOUCH))
        {
            recyclerView.startNestedScroll(View.SCROLL_AXIS_VERTICAL,ViewCompat.TYPE_NON_TOUCH);
        }*/
        // net=findViewById(R.id.netset);

        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        recyclerView.setHasFixedSize(true);

        BadyAdapter adapter=new BadyAdapter(this, DataGenerator.getAlbumDataModel(this),this);
        adapter.notifyDataSetChanged();

        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(R.drawable.sorna);

        int imageHeight = bd.getBitmap().getHeight();
        int finalImageHeghit=imageHeight+imageHeight;
        int imageWidth = bd.getBitmap().getWidth();


        BitmapDrawable bd1 = (BitmapDrawable) this.getResources().getDrawable(R.drawable.bady_inter_menu);
        int imageHeight1 = bd1.getBitmap().getHeight();
        int imageWidth1 = bd1.getBitmap().getWidth();

       CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar1.getLayoutParams();
       //int a=layoutParams.MATCH_PARENT-finalImageHeghit;
       layoutParams.height =imageHeight1-finalImageHeghit;
       toolbar1.setLayoutParams(layoutParams);

    }

    @Override
    public void onClick(BadyDataModel model)
    {
        Intent intent=new Intent(BadyMainActivity.this, SurnaActivity.class);
       switch (model.getId()) {
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
           case 4:
               intent.putExtra("id",4);
               break;
           case 5:
               intent.putExtra("id",5);
               break;
           case 6:
               intent.putExtra("id",6);
               break;
       }
        BadyMainActivity.this.startActivity(intent);
    }

 /*   public Drawable getDrawable(Context context)
    {
       Drawable drawable= ResourcesCompat.getDrawable(context.getResources(), R.drawable.qarne,null);
       return drawable;
    }*/
}
