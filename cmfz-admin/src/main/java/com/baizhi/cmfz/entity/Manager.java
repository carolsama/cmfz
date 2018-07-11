package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 管理员实体类
 * @Author  pan
 * @Time    2018-07-04 15:30:24
 */
public class Manager implements Serializable{

   private Integer mgr_id;
   private String mgr_name;
   private String mgr_pwd;
   private String mgr_salt;

    public Integer getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(Integer mgr_id) {
        this.mgr_id = mgr_id;
    }

    public String getMgr_name() {
        return mgr_name;
    }

    public void setMgr_name(String mgr_name) {
        this.mgr_name = mgr_name;
    }

    public String getMgr_pwd() {
        return mgr_pwd;
    }

    public void setMgr_pwd(String mgr_pwd) {
        this.mgr_pwd = mgr_pwd;
    }

    public String getMgr_salt() {
        return mgr_salt;
    }

    public void setMgr_salt(String mgr_salt) {
        this.mgr_salt = mgr_salt;
    }

    public Manager() {
        super();
    }

    public Manager(Integer mgr_id, String mgr_name, String mgr_pwd, String mgr_salt) {
        this.mgr_id = mgr_id;
        this.mgr_name = mgr_name;
        this.mgr_pwd = mgr_pwd;
        this.mgr_salt = mgr_salt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mgr_id=" + mgr_id +
                ", mgr_name='" + mgr_name + '\'' +
                ", mgr_pwd='" + mgr_pwd + '\'' +
                ", mgr_salt='" + mgr_salt + '\'' +
                '}';
    }
}

