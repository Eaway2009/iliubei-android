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
        Observable<ArticleListEntity> getLatestDaily(int id);

        Observable<BeforeDailyEntity> getBeforeDaily(String date);

        Observable<ArticleListEntity> getThemeContentList(int id, int page);
    }

    interface View extends BaseView {
        <T> void refreshHomeList(T t);

        void loadBeforeDaily(BeforeDailyEntity beforeDailyEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getLatestDaily(int id);

        abstract void getBeforeDaily(String date);

        abstract void getOtherThemeList(int id, int page);
    }
}
