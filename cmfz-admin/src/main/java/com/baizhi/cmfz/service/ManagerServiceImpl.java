package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/4 16:54
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerdao;

    /**
     * @Description 管理员登录
     * @Author Administrator
     * @Time 2018/7/4 16:54
     * @Param 输入名字和密码登录
     * @Exception 抛出的异常
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Manager queryManagerByName(String mgr_name, String mgr_pwd) {
        Manager mgr = managerdao.selectManagerByName(mgr_name);
        if(mgr!=null && mgr.getMgr_pwd().equals(mgr_pwd)){
            return mgr;
        }
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int modifyManager(Manager manager) {

        return managerdao.updateManager(manager);
    }


}
