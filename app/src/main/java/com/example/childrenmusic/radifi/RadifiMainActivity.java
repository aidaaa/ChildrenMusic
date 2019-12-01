package com.example.childrenmusic.radifi;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.childrenmusic.R;
import com.example.childrenmusic.kobeie.KobeieMainActivity;
import com.example.childrenmusic.kobeie.adapter.KobeieAdapter;
import com.example.childrenmusic.kobeie.generator.KobeieDataGenerator;
import com.example.childrenmusic.kobeie.player.DoholActivity;
import com.example.childrenmusic.radifi.adapter.RadifiAdapter;
import com.example.childrenmusic.radifi.datamodel.RadifiDataModel;
import com.example.childrenmusic.radifi.generator.RadifiDataGenerator;
import com.example.childrenmusic.radifi.player.QanonActivity;

public class RadifiMainActivity extends AppCompatActivity implements RadifiAdapter.RadifiOnclick{

    RecyclerView radifi_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radifi_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        radifi_recycler=findViewById(R.id.radifi_recycler);

        ViewCompat.setNestedScrollingEnabled(radifi_recycler, false);
        radifi_recycler.setHasFixedSize(true);

        RadifiAdapter adapter=new RadifiAdapter(this, RadifiDataGenerator.getRadifiDataModel(this),this);
        adapter.notifyDataSetChanged();

        radifi_recycler.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL,false));
        radifi_recycler.setAdapter(adapter);
    }

    @Override
    public void onClick(RadifiDataModel model) {
        Intent intent=new Intent(RadifiMainActivity.this, QanonActivity.class);
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
            case 4:
                intent.putExtra("id",4);
                break;
        }
        RadifiMainActivity.this.startActivity(intent);
    }
}
