package com.peng.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

	@RequestMapping("/controllersign")
	public String sign(){
		return "sign";
	}
	
	@RequestMapping("/controllerlogin")
	public String login(){
		return "login";
	}
}
