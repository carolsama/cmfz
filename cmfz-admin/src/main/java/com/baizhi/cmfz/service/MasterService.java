package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description 上师service
 * @Author Administrator
 * @Time 2018/7/9 9:29
 */
public interface MasterService {

    public int addMaster(Master master);

    public int modifyMaster(Integer masterId,String masterSummary);

    public Master queryMasterById(Integer master_id);

    public List<Master> queryAllMaster();

    public Map<String,Object> queryMasterByPage(Integer pageIndex,Integer singleRows);

    public Map<String,Object> queryMasterLikeName(String master_name,String value, Integer pageIndex,Integer singleRows);

    public void addMasters(List<Master> masters);

}
