package com.iliubei.android.ui.detail;

import com.iliubei.android.entity.commonEntity.StoryContentEntity;
import com.iliubei.android.mvpframe.base.BaseModel;
import com.iliubei.android.mvpframe.base.BasePresenter;
import com.iliubei.android.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/12.
 */

public interface DetailContract {

    interface Model extends BaseModel {
        Observable<StoryContentEntity> getStoryContent(long id);
    }

    interface View extends BaseView {
        void showContent(StoryContentEntity storyContentEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getStoryContent(long id);
    }
}
