package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Statistics;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 活跃用户
 * @Author Administrator
 * @Time 2018/7/9 19:30
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @RequestMapping("/activeUser")
    @ResponseBody

    public Map<String,Object> showUsers(){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"7天","15天","30天","半年","一年"});
        map.put("counts",new int[]{1,2,4,9,9});
        return map;
    }
}
