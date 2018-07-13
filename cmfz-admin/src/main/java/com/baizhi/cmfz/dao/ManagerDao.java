package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 管理员dao层
 * @Author Administrator
 * @Time 2018/7/4 15:42
 */
public interface ManagerDao {

    public Manager selectManagerByName(@Param("mgr_name") String mgr_name);

    public int updateManager(Manager manager);

    public List<SysRole> selectRolesByMgrName(@Param("mgrName") String mgrName);

    public List<SysPermission> selectResourceByUsername(@Param("mgrName")String mgrName);

}
