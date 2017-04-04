package com.iliubei.android.entity.commonEntity;

import com.iliubei.android.ui.drawer.DisplaybleItem;

/**
 * Created by Administrator on 2017/1/5.
 */

public class StoriesEntity implements DisplaybleItem{


//            "path": "/dapian/dongzuo/",
//                "img": "http://iliubei.com/uploads/allimg/170318/1_031Q010511142.jpg",
//                "sendDate": "2017-03-18",
//                "typeid": 11,
//                "id": 3329,
//                "title": "金刚狼3：殊死一战",
//                "url": "/dapian/dongzuo/3329.html",
//                "desc": "百度云电影金刚狼3：殊死一战基本简介： 导演: 詹姆斯曼高德"

    private String path;
    private String img;
    private String sendDate;
    private int typeid;
    private long id;
    private String title;
    private String url;
    private String desc;

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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

    @Override
    public String toString() {
        return "StoriesEntity{" +
                "path='" + path + '\'' +
                ", img='" + img + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", typeid=" + typeid +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
