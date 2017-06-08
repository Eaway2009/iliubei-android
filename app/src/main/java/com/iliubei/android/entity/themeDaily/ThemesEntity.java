package com.iliubei.android.entity.themeDaily;

import com.iliubei.android.entity.commonEntity.CategoryEntity;
import com.iliubei.android.ui.drawer.DisplaybleItem;

import java.util.List;
import java.util.Map;

/**
 * {
 *  "errcode": 0,
 *  "categorys": {
 * "1": "院线大片",
 * "25": "伦理电影",
 * "31": "豆瓣电影",
 * "32": "擦边电影"
 * },
 * "errmsg": ""
 * }
 *
 * Created by eaway on 2016/12/27.
 */

public class ThemesEntity {

    private int errcode;
    private List<CategoryEntity> categorys;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public List<CategoryEntity> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategoryEntity> categorys) {
        this.categorys = categorys;
    }

}
