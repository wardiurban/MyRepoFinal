package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	LoginDao loginDao;
	
	public String signIn(Login ll) {
		if(loginDao.signIn(ll).size() > 0) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	public String signUp(Login ll) {
		if(loginDao.signUp(ll)>0){
			return "Account created successfully";
		}else {
			return "Account didn't create";
		}
	}
}