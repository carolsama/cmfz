package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 日志ServiceImpl
 * @Author Administrator
 * @Time 2018/7/10 8:59
 */
@Service
@Transactional
public class LogServiceImpl implements LogService{

    @Autowired
    private LogDao logDao;

    /**
     * @Description 添加日志
     * @Author Administrator
     * @Time 2018/7/10 8:59
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    public int addLog(Log log) {
        return logDao.insertLog(log);
    }

    /**
     * @Description 分页查询日志
     * @Author Administrator
     * @Time 2018/7/10 8:59
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryLogsByPage(Integer pageIndex, Integer singleRows) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Log> logs = logDao.selectAllLogsByPage((pageIndex - 1) * singleRows, singleRows);
        Integer i = logDao.countLog();
        map.put("total",i);
        map.put("rows",logs);
        return map;
    }

}
