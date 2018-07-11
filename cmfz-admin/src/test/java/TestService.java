import com.baizhi.cmfz.entity.*;
import com.baizhi.cmfz.service.*;
import com.baizhi.cmfz.util.UUIDUtils;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/5 17:01
 */
public class TestService {
/**
 * @Description 方法的作用
 * @Author Administrator
 * @Time 2018/7/5 17:01
 * @Param 参数的作用
 * @Exception 抛出的异常
 */

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuService menuService = (MenuService) ctx.getBean("menuServiceImpl");
        List<Menu> menus = menuService.querySonMenu();

        for (Menu menu: menus) {
            System.out.println(menu);
        }

    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureService p = (PictureService) ctx.getBean("pictureServiceImpl");
      /* Picture picture = new Picture();
       picture.setPicture_path("6.jpg");
       picture.setPicture_description("六张图");
       picture.setPicture_status(0);
       p.addPicture(picture);
        System.out.println(picture);*/
        Map<String, Object> map = p.queryPictureByPage(1, 2);
        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry);
        }
    }

    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureService p = (PictureService) ctx.getBean("pictureServiceImpl");
        Picture picture= p.qureyPictureById("1111");
        picture.setPicture_description("四张图");
        p.modifyPicture(picture);
    }

    @Test
    public void test4(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerService managerService = (ManagerService) ctx.getBean("managerServiceImpl");

        Manager manager = managerService.queryManagerByName("22", "333");

        System.out.println(manager);

    }

    @Test
    public void test5(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        MasterService masterService = (MasterService) ctx.getBean("masterServiceImpl");

        List<Master> masters = masterService.queryAllMaster();

        for (Master master : masters) {
            System.out.println(master);
        }
    }

    @Test
    public void test6(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ArticleService articleService = (ArticleService) ctx.getBean("articleServiceImpl");

        Article article = new Article(1,"测试文章",1,"测试测试测试",null,null);
        int i = articleService.addArticle(article);
        System.out.println(article.toString()+i);

    }

    @Test
    public void test7(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        LogService logService = (LogService) ctx.getBean("logServiceImpl");

        Map<String, Object> map = logService.queryLogsByPage(1, 2);

        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry);
        }

    }

}
