package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 菜单service实现类
 * @Author Administrator
 * @Time 2018/7/5 14:17
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menudao ;

//    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
//    public List<Menu> queryParentMenu() {
//        List<Menu> list = null;
//        list = menudao.selectParentMenu();
//        if(list!=null){
//            return list;
//        }
//        return null;
//    }

    /**
     * @Description 查询菜单
     * @Author Administrator
     * @Time 2018/7/5 14:17
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public  List<Menu> querySonMenu() {
        List<Menu> list = menudao.selectSonMenu();
        if(list!=null){

            return list;
        }
        return null;
    }

}
