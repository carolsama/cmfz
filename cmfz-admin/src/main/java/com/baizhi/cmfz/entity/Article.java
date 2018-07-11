package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/8 17:15
 */
public class Article implements Serializable{
    private Integer article_id;
    private String article_name;
    private Integer guru_id;
    private String article_text;
    private String article_date;
    private String article_status;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public Integer getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(Integer guru_id) {
        this.guru_id = guru_id;
    }

    public String getArticle_text() {
        return article_text;
    }

    public void setArticle_text(String article_text) {
        this.article_text = article_text;
    }

    public String getArticle_date() {
        return article_date;
    }

    public void setArticle_date(String article_date) {
        this.article_date = article_date;
    }

    public String getArticle_status() {
        return article_status;
    }

    public void setArticle_status(String article_status) {
        this.article_status = article_status;
    }

    public Article(Integer article_id, String article_name, Integer guru_id, String article_text, String article_date, String article_status) {
        this.article_id = article_id;
        this.article_name = article_name;
        this.guru_id = guru_id;
        this.article_text = article_text;
        this.article_date = article_date;
        this.article_status = article_status;
    }

    public Article() {
        super();
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_name='" + article_name + '\'' +
                ", guru_id=" + guru_id +
                ", article_text='" + article_text + '\'' +
                ", article_date='" + article_date + '\'' +
                ", article_status='" + article_status + '\'' +
                '}';
    }
}
