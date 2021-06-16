package com.qubitech.barta_mobilenewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_splash);
        ImageView splashLogo;
        splashLogo = findViewById(R.id.splash_logo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                Pair[] pairs=new Pair[1];
//                pairs[0]=new Pair<View,String>(splashLogo,splashLogo.getTransitionName());
//                ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this,pairs);
                startActivity(intent);

                finish();
            }
        }, 1500);
    }
}