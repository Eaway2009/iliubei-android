package com.iliubei.android.entity.themeDaily;

import com.iliubei.android.entity.commonEntity.ArticleListItemEntity;

import java.util.List;

/**
 * Created by xn058827 on 2017/5/23.
 */

public class ArticleListEntity {
    /**{
      *  "errcode": 0,
      *  "errmsg": "",
      *  "articles": [
      *  {
      *        "img": "http://iliubei.com/uploads/allimg/160823/1_0R3144334EX.jpg",
      *          "sendDate": "2016-08-23 14:43",
      *         "title": "欲望姐姐们",
      *          "aid": 2839,
      *          "url": "/cabian/2839.html",
      *          "desc": "百度云电影欲望姐姐们基本信息 导演: 主演: / 名井南 /"
      *  }
      *  ]
      *}
      **/

    private int errcode;
    private String errmsg;
    private List<ArticleListItemEntity> articles;

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

    public List<ArticleListItemEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleListItemEntity> articles) {
        this.articles = articles;
    }
}
