package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "signIn",method = RequestMethod.POST)
	public ModelAndView signInDetails(HttpServletRequest req, Login ll) {		// di for httpservletrequest and login also
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ll.setEmail(email);
		ll.setPassword(password);
		
		String result = loginService.signIn(ll);
		
		ModelAndView mav = new ModelAndView();
		if(result.equals("success")) {
			mav.setViewName("success.jsp");
		}else {
			mav.setViewName("failure.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value = "signUp",method = RequestMethod.POST)
	public ModelAndView signUpDetails(HttpServletRequest req, Login ll) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ll.setEmail(email);
		ll.setPassword(password);
		
		String result = loginService.signUp(ll);
		ModelAndView mav = new ModelAndView();
			mav.addObject("msg", result);                          // request.setAttribute("msg",result);
		mav.setViewName("login.jsp");
		return mav;
	}
}