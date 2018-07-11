package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * @Description 日志service
 * @Author Administrator
 * @Time 2018/7/10 8:54
 */
public interface LogService {
    public int addLog(Log log);

    public Map<String,Object> queryLogsByPage(Integer pageIndex, Integer pageSize);
}
