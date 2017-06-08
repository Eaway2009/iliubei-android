package com.iliubei.android.api;

import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.entity.themeDaily.ThemeContentListEntity;
import com.iliubei.android.entity.themeDaily.ThemesEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by eaway on 2016/12/27.
 */

public interface ThemeApi {
    /**
     * 获取分类列表
     */
    @GET("article/listCategorys")
    Observable<ThemesEntity> getCategorys();

    /**
     * 获取主题内容列表
     * @param typeid 分类id
     * @param page 第几页
     */
    @GET("article/getArticleByTypeid")
    Observable<ArticleListEntity> getThemeContentList(@Query("typeid") int typeid, @Query("page") int page);

}
