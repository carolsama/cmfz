package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Security;

/**
 * @Description 管理员controller层
 * @Author Administrator
 * @Time 2018/7/4 17:19
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

     /**
     * @Description 管理员登录
     * @Author Administrator
     * @Time 2018/7/4 17:19
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/login")
    public String mgrLogin(String mgr_name, String mgr_pwd, boolean rememberMe,
                           String vcode , HttpSession session) throws UnsupportedEncodingException {

        String code = (String) session.getAttribute("code");

        Subject subject = SecurityUtils.getSubject();


        if(code.equals(vcode)){
            try{
                subject.login(new UsernamePasswordToken(mgr_name,mgr_pwd,rememberMe));
                System.out.println(subject.hasRole("root"));
                return "redirect:/main/main.jsp";
            }catch (UnknownAccountException e){
                e.printStackTrace();
                return "redirect:/login.jsp";
            }catch (IncorrectCredentialsException ice){
                ice.printStackTrace();
                return "redirect:/login.jsp";
            }catch (AuthenticationException ae){
                ae.printStackTrace();
                return "redirect:/login.jsp";
            }


        }

//        if (code.equals(vcode)){
//            Manager mgr = managerservice.queryManagerByName(mgr_name, mgr_pwd);
//            //System.out.println(mgr);
//            if (mgr!=null){
//                if(cbx!=null){
//                    Cookie cookie = new Cookie("username", URLEncoder.encode(mgr_name,"utf-8"));
//                    cookie.setPath("/");
//                    response.addCookie(cookie);
//                }else{
//                    Cookie cookie = new Cookie("username", URLEncoder.encode(mgr_name,"utf-8"));
//                    cookie.setPath("/");
//                    cookie.setMaxAge(0);
//                    response.addCookie(cookie);
//                }
//
//                session.setAttribute("mgr", mgr);
//                return "forward:/main/main.jsp";
//            }
//
//            return "redirect:/login.jsp";
//        }

        return "redirect:/login.jsp";

    }

    /**
     * @Description 管理员登出
     * @Author Administrator
     * @Time 2018/7/4 17:19
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/exit")
    public String managerExit(HttpSession session){
        Manager manager = (Manager) session.getAttribute("mgr");
        if(manager!=null){
            session.setAttribute("mgr",null);
        }
        return "redirect:/login.jsp";
    }

    /**
     * @Description 修改管理员密码
     * @Author Administrator
     * @Time 2018/7/4 17:19
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateManagerPwd(String mgr_name,String mgr_pwd){
        Manager manager = new Manager();
        manager.setMgr_name(mgr_name);
        manager.setMgr_pwd(mgr_pwd);

        if(managerService.modifyManager(manager)!=0){
            return "forward:/main/main.jsp";
        }
        return "error";
    }

}
