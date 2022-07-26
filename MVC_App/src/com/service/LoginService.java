package com.service;

import com.bean.Login;
import com.dao.LoginDao;

public class LoginService {
	
	public String createLoginDetails(Login login) {
		
		LoginDao ld = new LoginDao();
		StringBuffer sb = new StringBuffer(login.getPassword());
		//sb.reverse();					//1234			4321	2143
		login.setPassword(sb.reverse().toString());		// convert password in reverse order. 
		
		if(ld.createLoginDetails(login)>0) {
			return "Account created";
		}else {
			return "Account didn't create";
		}
		
	
	}
	
	public String checkLoginDetails(Login login) {
		LoginDao ld = new LoginDao();
		StringBuffer sb = new StringBuffer(login.getPassword());
		//sb.reverse();					//1234			4321	2143
		login.setPassword(sb.reverse().toString());		// convert password in reverse order. 
		if(ld.checkLoginDetail(login)>0) {
			return "success";
		}else {
			return "failure";
		}
		
	
	}
	

}
