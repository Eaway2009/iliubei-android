package com.iliubei.android.entity.commonEntity;

/**
 * Created by eaway on 2016/12/27.
 */

public class StoryContentEntity {

    private int errcode;
    private String errmsg;
    private int typeid;
    private Article article;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * "errcode": 0,
     * "errmsg": "",
     * "typeid": 32,
     * "article": {
     * "keywords": "性冷淡,百度,电影,性冷淡,基本,简介,导演,主演,尹世娜,",
     * "beiyong": "2017-03-05 22:22",
     * "description": "百度云电影性冷淡基本简介： 导演: 主演: 尹世娜 类型: 剧情 / 爱情 制片国家/地区: 韩国 语言: 韩语 上映日期: 2017-02-09(韩国) 片长: 82分钟 又名: Sexless 百度云电影性 冷淡 剧情介绍： 讲述的是身为医生的丈夫和护士在医院发生的羞羞的故事，以及妻子",
     * "typeid": 32,
     * "id": 3286,
     * "body": "<div>\r\n\t<img alt=\"韩国限制级电影性冷淡百度云高清资源\" src=\"http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/1-1F305221458.jpg?imageMogr2/thumbnail/!300x200r|imageView2/1/w/300/h/200\" /><img alt=\"韩国限制级电影性冷淡百度云高清资源\" src=\"http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/1-1F305221456.jpg?imageMogr2/thumbnail/!300x200r|imageView2/1/w/300/h/200\" /><img alt=\"韩国限制级电影性冷淡百度云高清资源\" src=\"http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/1-1F305221457.jpg?imageMogr2/thumbnail/!300x200r|imageView2/1/w/300/h/200\" /><img alt=\"韩国限制级电影性冷淡百度云高清资源\" src=\"http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/1-1F305221457-50.jpg?imageMogr2/thumbnail/!300x200r|imageView2/1/w/300/h/200\" /><img alt=\"韩国限制级电影性冷淡百度云高清资源\" src=\"http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/1-1F305221459.jpg?imageMogr2/thumbnail/!300x200r|imageView2/1/w/300/h/200\" /><img alt=\"韩国限制级电影性冷淡百度云高清资源\" src=\"http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/1-1F305221459-50.jpg?imageMogr2/thumbnail/!300x200r|imageView2/1/w/300/h/200\" /><img alt=\"韩国限制级电影性冷淡百度云高清资源\" src=\"http://7xwpy5.com1.z0.glb.clouddn.com/uploads/allimg/1-1F305221500.jpg?imageMogr2/thumbnail/!300x200r|imageView2/1/w/300/h/200\" /><br />\r\n\t<strong>百度云电影性冷淡基本简介：</strong></div>\r\n<div>\r\n\t导演: 이강림</div>\r\n<div>\r\n\t主演: 尹世娜</div>\r\n<div>\r\n\t类型: 剧情 / 爱情</div>\r\n<div>\r\n\t制片国家/地区: 韩国</div>\r\n<div>\r\n\t语言: 韩语</div>\r\n<div>\r\n\t上映日期: 2017-02-09(韩国)</div>\r\n<div>\r\n\t片长: 82分钟</div>\r\n<div>\r\n\t又名: Sexless</div>\r\n<div>\r\n\t<strong>百度云电影性</strong><strong>冷淡</strong><strong>剧情介绍：</strong></div>\r\n<div>\r\n\t讲述的是身为医生的丈夫和护士在医院发生的羞羞的故事，以及妻子和男医生发生羞羞的故事。<span class=\"Apple-tab-span\" style=\"white-space:pre\"> </span></div>\r\n<div>\r\n\t<strong>百度云电影性</strong><strong>冷淡</strong><strong>评价：</strong></div>\r\n<div>\r\n\t医生和护士真的关系那么乱么？</div>\r\n<div>\r\n\t你想太多了，医生晚上在值班室休息，护士是在护士站值班，晚上有时候还会有医院的夜查房。夜班忙的时候，上厕所的时间都没有，呼叫器一直响，闲的时候医生去睡觉了，有事给医生打电话，有时候打两三个才能叫出来。还有现在医生和护士正常谈恋爱的越来越少了，两个人都忙，都要上夜班，有的医生还嫌护士学历低，所以大家都只是同事关系，除了年终科室聚餐，平时私下也很少见。</div>\r\n<div>\r\n\t </div>\r\n",
     * "title": "性冷淡",
     * "seo_title": "韩国限制级电影性冷淡百度云高清资源"
     * }
     */
    public class Article {
        private String body;
        private String title;
        private String seo_title;
        private String keywords;
        private String beiyong;
        private String description;
        private int typeid;
        private int id;

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSeo_title() {
            return seo_title;
        }

        public void setSeo_title(String seo_title) {
            this.seo_title = seo_title;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getBeiyong() {
            return beiyong;
        }

        public void setBeiyong(String beiyong) {
            this.beiyong = beiyong;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getTypeid() {
            return typeid;
        }

        public void setTypeid(int typeid) {
            this.typeid = typeid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
