package com.peng.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peng.Service.AddBookService;

@Controller
public class AddBookController {

	private AddBookService addBookService;

	
	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	public String addbook(HttpServletRequest request,HttpServletResponse response){
		String bookname = request.getParameter("bookname");
		String str_stocks = request.getParameter("stocks");
		String str_price = request.getParameter("price");
		int stocks = Integer.parseInt(str_stocks);
		int price = Integer.parseInt(str_price);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		addBookService = (AddBookService) context.getBean("addBookService");
		
		addBookService.addbook(bookname, stocks, price);
		return "bookshop";
	}
	
	@RequestMapping(value="/updatebook",method=RequestMethod.POST)
	public String updatebook(HttpServletRequest request,HttpServletResponse response){
		String bookname = request.getParameter("bookname");
		String str_price = request.getParameter("price");
		int price = Integer.parseInt(str_price);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		addBookService = (AddBookService) context.getBean("addBookService");
		addBookService.updatebook(bookname, price);
		return "bookshop";
	}
}
