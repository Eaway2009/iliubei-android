package com.iliubei.android.ui.detail;

import com.iliubei.android.api.Networks;
import com.iliubei.android.entity.commonEntity.StoryContentEntity;
import com.iliubei.android.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/12.
 */

public class DetailModel implements DetailContract.Model {
    @Override
    public Observable<StoryContentEntity> getStoryContent(long id) {
        return Networks.getInstance().getCommonApi()
                .getStoryContent(id+"")
                .compose(RxSchedulerHelper.<StoryContentEntity>io_main());
    }
}
