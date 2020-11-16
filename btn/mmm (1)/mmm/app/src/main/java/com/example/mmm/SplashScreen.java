package com.example.mmm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Timer().schedule(new TimerTask(){
                                 public void run() {
                                     startActivity(new Intent(SplashScreen.this, NewsActivity.class));
                                 }
                             },
                3000);
    }
}