package com.peng.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.Dao.AddBookDao;

@Service("addBookService")
public class AddBookService {
	
	@Autowired
	private AddBookDao addBookDao;
	
	public void addbook(String bookname,int stocks,int price){
		addBookDao.addbook(bookname, stocks, price);
	}
	
	public void updatebook(String bookname,int price){
		addBookDao.updateprice(bookname, price);
	}
}
