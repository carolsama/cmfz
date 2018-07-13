package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;

import java.util.List;

/**
 * @Description 管理员服务层
 * @Author Administrator
 * @Time 2018/7/4 15:50
 */

public interface ManagerService {

    public Manager queryManagerByName(String mgr_name, String mgr_pwd);

    public Manager queryManagerByName(String mgrName);

    public int modifyManager(Manager manager);

    public List<SysRole> queryRolesByMgrName(String mgrName);

    public List<SysPermission> queryResourceByMgrName(String mgrName);
}
