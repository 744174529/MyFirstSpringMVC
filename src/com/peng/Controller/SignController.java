package com.peng.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peng.Service.SignService;

@Controller
public class SignController {
	
	private SignService signService;
	
	@RequestMapping(value="/sign",method=RequestMethod.POST)
	public String sign(HttpServletRequest request,HttpServletResponse response){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		signService = (SignService)context.getBean("signService");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		int flag = signService.sign(name, password);
		if(flag==1){
			return "success";
		}else{
			return "sign";
		}
	}
}
