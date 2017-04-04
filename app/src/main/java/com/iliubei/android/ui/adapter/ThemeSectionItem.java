package com.iliubei.android.ui.adapter;

import com.iliubei.android.entity.themeDaily.EditorsEntity;
import com.iliubei.android.ui.drawer.DisplaybleItem;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class ThemeSectionItem implements DisplaybleItem {

    private List<EditorsEntity> mEditors;

    public ThemeSectionItem(List<EditorsEntity> editors) {
        mEditors = editors;
    }

    public List<EditorsEntity> getEditors() {
        return mEditors;
    }

    public void setEditors(List<EditorsEntity> editors) {
        mEditors = editors;
    }
}
