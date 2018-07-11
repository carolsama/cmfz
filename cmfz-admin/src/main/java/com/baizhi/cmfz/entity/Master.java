package com.baizhi.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description 上师实体类
 * @Author Administrator
 * @Time 2018/7/8 11:04
 */
public class Master implements Serializable{
    @Excel(name = "编号")
    private Integer master_id;
    @Excel(name = "法名")
    private String master_name;
    @Excel(name = "头像")
    private String master_photo;
    @Excel(name = "描述信息")
    private String master_summary;

    public Integer getMaster_id() {
        return master_id;
    }

    public void setMaster_id(Integer master_id) {
        this.master_id = master_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public String getMaster_photo() {
        return master_photo;
    }

    public void setMaster_photo(String master_photo) {
        this.master_photo = master_photo;
    }

    public String getMaster_summary() {
        return master_summary;
    }

    public void setMaster_summary(String master_summary) {
        this.master_summary = master_summary;
    }

    public Master() {
        super();
    }

    public Master(Integer master_id, String master_name, String master_photo, String master_summary) {
        this.master_id = master_id;
        this.master_name = master_name;
        this.master_photo = master_photo;
        this.master_summary = master_summary;
    }

    @Override
    public String toString() {
        return "Master{" +
                "master_id=" + master_id +
                ", master_name='" + master_name + '\'' +
                ", master_photo='" + master_photo + '\'' +
                ", master_summary='" + master_summary + '\'' +
                '}';
    }
}
