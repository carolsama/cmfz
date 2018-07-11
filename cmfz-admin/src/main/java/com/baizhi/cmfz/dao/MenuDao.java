package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 菜单的dao
 * @Author Administrator
 * @Time 2018/7/5 10:30
 */
public interface MenuDao {

   // public List<Menu> selectParentMenu();

    public List<Menu> selectSonMenu();

}
