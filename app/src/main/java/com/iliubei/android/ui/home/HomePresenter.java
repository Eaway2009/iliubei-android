package com.iliubei.android.ui.home;

import com.iliubei.android.entity.commonEntity.LatestDailyEntity;
import com.iliubei.android.entity.themeDaily.ThemeContentListEntity;
import com.iliubei.android.ui.home.HomeContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomePresenter extends HomeContract.Presenter {

    @Override
    void getLatestDaily() {
        mRxManager.add(mModel.getLatestDaily()
        .subscribe(new Subscriber<LatestDailyEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
            }

            @Override
            public void onNext(LatestDailyEntity latestDailyEntity) {
                mView.refreshHomeList(latestDailyEntity);
            }
        }));
    }

    @Override
    void getBeforeDaily(String date) {

    }

    @Override
    void getOtherThemeList(int id) {
        mRxManager.add(mModel.getThemeContentList(id)
        .subscribe(new Subscriber<ThemeContentListEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ThemeContentListEntity themeContentListEntity) {
                mView.refreshHomeList(themeContentListEntity);
            }
        }));
    }
}
