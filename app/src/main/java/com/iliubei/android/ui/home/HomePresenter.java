package com.iliubei.android.ui.home;

import com.iliubei.android.entity.commonEntity.LatestDailyEntity;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomePresenter extends HomeContract.Presenter {

    @Override
    void getIndexPage() {
        mRxManager.add(mModel.getIndexPage()
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
}
