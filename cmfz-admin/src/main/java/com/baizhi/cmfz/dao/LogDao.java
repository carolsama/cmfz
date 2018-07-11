package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 日志Dao
 * @Author Administrator
 * @Time 2018/7/9 21:07
 */
public interface LogDao {

    public int insertLog(Log log);

    public int countLog();

    public List<Log> selectAllLogsByPage(@Param("begin")Integer begin,@Param("end") Integer end);
}
