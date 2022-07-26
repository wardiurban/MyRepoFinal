package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Login;
import com.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Login ll = new Login();
		ll.setEmail(email);
		ll.setPassword(password);
		
		LoginService ls = new LoginService();
		String result = ls.checkLoginDetails(ll);
		RequestDispatcher rd1 = request.getRequestDispatcher("Home.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
		if(result.equals("success")) {
				rd1.forward(request, response);
		}else {
			pw.println("Failure try once again");
			rd2.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Login ll = new Login();
		ll.setEmail(email);
		ll.setPassword(password);
		
		LoginService ls = new LoginService();
		String result = ls.createLoginDetails(ll);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		pw.println(result);
		rd.include(request, response);
		
	}

}
