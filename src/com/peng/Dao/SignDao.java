package com.peng.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.peng.Bean.Student;

@Repository("signDao")
public class SignDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int sign(String name,String password){
		int flag = 0;
		String sql = "select name from person where name = ?";
		RowMapper<Student> mapper = new BeanPropertyRowMapper<Student>(Student.class);
		List<Student> liststu = jdbcTemplate.query(sql, mapper, name);
		if(liststu.size()==0){
			String sql2="insert into person(name,password) value(?,?)";
			jdbcTemplate.update(sql2,name,password);
			flag = 1;
		}else{
			flag = 0;
		}
		return flag;
	}
}
