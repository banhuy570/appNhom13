package com.example.docbaocuoiki.fragment_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.docbaocuoiki.R;

public class DangTheoDoi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_theo_doi);
    }
}