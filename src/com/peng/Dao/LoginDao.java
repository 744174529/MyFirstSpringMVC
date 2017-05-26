package com.peng.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.peng.Bean.Student;

@Repository("loginDao")
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int login(String name,String password){
		int flag = 0;
		String sql = "select name,password from person where name=?";
		RowMapper<Student> mapper = new BeanPropertyRowMapper<Student>(Student.class);
		List<Student> stulist = jdbcTemplate.query(sql, mapper,name);
		if(stulist.size()==0){
			flag = 0;
		}else{
			Student student = stulist.get(0);
			if(student.getName().equals(name)&&student.getPassword().equals(password)){
				flag = 2;
			}else{
				flag = 1;
			}
		}
		return flag;
	}
}
