package com.peng.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peng.Exception.BookStockException;
import com.peng.Exception.PersonMoneyException;
import com.peng.Service.BuyService;

@Controller
public class BuyController {
	
	private BuyService buyService;
	
	@RequestMapping(value="/buy",method=RequestMethod.POST)
	public String buy(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String personname = (String) session.getAttribute("name");
		String bookname = request.getParameter("bookname");
		String str_number = request.getParameter("number");
		int number = Integer.parseInt(str_number);
		
		try{
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			buyService = (BuyService) context.getBean("buyService");
			buyService.buybook(personname, bookname, number);
			return "success";
		}catch (BookStockException e) {
			return "BookStocksException";
		}catch(PersonMoneyException e){
			return "PersonMoneyException";
		}
		
		
	}
}
