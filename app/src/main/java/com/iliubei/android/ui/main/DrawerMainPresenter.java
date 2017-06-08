package com.iliubei.android.ui.main;

import com.iliubei.android.entity.themeDaily.ThemesEntity;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/31.
 */

public class DrawerMainPresenter extends DrawerMainContract.Presenter{



    @Override
    void getOtherThemes() {
        mRxManager.add(mModel
                .getCategorys()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ThemesEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(ThemesEntity themesEntity) {
                        mView.loadOtherThemeList(themesEntity);
                    }
                }));
    }
}
