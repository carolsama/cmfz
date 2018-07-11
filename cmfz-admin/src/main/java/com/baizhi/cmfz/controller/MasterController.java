package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.util.UUIDUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description 上师controller
 * @Author Administrator
 * @Time 2018/7/9 10:01
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;


    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String ,Object> showAllByPage(Integer page ,Integer rows){

        return masterService.queryMasterByPage(page,rows);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Master> queryAllMaster(){
        List<Master> masters = masterService.queryAllMaster();
        return masters;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addMaster(String master_name,String master_summary, MultipartFile master_photo, HttpServletRequest request)throws IOException{

        String realPath = request.getRealPath("");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";
        String oldName=master_photo.getOriginalFilename();
        String suffix=oldName.substring(oldName.lastIndexOf("."));
        String uuidName= UUIDUtils.getUUID();
        master_photo.transferTo(new File(uploadPath+"/"+uuidName+suffix));

        String photo_path = uuidName + suffix;
        Master mas = new Master(null,master_name,photo_path,master_summary);
        if(masterService.addMaster(mas)!=0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String modifyMaster(Integer master_id,String master_summary){

        System.out.println(master_id);
        System.out.println(master_summary);

        int result = masterService.modifyMaster(master_id, master_summary);

        if(result!=0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/addBatch")
    @ResponseBody
    public String addBatch(MultipartFile masterFile){

        try {
            ImportParams importParams = new ImportParams();

            List<Master> masters = ExcelImportUtil.importExcel(masterFile.getInputStream(),Master.class,importParams);

            for (Master master : masters) {
                System.out.println(master);
            }
            masterService.addMasters(masters);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "success";
    }

}
