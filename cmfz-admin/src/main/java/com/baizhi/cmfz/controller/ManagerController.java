package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Description 管理员controller层
 * @Author Administrator
 * @Time 2018/7/4 17:19
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerservice;

    /**
     * @Description 管理员登录
     * @Author Administrator
     * @Time 2018/7/4 17:19
     * @Param 参数的作用
     * @Exception 抛出的异常
     */
    @RequestMapping("/login")
    public String mgrLogin(String mgr_name, String mgr_pwd, String cbx,
                           String vcode , HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {


        String code = (String) session.getAttribute("code");

        //System.out.println(cbx);


        if (code.equals(vcode)){
            Manager mgr = managerservice.queryManagerByName(mgr_name, mgr_pwd);
            //System.out.println(mgr);
            if (mgr!=null){
                if(cbx!=null){
                    Cookie cookie = new Cookie("username", URLEncoder.encode(mgr_name,"utf-8"));
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }else{
                    Cookie cookie = new Cookie("username", URLEncoder.encode(mgr_name,"utf-8"));
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }

                session.setAttribute("mgr", mgr);
                return "forward:/main/main.jsp";
            }

            return "redirect:/login.jsp";
        }

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

        if(managerservice.modifyManager(manager)!=0){
            return "forward:/main/main.jsp";
        }
        return "error";
    }

}
