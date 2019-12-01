package com.example.childrenmusic.badi;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.WindowManager;

import com.example.childrenmusic.R;
import com.example.childrenmusic.badi.adapter.BadyAdapter;
import com.example.childrenmusic.badi.datamodel.BadyDataModel;
import com.example.childrenmusic.badi.generator.DataGenerator;
import com.example.childrenmusic.badi.player.SurnaActivity;

public class BadyMainActivity extends AppCompatActivity implements BadyAdapter.OnItemClickListener {

    RecyclerView recyclerView;

    NestedScrollView net;

    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bady_main);

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // appBarLayout=findViewById(R.id.appBarLayout);


        recyclerView=findViewById(R.id.recycler);

        /*if (!recyclerView.hasNestedScrollingParent(ViewCompat.TYPE_NON_TOUCH))
        {
            recyclerView.startNestedScroll(View.SCROLL_AXIS_VERTICAL,ViewCompat.TYPE_NON_TOUCH);
        }*/
        // net=findViewById(R.id.netset);

        ViewCompat.setNestedScrollingEnabled(recyclerView, false);

        BadyAdapter adapter=new BadyAdapter(this, DataGenerator.getAlbumDataModel(this),this);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(adapter);
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
}
