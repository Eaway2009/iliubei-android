package com.iliubei.android.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.iliubei.android.R;
import com.iliubei.android.common.BaseActivity;
import com.iliubei.android.mvpframe.base.BaseFrameActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xn058827 on 2017/7/6.
 */

public class DownloadActivity extends BaseActivity {
    @BindView(R.id.baidu_pwd_tv)
    TextView mBaiduPwdTv;
    @BindView(R.id.baidu_url_btn)
    Button mBaiduUrlBtn;
    @BindView(R.id.cili_url_btn)
    Button mCiliUrlBtn;
    @BindView(R.id.torrent_btn)
    Button mTorrentBtn;
    @BindView(R.id.toolBar)
    Toolbar mtoolBar;

    private String baidu_url;
    private String cili_url;
    private String torrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_downloadurl);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        mtoolBar.setTitle(getResources().getString(R.string.download_title));
        Bundle bundle = getIntent().getExtras();
        String baiduPwd = bundle.getString("baidu_pwd");
        if (!TextUtils.isEmpty(baiduPwd)) {
            mBaiduPwdTv.setText(getResources().getString(R.string.baidu_pwd) + baiduPwd);
            mBaiduPwdTv.setVisibility(View.VISIBLE);
        } else {
            mBaiduPwdTv.setVisibility(View.GONE);
        }
        baidu_url = bundle.getString("baidu_url");
        if (!TextUtils.isEmpty(baidu_url)) {
            mBaiduPwdTv.setVisibility(View.VISIBLE);
        } else {
            mBaiduPwdTv.setVisibility(View.GONE);
        }
        cili_url = bundle.getString("cili_url");
        if (!TextUtils.isEmpty(cili_url)) {
            mCiliUrlBtn.setVisibility(View.VISIBLE);
        } else {
            mCiliUrlBtn.setVisibility(View.GONE);
        }
        torrent = bundle.getString("torrent");
        if (!TextUtils.isEmpty(torrent)) {
            mTorrentBtn.setVisibility(View.VISIBLE);
        } else {
            mTorrentBtn.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.baidu_url_btn)
    protected void onBaiduClick(){
        startUrl(baidu_url);
    }

    @OnClick(R.id.cili_url_btn)
    protected void onCiliClick(){
        startUrl(cili_url);
    }

    @OnClick(R.id.torrent_btn)
    protected void onTorrentClick(){
        startUrl(torrent);
    }

    private void startUrl(String url){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        startActivity(intent);
    }
}
