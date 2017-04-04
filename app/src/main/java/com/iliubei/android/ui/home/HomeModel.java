package com.iliubei.android.ui.home;

import com.iliubei.android.api.Networks;
import com.iliubei.android.entity.commonEntity.BeforeDailyEntity;
import com.iliubei.android.entity.commonEntity.LatestDailyEntity;
import com.iliubei.android.entity.themeDaily.ThemeContentListEntity;
import com.iliubei.android.mvpframe.rx.RxSchedulerHelper;
import com.iliubei.android.ui.home.HomeContract;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomeModel implements HomeContract.Model {

    @Override
    public Observable<LatestDailyEntity> getLatestDaily() {
        return Networks.getInstance().getCommonApi1().getLatestDaily1()
                .compose(RxSchedulerHelper.<LatestDailyEntity>io_main());
    }

    @Override
    public Observable<BeforeDailyEntity> getBeforeDaily(String date) {
        return Networks.getInstance().getCommonApi1().getBeforeDaily(date)
                .compose(RxSchedulerHelper.<BeforeDailyEntity>io_main());
    }

    @Override
    public Observable<ThemeContentListEntity> getThemeContentList(int id) {
        return Networks.getInstance().getThemeApi().getThemeContentList(id)
                .compose(RxSchedulerHelper.<ThemeContentListEntity>io_main());
    }
}
