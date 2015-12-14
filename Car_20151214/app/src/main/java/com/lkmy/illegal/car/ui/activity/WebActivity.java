package com.lkmy.illegal.car.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.widget.ProgressWebView;

/**
 * 作者:李凯
 * 创建时间:2015/11/24 00:15
 * 描述:
 */
public class WebActivity extends BaseActivity {
    private ProgressWebView wv;
    private Uri uri;


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_webview);
        wv = (ProgressWebView) findViewById(R.id.activity_webView);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 19) {
            wv.getSettings().setLoadsImagesAutomatically(true);
        } else {
            wv.getSettings().setLoadsImagesAutomatically(false);
        }
        wv.requestFocus();


    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        Intent intent = this.getIntent();        //获取已有的intent对象
        uri = intent.getData();

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wv.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                wv.getSettings().setLoadsImagesAutomatically(true);
            }
        });


        wv.loadUrl(uri.toString());

    }

    @Override
    protected void onBackKeyDown() {
        if (wv.canGoBack())
            wv.goBack();
        else finish();
    }


}
