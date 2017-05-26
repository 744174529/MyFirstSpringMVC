package com.peng.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peng.Dao.BuyBookDao;

@Service("buyService")
public class BuyService {
	
	@Autowired
	private BuyBookDao bookDao;
	
	@Transactional
	public void buybook(String personname,String bookname,int buynumbers){
		
		bookDao.delBook(bookname, buynumbers);
		bookDao.spendMoney(personname, bookname, buynumbers);
		bookDao.getBook(personname, buynumbers);
	}
}
