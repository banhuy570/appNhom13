package com.example.docbaocuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class DetailLink extends AppCompatActivity {
    WebView webView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_link);

        webView = findViewById(R.id.webview);

        intent = getIntent();
        String link = intent.getStringExtra("linkURL");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}