package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 轮播图dao
 * @Author Administrator
 * @Time 2018/7/6 9:38
 */
public interface PictureDao {

    public int insertPicture(Picture picture);

    public int updatePicture(Picture picture);

    public int deletePicture(@Param("picture_id") String Picture_id);

    public int countPicture();

    public Picture selectPictureById(@Param("picture_id") String picture_id);

    public List<Picture> selectPictureByPage(@Param("begin")Integer begin,@Param("end")Integer end);

}
