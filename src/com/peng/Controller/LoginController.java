package com.peng.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.peng.Service.LoginService;

@Controller
public class LoginController {
	
	private LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		loginService = (LoginService)context.getBean("loginService");
		
		HttpSession session = request.getSession();
		
		ModelAndView andView = new ModelAndView();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		int flag = loginService.login(name, password);
		if(flag==0){
			andView.addObject("Error","The user is not exist");
			andView.setViewName("login");
		}else if(flag==1){
			andView.addObject("Error","The password is error");
			andView.setViewName("login");
		}else{
			andView.addObject("name",name);
			session.setAttribute("name", name);
			andView.setViewName("buyBook");
		}
		return andView;
	}
}
