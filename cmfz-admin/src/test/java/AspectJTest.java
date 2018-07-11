import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import com.baizhi.cmfz.service.LogServiceImpl;
import com.baizhi.cmfz.util.AspectJAdvice;
import com.baizhi.cmfz.util.UUIDUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 类的作用
 * @Author Administrator
 * @Time 2018/7/10 10:24
 */

public class AspectJTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        LogService logService = (LogService) ctx.getBean("logServiceImpl");
        Log log = new Log(UUIDUtils.getUUID(),"22",null,"carousel","增加","啊啊啊","成功");
        int i = logService.addLog(log);
        System.out.println(i);
        System.out.println(log.toString());
    }
}
