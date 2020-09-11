package com.mementos.moments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mementos.moments.Utils.PrefManager;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prefManager = new PrefManager(this);

        // Showing splash screen with a timer
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Checking for first time launch - before calling setContentView()
                if (!prefManager.isFirstTimeLaunch()) {
                    launchHomeScreen();
                    finish();
                }
                else {
                    startActivity(new Intent(SplashActivity.this, OnBoardingActivity.class));
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
