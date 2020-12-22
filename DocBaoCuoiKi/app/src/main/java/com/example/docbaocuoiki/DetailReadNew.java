package com.example.docbaocuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class DetailReadNew extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail_read_new);
        webView = (WebView) findViewById(R.id.webView);
        Intent intent = getIntent();
        String linkWebView = intent.getStringExtra("link");
        webView.loadUrl(linkWebView);
        webView.setWebViewClient(new WebViewClient());
    }
}
