package com.sqw.fnsy.fengniao.bean;

import java.io.Serializable;

/**
 * Created by SUN on 2016/10/2.
 */

public class ZiXunBean implements Serializable {

    /**
     * title : 大疆Mavic Pro中国媒体体验会在京举行
     * pic_url : http://img2.fengniao.com/article/12_280x210/620/lijYYSNQaPweQ.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5339353&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5339353&isPad=1
     * doc_id : 5339353
     * web_url : http://qicai.fengniao.com/533/5339353.html
     */

    public String title;
    public String pic_url;
    public String doc_url;
    public int comment_page_num;
    public String comments_num;
    public String more_comment_url;
    public String doc_id;
    public String web_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getDoc_url() {
        return doc_url;
    }

    public void setDoc_url(String doc_url) {
        this.doc_url = doc_url;
    }

    public int getComment_page_num() {
        return comment_page_num;
    }

    public void setComment_page_num(int comment_page_num) {
        this.comment_page_num = comment_page_num;
    }

    public String getComments_num() {
        return comments_num;
    }

    public void setComments_num(String comments_num) {
        this.comments_num = comments_num;
    }

    public String getMore_comment_url() {
        return more_comment_url;
    }

    public void setMore_comment_url(String more_comment_url) {
        this.more_comment_url = more_comment_url;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
