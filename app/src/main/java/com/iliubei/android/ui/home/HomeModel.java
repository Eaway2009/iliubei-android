package com.iliubei.android.ui.home;

import com.iliubei.android.api.Networks;
import com.iliubei.android.entity.commonEntity.LatestDailyEntity;
import com.iliubei.android.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomeModel implements HomeContract.Model {

    @Override
    public Observable<LatestDailyEntity> getIndexPage() {
        return Networks.getInstance().getCommonApi().getIndexPage()
                .compose(RxSchedulerHelper.<LatestDailyEntity>io_main());
    }
}
