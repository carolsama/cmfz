package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 管理员服务层
 * @Author Administrator
 * @Time 2018/7/4 15:50
 */

public interface ManagerService {

    public Manager queryManagerByName(String mgr_name, String mgr_pwd);

    public int modifyManager(Manager manager);
}
