package com.iliubei.android.ui.detail;

import android.util.Log;

import com.iliubei.android.entity.commonEntity.StoryContentEntity;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/12.
 */

public class DetailPresenter extends DetailContract.Presenter {
    @Override
    void getStoryContent(long id) {
        mRxManager.add(mModel.getStoryContent(id)
        .subscribe(new Subscriber<StoryContentEntity>() {
            @Override
            public void onCompleted() {
                Log.v("eaway", "onCompleted: 完成");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("eaway", "onError: ", e);
            }

            @Override
            public void onNext(StoryContentEntity storyContentEntity) {
                mView.showContent(storyContentEntity);
            }
        }));
    }
}
