package com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.Splash;
import com.example.childrenmusic.R;
import com.example.childrenmusic.main.MainActivity;

public class BigineerActivity extends AppCompatActivity {

    Button btn_biginer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigineer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btn_biginer=findViewById(R.id.btn_biginer);
        btn_biginer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeintent=new Intent(BigineerActivity.this, MainActivity.class);
                startActivity(homeintent);
                finish();
            }
        });
    }
}
