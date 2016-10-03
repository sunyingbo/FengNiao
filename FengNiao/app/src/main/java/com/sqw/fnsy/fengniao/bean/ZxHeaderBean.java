package com.sqw.fnsy.fengniao.bean;

/**
 * Created by SUN on 2016/10/1.
 */

public class ZxHeaderBean extends ZiXunBean {

    /**
     * type : doc
     * url : http://api.fengniao.com/app_ipad/news_iphone_doc_v1.php?docid=5331348
     * title : 自拍神器 SUGAR S手机让你的照片一秒变网红
     * pic_src : http://shougong.fn.img-space.com/g1/M00/05/C3/Cg-4q1ahlwuIflBvAADX989sZnAAAPFbwDb2uAAANgP859.jpg
     * date : 2016-01-22 06:41:22
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5331348&isPad=1
     * web_url : http://qsy.fengniao.com/533/5331348.html
     * doc_id : 5331348
     * author : 戚小梅
     */

    private String type;
    private String url;
    private String pic_src;
    private String date;
    private String doc_id;
    private String author;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic_src() {
        return pic_src;
    }

    public void setPic_src(String pic_src) {
        this.pic_src = pic_src;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
