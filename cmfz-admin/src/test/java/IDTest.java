import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/11 22:19
 */
public class IDTest {


    @Test
    public void test1(){
        Integer v = Integer.valueOf((int) (Math.random() * 1000000));

        System.out.println(v);


    }

    @Test
    public void m2(){
        Md5Hash md5Hash=new Md5Hash("root","456456",1024);
        System.out.println(md5Hash);

    }

    @Test
    public void m3(){
        Md5Hash md5Hash=new Md5Hash("hr","789789",1024);
        System.out.println(md5Hash);

    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");


        ManagerService managerServiceImp = (ManagerService) classPathXmlApplicationContext.getBean("managerServiceImpl");

//        List<SysRole> roles = managerServiceImp.queryRolesByMgrName("hr");
//
//        for (SysRole role : roles) {
//            System.out.println(role);
//        }

//        ManagerDao managerDao = (ManagerDao) classPathXmlApplicationContext.getBean("managerDao");
//
//        List<SysRole> roles = managerDao.selectRolesByMgrName("hr");
//
//        for (SysRole role : roles) {
//            System.out.println(role);
//        }

        List<SysPermission> hr = managerServiceImp.queryResourceByMgrName("hr");

        for (SysPermission sysPermission : hr) {
            System.out.println(sysPermission);
        }

    }

}
