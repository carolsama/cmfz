package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 上师serviceImpl
 * @Author Administrator
 * @Time 2018/7/9 9:40
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

   @Autowired
   private MasterDao masterDao;

    @Transactional
    public int addMaster(Master master) {

        Integer id = Integer.valueOf((int) (Math.random() * 1000000));

        master.setMaster_id(id);

        return masterDao.insertMaster(master);
    }

    @Transactional
    public int modifyMaster(Integer master_id,String master_summary) {
        return masterDao.updateMaster(master_id,master_summary);
    }

    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
    public Master queryMasterById(Integer master_id) {
        return masterDao.selectMasterById(master_id);
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public List<Master> queryAllMaster() {
        return masterDao.selectAllMaster();

    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryMasterByPage(Integer pageIndex, Integer singleRows) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<Master> masters =masterDao.selectMasterByPage((pageIndex-1)*singleRows,singleRows);
        Integer i = masterDao.countMaster();
        map.put("total",i);
        map.put("rows",masters);
        return map;
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryMasterLikeName(String master_name, String value, Integer pageIndex, Integer singleRows) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Master> masters = masterDao.selectMasterLikeName(master_name,value,(pageIndex-1)*singleRows,singleRows);
        Integer i=masterDao.countLikeName(value);
        map.put("total",i);
        map.put("rows",masters);

        return map;
    }

    @Override
    public void addMasters(List<Master> masters) {
        masterDao.insertBatch(masters);
    }

}
