package com.iliubei.android.ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.iliubei.android.R;
import com.iliubei.android.common.BaseActivity;

public class WebActivity extends AppCompatActivity {
    WebView myWebView = null;
    private String mUrl;

    public static void startMe(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.web_activity);

        TextView mTitleTv = (TextView) findViewById(R.id.download_title);
        mTitleTv.setText(getResources().getString(R.string.download_title));
        myWebView = (WebView) findViewById(R.id.wv_detail_content);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        if (getIntent().getExtras() != null) {
            mUrl = getIntent().getExtras().getString("url");
        }
        if (!TextUtils.isEmpty(mUrl)) {
            myWebView.loadUrl(mUrl);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (TextUtils.isEmpty(mUrl)) {
            myWebView.loadUrl(mUrl);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}