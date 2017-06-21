package com.iliubei.android.ui.list;

import com.iliubei.android.api.Networks;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by xn058827 on 2017/5/27.
 */

public class ListModel implements ListContract.Model{

    @Override
    public Observable<ArticleListEntity> getLatestArticles(int id) {
        return Networks.getInstance().getCommonApi().getArticleList(id, 1)
                .compose(RxSchedulerHelper.<ArticleListEntity>io_main());
    }

    @Override
    public Observable<ArticleListEntity> getArticleList(int id, int page) {
        return Networks.getInstance().getCommonApi().getArticleList(id, page)
                .compose(RxSchedulerHelper.<ArticleListEntity>io_main());
    }
}
