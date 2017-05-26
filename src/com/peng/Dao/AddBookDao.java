package com.peng.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.peng.Bean.Book;
import com.peng.Bean.Student;
import com.peng.Exception.BookAddException;

@Repository("addBookDao")
public class AddBookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addbook(String bookname,int stocks,int price){
		String sql="select name from book where name = ?";
		RowMapper<Book> mapper = new BeanPropertyRowMapper<Book>(Book.class);
		List<Book> listbook = jdbcTemplate.query(sql, mapper, bookname);
		System.out.println(listbook.size());
		if(listbook.size()==0){
			String sql2 = "insert into book(name,stocks,price) value(?,?,?)";
			jdbcTemplate.update(sql2,bookname,stocks,price);
		}else{
			String sql3="update book set stocks=stocks+? where name=?";
			jdbcTemplate.update(sql3,stocks,bookname);
		}
	}
	
	public void updateprice(String bookname,int price){
		String sql = "update book set price=? where name=?";
		jdbcTemplate.update(sql,price,bookname);
	}
	
}
