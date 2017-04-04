package com.iliubei.android.entity.commonEntity;

import java.util.List;

/**
 * Created by yiyi on 2016/12/27.
 */

public class LatestDailyEntity {

//    {
//        "webdes": "爱刘备电影网致力于为大家提供稀缺的百度云电影在线看，百度云电影高清下载，百度云资源，让大家告别视频网站无节操的收费，并为大家提供百度云论坛，让大家把自己所藏的百度云电影资源分享给别人。爱刘备电影网，值得你拥有。记住我们的网址：www.iliubei.com 。",
//        "errcode": 0,
//        "allPager": [
//        {
//            "path": "/dapian/dongzuo/",
//                "img": "http://iliubei.com/uploads/allimg/170318/1_031Q010511142.jpg",
//                "sendDate": "2017-03-18",
//                "typeid": 11,
//                "id": 3329,
//                "title": "金刚狼3：殊死一战",
//                "url": "/dapian/dongzuo/3329.html",
//                "desc": "百度云电影金刚狼3：殊死一战基本简介： 导演: 詹姆斯曼高德"
//        }
//        ],
//        "webtitle": "百度云电影在线看_百度云电影高清下载_百度云资源_爱刘备电影网",
//         "tuijian": [
//        {
//            "img": "http://iliubei.com/uploads/allimg/170316/1_0316214913M12.png",
//                "sendDate": "2017-03-16",
//                "title": "新娘",
//                "url": "/dapian/jingsong/3325.html",
//                "desc": "百度云电影新娘基本简介： 导演: Svyatoslav Po"
//        }
//        ],
//        "webkeywords": "百度云电影，百度云资源，百度云论坛，看片网站",
//        "hot5": [
//        {
//            "path": "/flash/",
//                "img": "http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/170312/1-1F312230U1Q3.jpg?imageMogr2/thumbnail/!300x300r|imageView2/1/w/300/h/200",
//                "typeid": 32,
//                "id": 3310,
//                "title": "年轻的嫂子2",
//                "url": "/flash/3310.html"
//        }
//        ],
//        "banner": [
//        {
//            "path": "/flash/",
//                "img": "http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/170317/1-1F31H2050M29.jpg?imageMogr2/thumbnail/!300x300r|imageView2/1/w/300/h/200",
//                "typeid": 32,
//                "id": 3327,
//                "title": "朋友夫妇交换",
//                "url": "/flash/3327.html"
//        }
//        ],
//        "errmsg": "",
//        "toutiao": [
//        {
//            "img": "http://iliubei.com/uploads/allimg/170318/1_031Q010511142.jpg",
//                "sendDate": "2017-03-18",
//                "title": "金刚狼3：殊死一战",
//                "url": "/dapian/dongzuo/3329.html",
//                "desc": "百度云电影金刚狼3：殊死一战基本简介： 导演: 詹姆斯曼高德"
//        }
//        ]
//    }
    private String webdes;
    private int errcode;
    private List<StoriesEntity> allPager;
    private String webtitle;
    private List<BaseStoriesEntity> tuijian;
    private String webkeywords;
    private List<TopStoriesEntity> hot5;
    private List<BannerEntity> banner;
    private String errmsg;
    private List<BaseStoriesEntity> toutiao;

    public String getWebdes() {
        return webdes;
    }

    public void setWebdes(String webdes) {
        this.webdes = webdes;
    }

    public String getWebtitle() {
        return webtitle;
    }

    public void setWebtitle(String webtitle) {
        this.webtitle = webtitle;
    }

    public String getWebkeywords() {
        return webkeywords;
    }

    public void setWebkeywords(String webkeywords) {
        this.webkeywords = webkeywords;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public List<StoriesEntity> getAllPager() {
        return allPager;
    }

    public void setAllPager(List<StoriesEntity> allPager) {
        this.allPager = allPager;
    }

    public List<BaseStoriesEntity> getTuijian() {
        return tuijian;
    }

    public void setTuijian(List<BaseStoriesEntity> tuijian) {
        this.tuijian = tuijian;
    }

    public List<TopStoriesEntity> getHot5() {
        return hot5;
    }

    public void setHot5(List<TopStoriesEntity> hot5) {
        this.hot5 = hot5;
    }

    public List<BannerEntity> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerEntity> banner) {
        this.banner = banner;
    }

    public List<BaseStoriesEntity> getToutiao() {
        return toutiao;
    }

    public void setToutiao(List<BaseStoriesEntity> toutiao) {
        this.toutiao = toutiao;
    }

    @Override
    public String toString() {
        return "LatestDailyEntity{" +
                "webdes='" + webdes + '\'' +
                ", webtitle='" + webtitle + '\'' +
                ", webkeywords='" + webkeywords + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", errcode=" + errcode +
                ", allPager=" + allPager +
                ", tuijian=" + tuijian +
                ", hot5=" + hot5 +
                ", banner=" + banner +
                ", toutiao=" + toutiao +
                '}';
    }
}
