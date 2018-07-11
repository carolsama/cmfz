package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import com.baizhi.cmfz.service.LogServiceImpl;
import com.baizhi.cmfz.service.MasterService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.lang.reflect.Method;

/**
 * @Description 额外功能类
 * @Author Administrator
 * @Time 2018/7/10 10:07
 */
@Aspect
public class AspectJAdvice {

    @Autowired
    private LogService logService;


    /**
     * 声明切入点表达式
     */

    //|| execution(* com.baizhi.cmfz.service.*.modify*(..)) || execution(* com.baizhi.cmfz.service.*.drop*(..))

    @Pointcut("execution(* com.baizhi.cmfz.service.MasterServiceImpl.addMaster(..)) || execution(* com.baizhi.cmfz.service.ArticleServiceImpl.addArticle(..)) || " +
            "execution(* com.baizhi.cmfz.service.PictureServiceImpl.addPicture(..)) || execution(* com.baizhi.cmfz.service.MasterServiceImpl.modifyMaster(..)) ||" +
            "execution(* com.baizhi.cmfz.service.PictureServiceImpl.modifyPicture(..))")
    public void pc(){
    }

    @Around("pc()")
    public Object addLogbook(ProceedingJoinPoint pjp) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        Log log = new Log();


        Manager mgr = (Manager) session.getAttribute("mgr");

        if (mgr!=null){
            log.setLogUser(mgr.getMgr_name());
        }


        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        Method method = methodSignature.getMethod();

        String methodName = method.getName();

        String action = new String();
        String resource=null;

        //setLog 增删改(操作方法)
        if(methodName.indexOf("add")!=-1){
            action = "新增";
            resource=methodName.substring(3);
        }else if (methodName.indexOf("modify")!=-1){
            action = "修改";
            resource=methodName.substring(6);
        }else if(methodName.indexOf("drop")!=-1){
            action = "删除";
            resource=methodName.substring(4);
        }else{
            action = "未知操作";
        }


        log.setLogResource(resource);
        log.setLogAction(action);

        //setLog 参数
        Object[] args = pjp.getArgs();

        String message = args[0].toString();
        log.setLogMessage(message);

        log.setLogResult("success");
        log.setLogId(UUIDUtils.getUUID());

        logService.addLog(log);


        return pjp.proceed();

    }
}
