package com.example.st3toolbar.st1drawermenu;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.st3toolbar.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // 3초 동안 기다렸다 실행하라.
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                android.content.Intent i = new android.content.Intent( IntroActivity.this, MainActivity.class);
                startActivity(i);
                IntroActivity.this.finish();
            }
        };
        h.postDelayed(  r , 3000);
    }
}