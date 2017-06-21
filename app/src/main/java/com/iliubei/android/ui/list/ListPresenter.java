package com.iliubei.android.ui.list;

import com.iliubei.android.entity.themeDaily.ArticleListEntity;

import rx.Subscriber;

/**
 * Created by xn058827 on 2017/5/27.
 */

public class ListPresenter extends ListContract.Presenter {

    @Override
    void getLatestArticles(int id) {
        mRxManager.add(mModel.getLatestArticles(id)
                .subscribe(new Subscriber<ArticleListEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(ArticleListEntity latestDailyEntity) {
                        mView.refreshList(latestDailyEntity);
                    }
                }));
    }

    @Override
    void getArticleList(int id, int page) {
        mRxManager.add(mModel.getArticleList(id, page)
                .subscribe(new Subscriber<ArticleListEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ArticleListEntity articleListEntity) {
                        mView.loadedList(articleListEntity);
                    }
                }));
    }
}
