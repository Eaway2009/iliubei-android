package com.iliubei.android.entity.commonEntity;

/**
 * Created by eaway on 2017/3/19.
 */
public class BannerEntity {
//            "path": "/flash/",
//                "img": "http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/170317/1-1F31H2050M29.jpg?imageMogr2/thumbnail/!300x300r|imageView2/1/w/300/h/200",
//                "typeid": 32,
//                "id": 3327,
//                "title": "朋友夫妇交换",
//                "url": "/flash/3327.html"

    private String path;
    private String img;
    private int typeid;
    private long id;
    private String title;
    private String url;

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

    @Override
    public String toString() {
        return "BannerEntity{" +
                "path='" + path + '\'' +
                ", img='" + img + '\'' +
                ", typeid=" + typeid +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
