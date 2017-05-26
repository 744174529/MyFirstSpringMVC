package com.peng.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.Dao.LoginDao;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private LoginDao dao;
	
	public int login(String name,String password){
		int flag = dao.login(name, password);
		return flag;
	}
}
