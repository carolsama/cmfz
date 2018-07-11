import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/4 16:02
 */
public class TestDao {
/**
 * @Description 方法的作用
 * @Author Administrator
 * @Time 2018/7/4 16:02
 * @Param 参数的作用
 * @Exception 抛出的异常
 */
        public static void main(String[] args) {

//                ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//                PictureDao pictureDao =  (PictureDao) ctx.getBean("pictureDao");
//                List<Picture> pictures = pictureDao.selectPictureByPage(0,3);
//                for(Picture picture:pictures){
//                        System.out.println(picture);
//                }

//                ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//                PictureService p = (PictureService) ctx.getBean("pictureServiceImpl");
//                Map<String, Object> map = p.queryPictureByPage(1, 3);
//                for (String s : map.keySet()) {
//                        System.out.println(map.get(s));
//                }

//                ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//                PictureDao pictureDao =  (PictureDao) ctx.getBean("pictureDao");
//                Picture picture = new Picture();
//                picture.setPicture_id("222");
//                picture.setPicture_path("5.jpg");
//                picture.setPicture_description("五张图");
//                picture.setPicture_status(1);
//                pictureDao.insertPicture(picture);
//                System.out.println(picture);


                ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
                LogDao logDao = (LogDao) ctx.getBean("logDao");
                List<Log> logs = logDao.selectAllLogsByPage(0, 1);
            for (Log log : logs) {
                System.out.println(log);
            }
        }

}
