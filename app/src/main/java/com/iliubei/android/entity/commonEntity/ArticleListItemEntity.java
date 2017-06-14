package com.iliubei.android.entity.commonEntity;

import com.iliubei.android.ui.drawer.DisplaybleItem;

/**
 * Created by xn058827 on 2017/5/23.
 */

public class ArticleListItemEntity  implements DisplaybleItem {
    private String img;
    private String sendDate;
    private String title;
    private long aid;
    private String url;
    private String desc;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
