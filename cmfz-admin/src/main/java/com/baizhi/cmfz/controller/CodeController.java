package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.util.ValidateCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/mgr")
public class CodeController {

	@RequestMapping("/getVcode")
	public void create(HttpSession session,HttpServletResponse response) throws IOException{
		
		ValidateCodeUtils vcode = new ValidateCodeUtils(100,30,1,10);
		
		session.setAttribute("code", vcode.getCode());
		
		vcode.write(response.getOutputStream());
		
	}
}
