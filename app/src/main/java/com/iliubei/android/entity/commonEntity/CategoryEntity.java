package com.iliubei.android.entity.commonEntity;

import com.iliubei.android.ui.drawer.DisplaybleItem;

/**
 * Created by xn058827 on 2017/5/23.
 */

public class CategoryEntity implements DisplaybleItem {

    private String name;

    private String typeid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
}
