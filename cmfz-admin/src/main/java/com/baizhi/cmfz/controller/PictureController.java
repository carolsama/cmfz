package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.util.UUIDUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 轮播图controller
 * @Author Administrator
 * @Time 2018/7/6 10:19
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

   @Autowired
   private PictureService pictureService;
    /**
     * @Description 添加轮播图
     * @Author Administrator
     * @Time 2018/7/6 10:19
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/add")
    @ResponseBody
    public String addPicture(String picture_path,String picture_description,
                             Integer picture_status,MultipartFile picFile,HttpServletRequest request)throws IOException{

        String realPath = request.getRealPath("");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";

        String oldName=picFile.getOriginalFilename();
        String suffix=oldName.substring(oldName.lastIndexOf("."));

        String uuidName= UUIDUtils.getUUID();

        picFile.transferTo(new File(uploadPath+"/"+uuidName+suffix));

        Picture picture = new Picture();
        picture.setPicture_path(uuidName+suffix);
        picture.setPicture_description(picture_description);
        picture.setPicture_status(picture_status);
        pictureService.addPicture(picture);


        return "success";
    }

    /**
     * @Description 查找轮播图
     * @Author Administrator
     * @Time 2018/7/6 10:19
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/select")
    @ResponseBody
    public String queryPicture(String picture_id){

        if(pictureService.qureyPictureById(picture_id)!=null){
            return "success";
        }
        return "error";
    }

    /**
     * @Description 修改轮播图
     * @Author Administrator
     * @Time 2018/7/6 10:19
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/update")
    @ResponseBody
    public String modifyPicture(String picture_id,String picture_path,String picture_description,Integer picture_status){
        Picture picture = new Picture();
        picture.setPicture_id(picture_id);
        picture.setPicture_path(picture_path);
        picture.setPicture_description(picture_description);
        picture.setPicture_status(picture_status);
        if(pictureService.modifyPicture(picture)!=0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/all")
    @ResponseBody
    public Map<String,Object> queryPictureByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        return pictureService.queryPictureByPage(nowPage,pageSize);
    }

}
