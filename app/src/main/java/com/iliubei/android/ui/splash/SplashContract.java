package com.iliubei.android.ui.splash;

import com.iliubei.android.entity.commonEntity.SplashImgEntity;
import com.iliubei.android.mvpframe.base.BaseModel;
import com.iliubei.android.mvpframe.base.BasePresenter;
import com.iliubei.android.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/3.
 */

public interface SplashContract {
    interface Model extends BaseModel{
        Observable<SplashImgEntity> getSplahImg();
    }

    interface View extends BaseView{
        void loadSplashImage(SplashImgEntity splashImgEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getSplashImage();
    }
}
