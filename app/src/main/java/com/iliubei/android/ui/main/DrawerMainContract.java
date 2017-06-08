package com.iliubei.android.ui.main;

import com.iliubei.android.entity.themeDaily.ThemesEntity;
import com.iliubei.android.mvpframe.base.BaseModel;
import com.iliubei.android.mvpframe.base.BasePresenter;
import com.iliubei.android.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2016/12/31.
 */

public interface DrawerMainContract {

    interface Model extends BaseModel {
        Observable<ThemesEntity> getCategorys();
    }

    interface View extends BaseView {
        void loadOtherThemeList(ThemesEntity themesEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getOtherThemes();
    }
}
