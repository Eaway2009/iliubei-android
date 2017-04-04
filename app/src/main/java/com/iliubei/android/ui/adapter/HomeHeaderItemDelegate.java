package com.iliubei.android.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.iliubei.android.R;
import com.iliubei.android.loader.GlideImageLoader;
import com.iliubei.android.ui.detail.ArticleDetailActivity;
import com.iliubei.android.ui.drawer.DisplaybleItem;
import com.iliubei.android.ui.widget.Banner.Banner;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomeHeaderItemDelegate implements ItemViewDelegate<DisplaybleItem>, Banner.OnBannerClickListener {

    private static final String TAG = "HomeHeaderItemDelegate";

    private Context mContext;

    private List<Long> mIds;


    @Override
    public int getItemViewLayoutId() {
        return R.layout.home_header;
    }

    @Override
    public boolean isForViewType(DisplaybleItem item, int position) {
        return item instanceof HomeHeaderItem;
    }

    @Override
    public void convert(ViewHolder holder, DisplaybleItem displaybleItem, int position) {
        mContext = holder.getConvertView().getContext();
        Banner banner = holder.getView(R.id.banner);
        HomeHeaderItem item = (HomeHeaderItem) displaybleItem;
        mIds = item.getIds();
        banner.setImages(item.getImages())
                .setBannerTitles(item.getTitles())
                .setImageLoader(GlideImageLoader.getInstance())
                .setOnBannerClickListener(this)
                .start();
    }

    @Override
    public void OnBannerClick(int position) {
        if (mIds == null) {
            Log.e(TAG, "error : id列表为空！");
            return;
        }
        Intent intent = new Intent(mContext, ArticleDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLong("articleId", mIds.get(position));
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

}
