package com.iliubei.android.ui.adapter;

import com.iliubei.android.entity.commonEntity.BannerEntity;
import com.iliubei.android.ui.drawer.DisplaybleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomeHeaderItem implements DisplaybleItem {
    private List<BannerEntity> topStories;
    private List<String> images;
    private List<String> titles;
    private List<Long> ids;

    public HomeHeaderItem(List<BannerEntity> topStories) {
        this.topStories = topStories;
        initData();
    }

    private void initData() {
        images = new ArrayList<>();
        titles = new ArrayList<>();
        ids = new ArrayList<>();

        for (BannerEntity topStory : topStories) {
            images.add(topStory.getImg());
            titles.add(topStory.getTitle());
            ids.add(topStory.getId());
        }
    }

    public List<BannerEntity> getTopStories() {
        return topStories;
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<Long> getIds() {
        return ids;
    }
}
