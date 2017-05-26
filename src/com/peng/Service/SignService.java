package com.peng.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.Dao.SignDao;

@Service("signService")
public class SignService {
	
	@Autowired
	private SignDao signDao;
	
	public int sign(String name,String password){
		int flag = signDao.sign(name, password);
		return flag;
	}
}
