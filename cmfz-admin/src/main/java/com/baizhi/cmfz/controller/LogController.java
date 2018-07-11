package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import com.baizhi.cmfz.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description 日志controller
 * @Author Administrator
 * @Time 2018/7/10 9:05
 */
@Controller
@RequestMapping("/log")
public class LogController {


    @Autowired
    private LogService logService;

    /**
     * @Description 方法的作用
     * @Author Administrator
     * @Time 2018/7/10 9:05
     * @Param 参数的作用
     * @Exception 抛出的异常
     */

//    @RequestMapping("/add")
//    @ResponseBody
//    public String addLog(Log log){
//        Log l = new Log(UUIDUtils.getUUID(),log.getLogUser(),log.getLogResource(),log.getLogAction(),log.getLogMessage(),log.getLogResult());
//        logService.addLog(l);
//        return "success";
//    }

    @RequestMapping("/all")
    @ResponseBody
    public Map<String,Object> queryAllLogByPage(Integer page ,Integer rows){

        return logService.queryLogsByPage(page,rows);
    }
}
