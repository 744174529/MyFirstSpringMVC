package com.peng.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.peng.Exception.BookStockException;
import com.peng.Exception.PersonMoneyException;

@Repository("buyBookDao")
public class BuyBookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public void delBook(String bookname,int buynumbers){
		String sql = "select stocks from book where name=?";
		int stocks = jdbcTemplate.queryForObject(sql, Integer.class,bookname);
		if(stocks<buynumbers){
			throw new BookStockException("库存不足");
		}
		String sql2 = "update book set stocks=stocks-? where name=?";
		jdbcTemplate.update(sql2,buynumbers,bookname);
	} 
	
	public void spendMoney(String personname,String bookname,int buynumbers){
		String sql = "select price from book where name=?";
		int bookprice = jdbcTemplate.queryForObject(sql, Integer.class, bookname);
		int price = bookprice*buynumbers;
		String sql2 = "select money from person where name=?";
		int money = jdbcTemplate.queryForObject(sql2, Integer.class, personname);
		if(money<price){
			throw new PersonMoneyException("余额");
		}
		String sql3 = "update person set money=money-? where name=?";
		jdbcTemplate.update(sql3,price,personname);
	}
	
	public void getBook(String personname,int buynumbers){
		String sql="update person set booknumbers=booknumbers+? where name=?";
		jdbcTemplate.update(sql,buynumbers,personname);
	}
}
