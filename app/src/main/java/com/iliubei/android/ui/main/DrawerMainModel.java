package com.iliubei.android.ui.main;

import com.iliubei.android.api.Networks;
import com.iliubei.android.entity.themeDaily.ThemesEntity;
import com.iliubei.android.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by Administrator on 2016/12/31.
 */

public class DrawerMainModel implements DrawerMainContract.Model{
    @Override
    public Observable<ThemesEntity> getOtherThemeList() {
        return Networks.getInstance().getThemeApi().
                getThemes()
                .compose(RxSchedulerHelper.<ThemesEntity>io_main());
    }
}
