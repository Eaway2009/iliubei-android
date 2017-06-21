package com.iliubei.android.ui.list;

import com.iliubei.android.entity.commonEntity.BeforeDailyEntity;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.mvpframe.base.BaseModel;
import com.iliubei.android.mvpframe.base.BasePresenter;
import com.iliubei.android.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by xn058827 on 2017/5/27.
 */

public interface ListContract {

    interface Model extends BaseModel {
        Observable<ArticleListEntity> getLatestArticles(int id);

        Observable<ArticleListEntity> getArticleList(int id, int page);
    }

    interface View extends BaseView {
        <T> void refreshList(T t);
        <T> void loadedList(T t);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getLatestArticles(int id);

        abstract void getArticleList(int id, int page);
    }
}
