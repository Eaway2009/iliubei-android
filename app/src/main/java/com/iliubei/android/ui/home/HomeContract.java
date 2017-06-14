package com.iliubei.android.ui.home;

import com.iliubei.android.entity.commonEntity.BeforeDailyEntity;
import com.iliubei.android.entity.commonEntity.LatestDailyEntity;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.entity.themeDaily.ThemeContentListEntity;
import com.iliubei.android.mvpframe.base.BaseModel;
import com.iliubei.android.mvpframe.base.BasePresenter;
import com.iliubei.android.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/4.
 */

public interface HomeContract {

    interface Model extends BaseModel {
        Observable<LatestDailyEntity> getIndexPage();
    }

    interface View extends BaseView {
        <T> void refreshHomeList(T t);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getIndexPage();
    }
}
