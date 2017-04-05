package com.iliubei.android.ui.drawer;

import com.iliubei.android.R;
import com.iliubei.android.entity.themeDaily.ThemesEntity;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by eaway on 2016/12/29.
 */

public class DrawerContentItemDelegate implements ItemViewDelegate<DisplaybleItem>{

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_drawer_menu_content;
    }

    @Override
    public boolean isForViewType(DisplaybleItem item, int position) {
        return item instanceof ThemesEntity.OthersEntity;
    }

    @Override
    public void convert(ViewHolder holder, DisplaybleItem displaybleItem, final int position) {
        holder.setText(R.id.item_theme_list_tv, ((ThemesEntity.OthersEntity)displaybleItem).getName());
    }

}
