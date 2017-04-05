package com.iliubei.android.api;

import com.iliubei.android.entity.themeDaily.ThemeContentListEntity;
import com.iliubei.android.entity.themeDaily.ThemesEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by eaway on 2016/12/27.
 */

public interface ThemeApi {
    /**
     * 获取主题列表theme
     */
    @GET("themes")
    Observable<ThemesEntity> getThemes();

    /**
     * 获取主题内容列表
     * @param themeId 主题id
     */
    @GET("theme/{themeId}")
    Observable<ThemeContentListEntity> getThemeContentList(@Path("themeId") int themeId);

}
