package com.example.childrenmusic.zehi_kamani;

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
import com.example.childrenmusic.zehi_kamani.datamodel.ZehiKamaniDataModel;
import com.example.childrenmusic.zehi_kamani.generator.ZehiKamaniDataGenerator;
import com.example.childrenmusic.zehi_kamani.player.QeychakActivity;

public class ZehiKamaniMainActivity extends AppCompatActivity implements ZehiKamaniAdapter.ZehiKamaniOnclick{

    RecyclerView recycler_zehi_kamani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zehi_kamani_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        recycler_zehi_kamani=findViewById(R.id.recycler_zehi_kamani);

        ViewCompat.setNestedScrollingEnabled(recycler_zehi_kamani, false);
        recycler_zehi_kamani.setHasFixedSize(true);

        ZehiKamaniAdapter adapter=new ZehiKamaniAdapter(this, ZehiKamaniDataGenerator.getZehiKamaniDataModel(this),this);
        adapter.notifyDataSetChanged();

        recycler_zehi_kamani.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false));
        recycler_zehi_kamani.setAdapter(adapter);
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
