package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/6 11:30
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;


    /**
     * @Description 添加图片
     * @Author Administrator
     * @Time 2018/7/6 11:30
     * @Param 参数的作用
     * @Exception 抛出的异常
     */

    public int addPicture(Picture picture) {
        String id = UUIDUtils.getUUID();
        picture.setPicture_id(id);
        return pictureDao.insertPicture(picture);
    }

    /**
     * @Description 删除图片
     * @Author Administrator
     * @Time 2018/7/6 11:30
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int dropPicture(String picture_id) {
        return pictureDao.deletePicture(picture_id);
    }

    /**
     * @Description 修改图片
     * @Author Administrator
     * @Time 2018/7/6 11:30
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int modifyPicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    /**
     * @Description 查找图片
     * @Author Administrator
     * @Time 2018/7/6 11:30
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Picture qureyPictureById(String picture_id) {
        return pictureDao.selectPictureById(picture_id);
    }

    /**
     * @Description 分页查询
     * @Author Administrator
     * @Time 2018/7/6 11:30
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryPictureByPage(Integer pageIndex, Integer singleRows) {
        Map<String, Object> map = new HashMap<String,Object>();
        List<Picture> pictures = pictureDao.selectPictureByPage((pageIndex-1)*singleRows,singleRows);
        Integer i = pictureDao.countPicture();
        map.put("total",i);
        map.put("rows",pictures);
        return map;
    }

}
