package com.example.childrenmusic.zehi_zakhmeie;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.childrenmusic.R;
import com.example.childrenmusic.zehi_kamani.adapter.ZehiKamaniAdapter;
import com.example.childrenmusic.zehi_zakhmeie.adapter.ZehiZakhmeieAdapter;
import com.example.childrenmusic.zehi_zakhmeie.datamodel.ZehiZakhmeieDataModel;
import com.example.childrenmusic.zehi_zakhmeie.generator.ZehiZakhmeieDataGenerator;
import com.example.childrenmusic.zehi_zakhmeie.player.BanjoActivity;

public class ZehiZakhmeieMainActivity extends AppCompatActivity implements ZehiZakhmeieAdapter.ZehiZakhmeieOnclick{

    RecyclerView zehi_zakhme_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zehi_zakhmeie_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        zehi_zakhme_recycler=findViewById(R.id.zehi_zakhme_recycler);

        ViewCompat.setNestedScrollingEnabled(zehi_zakhme_recycler, false);
        zehi_zakhme_recycler.setHasFixedSize(true);

        ZehiZakhmeieAdapter adapter=new ZehiZakhmeieAdapter(this, ZehiZakhmeieDataGenerator.getZehiZakhmeieDataModel(this),this);
        adapter.notifyDataSetChanged();

        zehi_zakhme_recycler.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL,false));
        zehi_zakhme_recycler.setAdapter(adapter);
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
