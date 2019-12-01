package com.example.childrenmusic.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.WindowManager;

import com.example.childrenmusic.R;
import com.example.childrenmusic.main.adapter.MainAdapter;
import com.example.childrenmusic.main.generator.MainDataGenarator;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView=findViewById(R.id.main_recycler);
        MainAdapter adapter=new MainAdapter(this, MainDataGenarator.getMainDataModel(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(adapter);
    }
}
