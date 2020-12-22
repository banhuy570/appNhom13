package com.example.docbaocuoiki.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.docbaocuoiki.Login.Login;
import com.example.docbaocuoiki.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iDangNhap = new Intent(MainActivity.this, Login.class);
                startActivity(iDangNhap);
                finish();
            }
        },5000);
    }
}