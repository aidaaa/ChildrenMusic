package com.example.childrenmusic.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
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
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());

        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

       /* mp=MediaPlayer.create(this,R.raw.back);
        mp.setLooping(true);
        mp.start();*/

        recyclerView=findViewById(R.id.main_recycler);
        MainAdapter adapter=new MainAdapter(this, MainDataGenarator.getMainDataModel(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(adapter);

        boolean isConnected=isNetworkConnected();
        if (!isConnected)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("اتصال به اینترنت");
            builder.setIcon(R.drawable.wifi);
            builder.setMessage("برای پخش موسیقی نیاز به اتصال به اینترنت داریم");

         /*   builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });*/

            builder.setNegativeButton("باشه", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    public boolean isNetworkConnected()
    {
        ConnectivityManager cm= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
    }

    @Override
    protected void onStart() {
        super.onStart();
            mp=MediaPlayer.create(this,R.raw.back);
            mp.setLooping(true);
            mp.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
      /*  if (mp!=null)
            mp.start();
        else
        {
            mp=MediaPlayer.create(this,R.raw.back);
            mp.setLooping(true);
            mp.start();
        }*/
    }
}
