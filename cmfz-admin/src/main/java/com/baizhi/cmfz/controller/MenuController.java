package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description 菜单Controller
 * @Author Administrator
 * @Time 2018/7/5 14:44
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * @Description 查找二级菜单
     * @Author Administrator
     * @Time 2018/7/5 14:44
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Menu> queryAll(){

        return menuService.querySonMenu();
    }

}
