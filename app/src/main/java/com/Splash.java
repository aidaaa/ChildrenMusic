package com;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.childrenmusic.R;
import com.example.childrenmusic.main.MainActivity;


/**
 * Created by AIDA-PC on 12/19/2017.
 */

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
          new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeintent=new Intent(Splash.this, MainActivity.class);
                startActivity(homeintent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}