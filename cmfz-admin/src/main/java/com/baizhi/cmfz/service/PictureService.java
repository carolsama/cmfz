package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * @Description 轮播图service
 * @Author Administrator
 * @Time 2018/7/6 10:22
 */
public interface PictureService {

    public int addPicture(Picture picture);

    public int dropPicture(String picture_id);

    public int modifyPicture(Picture picture);

    public Picture qureyPictureById(String picture_id);

    public Map<String, Object> queryPictureByPage(Integer begin, Integer end);


}
