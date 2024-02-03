package com.example.abhinavnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fullnew extends AppCompatActivity {

    WebView webv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullnew);

        String url= getIntent().getStringExtra("url");
        webv=findViewById(R.id.webView);
        WebSettings webSettings=webv.getSettings();
        webv.setWebViewClient(new WebViewClient());
        webv.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(webv.canGoBack())
            webv.goBack();
        else
            super.onBackPressed();
    }
}