package com.iliubei.android.entity.commonEntity;

/**
 * Created by eaway on 2017/3/19.
 */
public class BaseStoriesEntity {

//            "img": "http://iliubei.com/uploads/allimg/170316/1_0316214913M12.png",
//                "sendDate": "2017-03-16",
//                "title": "新娘",
//                "url": "/dapian/jingsong/3325.html",
//                "desc": "百度云电影新娘基本简介： 导演: Svyatoslav Po"
    
    private String img;
    private String sendDate;
    private String title;
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
        return "BaseStoriesEntity{" +
                "img='" + img + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
