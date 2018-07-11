package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/8 13:37
 */
public interface MasterDao {

    public int insertMaster(Master master);

    public int updateMaster(@Param("master_id") Integer master_id,@Param("master_summary") String master_summary);

    public int countMaster();

    public int countLikeName(@Param("value")String value);

    public Master selectMasterById(Integer master_id);

    public List<Master> selectAllMaster();

    public List<Master> selectMasterByPage(@Param("begin")Integer begin,@Param("end")Integer end);

    public List<Master> selectMasterLikeName(@Param("master_name")String master_name,@Param("value")String value,@Param("begin")Integer begin,@Param("end")Integer end);

    public void insertBatch(@Param("list") List<Master> list);
}
