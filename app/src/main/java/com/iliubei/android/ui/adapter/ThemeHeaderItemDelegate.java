package com.iliubei.android.ui.adapter;

import android.widget.ImageView;

import com.iliubei.android.R;
import com.iliubei.android.loader.GlideImageLoader;
import com.iliubei.android.ui.drawer.DisplaybleItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ThemeHeaderItemDelegate implements ItemViewDelegate<DisplaybleItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.theme_header;
    }

    @Override
    public boolean isForViewType(DisplaybleItem item, int position) {
        return item instanceof ThemeHeaderItem;
    }

    @Override
    public void convert(ViewHolder holder, DisplaybleItem displaybleItem, int position) {
        ThemeHeaderItem item = (ThemeHeaderItem)displaybleItem;

        holder.setText(R.id.theme_header_tv, item.getDescription());

        ImageView iv = (ImageView) holder.getView(R.id.theme_header_iv);
        //Glide.with(holder.getConvertView().getContext()).load(item.getImage()).into(iv);
        GlideImageLoader.getInstance().displayImage(holder.getConvertView().getContext(), item.getImage(), iv);
    }
}
