package com.iliubei.android.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.StoryContentEntity;
import com.iliubei.android.global.Constants;
import com.iliubei.android.mvpframe.base.BaseFrameActivity;
import com.iliubei.android.util.HtmlUtil;
import com.iliubei.android.util.NetUtils;
import com.iliubei.android.util.SharePreferencesHelper;
import com.iliubei.android.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eaway on 2017/4/4.
 */

public class ArticleDetailActivity extends BaseFrameActivity<DetailPresenter, DetailModel> implements DetailContract.View {

    private static final String TAG = "ArticleDetailActivity";


    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.detail_bar_title)
    TextView detailBarTitle;
    @BindView(R.id.detail_bar_copyright)
    TextView detailBarCopyright;
    @BindView(R.id.wv_detail_content)
    WebView detailContentWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.bind(this);

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        long articleId = intent.getLongExtra("articleId", 0);
        if (articleId != 0) {
            mPresenter.getStoryContent(articleId);
        } else {
            ToastUtils.showToast(this, TAG + "数据加载出错");
        }
    }

    @Override
    public void initView() {
//        setToolbar(mToolbar,"");
        initToolbar();

        initWebViewClient();
    }

    private void initToolbar() {
        mToolbar.inflateMenu(R.menu.menu_article_content);
        Menu menu = mToolbar.getMenu();
//        commentProvider = (ActionProviderView) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_comment));
//        praiseProvider = (ActionProviderView) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_praise));
//        commentProvider.setImage(ContextCompat.getDrawable(this, R.drawable.comment));
//        praiseProvider.setImage(ContextCompat.getDrawable(this, R.drawable.praise));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initWebViewClient() {
        WebSettings settings = detailContentWV.getSettings();
        if (SharePreferencesHelper.getInstance(this).getBoolean(Constants.WebViewSetting.SP_NO_IMAGE, false)) {
            settings.setBlockNetworkImage(true);
        }
        if (SharePreferencesHelper.getInstance(this).getBoolean(Constants.WebViewSetting.SP_AUTO_CACHE, true)) {
            settings.setAppCacheEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            if (NetUtils.isConnected(this)) {
                settings.setCacheMode(WebSettings.LOAD_DEFAULT);
            } else {
                settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
            }
        }
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        detailContentWV.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void initListener() {
        super.initListener();
    }

    @Override
    public void showContent(StoryContentEntity storyContentEntity) {
        if (storyContentEntity != null && storyContentEntity.getArticle() != null) {
            mToolbar.setTitle(storyContentEntity.getArticle().getTitle());
            detailBarTitle.setText(storyContentEntity.getArticle().getTitle());
            detailContentWV.loadData(storyContentEntity.getArticle().getBody(), HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
        }
    }
}

