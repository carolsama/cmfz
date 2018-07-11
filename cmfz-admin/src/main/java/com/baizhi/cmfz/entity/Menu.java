package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 菜单实体类
 * @Author Administrator
 * @Time 2018/7/5 10:25
 */
public class Menu implements Serializable{

    private Integer menu_id;
    private String menu_name;
    private String menu_code;
    private String menu_icon;
    private String menu_url;
    private Integer menu_level;
    private Integer menu_parent_id;
    private List<Menu> list ;

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_code() {
        return menu_code;
    }

    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public Integer getMenu_level() {
        return menu_level;
    }

    public void setMenu_level(Integer menu_level) {
        this.menu_level = menu_level;
    }

    public Integer getMenu_parent_id() {
        return menu_parent_id;
    }

    public void setMenu_parent_id(Integer menu_parent_id) {
        this.menu_parent_id = menu_parent_id;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    public Menu(Integer menu_id, String menu_name, String menu_code, String menu_icon, String menu_url, Integer menu_level, Integer menu_parent_id, List<Menu> list) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.menu_code = menu_code;
        this.menu_icon = menu_icon;
        this.menu_url = menu_url;
        this.menu_level = menu_level;
        this.menu_parent_id = menu_parent_id;
        this.list = list;
    }

    public Menu() {
        super();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_code='" + menu_code + '\'' +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", menu_level=" + menu_level +
                ", menu_parent_id=" + menu_parent_id +
                ", list=" + list +
                '}';
    }
}
