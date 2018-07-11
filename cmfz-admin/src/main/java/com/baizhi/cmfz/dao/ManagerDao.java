package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * @Description 管理员dao层
 * @Author Administrator
 * @Time 2018/7/4 15:42
 */
public interface ManagerDao {

    public Manager selectManagerByName(@Param("mgr_name") String mgr_name);

    public int updateManager(Manager manager);

}
