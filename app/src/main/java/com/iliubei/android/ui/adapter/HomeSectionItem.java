package com.iliubei.android.ui.adapter;

import com.iliubei.android.ui.drawer.DisplaybleItem;
import com.iliubei.android.util.DateUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomeSectionItem implements DisplaybleItem {

    private String strDate;

    private String formatDate;

    public HomeSectionItem(String strDate) {
        this.strDate = strDate;
    }

    public String getFormatDate() {
        if (strDate == null) {
            return null;
        }

        Date date = new Date();
        date = DateUtils.str2date(strDate, "yyyyMMdd");
        formatDate = DateUtils.date2str(date);
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }
}
