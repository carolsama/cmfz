package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 轮播图实体类
 * @Author Administrator
 * @Time 2018/7/6 9:27
 */
public class Picture implements Serializable{
    private String picture_id;
    private String picture_path;
    private String picture_description;
    private Integer picture_status;
    private String picture_date;

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public String getPicture_description() {
        return picture_description;
    }

    public void setPicture_description(String picture_description) {
        this.picture_description = picture_description;
    }

    public Integer getPicture_status() {
        return picture_status;
    }

    public void setPicture_status(Integer picture_status) {
        this.picture_status = picture_status;
    }

    public String getPicture_date() {
        return picture_date;
    }

    public void setPicture_date(String picture_date) {
        this.picture_date = picture_date;
    }

    public Picture(String picture_id, String picture_path, String picture_description, Integer picture_status, String picture_date) {
        this.picture_id = picture_id;
        this.picture_path = picture_path;
        this.picture_description = picture_description;
        this.picture_status = picture_status;
        this.picture_date = picture_date;
    }

    public Picture() {
        super();
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picture_id='" + picture_id + '\'' +
                ", picture_path='" + picture_path + '\'' +
                ", picture_description='" + picture_description + '\'' +
                ", picture_status=" + picture_status +
                ", picture_date='" + picture_date + '\'' +
                '}';
    }
}


