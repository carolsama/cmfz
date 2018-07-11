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
//    public List<Statistics> showUsers(){
//
//
//        List<Statistics> list = new ArrayList<Statistics>();
//
//        Statistics sevenDay = new Statistics(1,"7天");
//        Statistics fiftyDay = new Statistics(2,"15天");
//        Statistics thirtyDay = new Statistics(4,"30天");
//        Statistics ninetyDay = new Statistics(8,"90天");
//        Statistics halfYear = new Statistics(9,"半年");
//        Statistics oneYear = new Statistics(9,"一年");
//
//        list.add(sevenDay);
//        list.add(fiftyDay);
//        list.add(thirtyDay);
//        list.add(ninetyDay);
//        list.add(halfYear);
//        list.add(oneYear);
//
//        return list;
//    }
    public Map<String,Object> showUsers(){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"7天","15天","30天","半年","一年"});
        map.put("counts",new int[]{1,2,4,9,9});
        return map;
    }
}
