package com.iliubei.android.ui.splash;

import com.iliubei.android.api.Networks;
import com.iliubei.android.entity.commonEntity.SplashImgEntity;
import com.iliubei.android.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/3.
 */

public class SplashModel implements SplashContract.Model{
    @Override
    public Observable<SplashImgEntity> getSplahImg() {
        return Networks.getInstance().
                getCommonApi1().
                getSplashImg().
                compose(RxSchedulerHelper.<SplashImgEntity>io_main());

    }
}
