package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @Description 菜单service
 * @Author Administrator
 * @Time 2018/7/5 14:13
 */
public interface MenuService {

   // public List<Menu> queryParentMenu();

    public List<Menu> querySonMenu();
}
