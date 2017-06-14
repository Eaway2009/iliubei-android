package com.iliubei.android.api;

import com.iliubei.android.entity.commonEntity.BeforeDailyEntity;
import com.iliubei.android.entity.commonEntity.LatestDailyEntity;
import com.iliubei.android.entity.commonEntity.SplashImgEntity;
import com.iliubei.android.entity.commonEntity.StoryContentEntity;
import com.iliubei.android.entity.commonEntity.StoryExtraEntity;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.entity.themeDaily.ThemesEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by eaway on 2016/12/27.
 */

public interface CommonApi {
    /**
     * 获取启动界面图像
     * @return
     */
    @GET("start-image/1080*1776")
    Observable<SplashImgEntity> getSplashImg();

    /**
     * 获取最新文章列表
     * @return
     */
    @GET("index")
    Observable<LatestDailyEntity> getIndexPage();

    /**
     * 获取相应文章内容
     * @param aid
     * @return
     */
    @GET("article/detail")
    Observable<StoryContentEntity> getStoryContent(@Query("aid") String aid);


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
