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
        if (SharePreferencesHelper.getInstance(this).getBoolean(Constants.WebViewSetting.SP_NO_IMAGE,false)) {
            settings.setBlockNetworkImage(true);
        }
        if (SharePreferencesHelper.getInstance(this).getBoolean(Constants.WebViewSetting.SP_AUTO_CACHE,true)) {
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
        detailBarTitle.setText(storyContentEntity.getArticle().getTitle());
//        String htmlData = HtmlUtil.createHtmlData(storyContentEntity.getArticle().getBody(), storyContentEntity.getArticle()..getCss(), storyContentEntity.getJs());
        detailContentWV.loadData(storyContentEntity.getArticle().getBody(), HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
//        detailContentWV.loadDataWithBaseURL(null, "<div style=\"text-align: center;\">\n" +
//                "\t<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0\" height=\"390\" width=\"450\"><param name=\"quality\" value=\"high\" /><param name=\"movie\" value=\"http://player.youku.com/player.php/sid/XNjE0MDM4ODY4/v.swf\" /><embed height=\"390\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" quality=\"high\" src=\"http://player.youku.com/player.php/sid/XNjE0MDM4ODY4/v.swf\" type=\"application/x-shockwave-flash\" width=\"450\"></embed></object></div>\n" +
//                "<div>\n" +
//                "\t<span style=\"color: rgb(51, 51, 51); font-family: Helvetica, Arial, sans-serif; font-size: 14px; letter-spacing: 0.5px; line-height: 28px;\">史蒂夫&middot;乔布斯逝世两周年之际，有一部根据他生平事迹改编的电影《乔布斯》即将上映。同时，为了纪念这位&ldquo;苹果教父&rdquo;，短片采访了众多互联网的知名人士，大家纷纷表达自己对乔布斯的敬意和缅怀之情。</span><br />\n" +
//                "\t<span style=\"color: rgb(51, 51, 51); font-family: Helvetica, Arial, sans-serif; font-size: 14px; line-height: 28px;\">这部影片由</span>崔炎龙<span style=\"color: rgb(51, 51, 51); font-family: Helvetica, Arial, sans-serif; font-size: 14px; line-height: 28px;\">导演，V电影参与制作，采访了包括时尚传媒集团CEO刘江、天使投资人蔡文胜、新东方创始人王强、徐小平、搜狐CEO张朝阳、优酷土豆集团董事长古永锵、V电影 CEO尹兴良、九合创投创始人王啸、36氪CEO刘成城、唱吧创始人陈华、阿米巴基金创始人合伙人王东晖、李治国、赵鸿、赛富亚洲投资基金首席合伙人阎炎、高德软件CEO成从武、IDG全球常务副总裁兼亚洲区总裁熊晓鸽等在内的互联网知名人士。</span>\n" +
//                "\t<p style=\"margin: 0px 0px 20px; letter-spacing: 0.5px; color: rgb(51, 51, 51); font-family: Helvetica, Arial, sans-serif; font-size: 14px; line-height: 28px;\">\n" +
//                "\t\t短片中将电影《乔布斯》的片段和企业家的访谈进行穿插，大家几乎一致认为乔布斯是改变世界、创造奇迹的怪才，他完成了他&ldquo;改变世界&rdquo;的梦想，也留给了人类最宝贵的精神财富。</p>\n" +
//                "</div>\n" +
//                "<br />\n", HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING, null);
    }
}

