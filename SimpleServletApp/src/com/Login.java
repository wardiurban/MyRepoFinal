package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd1 = request.getRequestDispatcher("Home");
		RequestDispatcher rd2 = request.getRequestDispatcher("Login.html");
		response.setContentType("text/html");
		if(email.equals("azwardi@maybank") && password.equals("123")) {
			rd1.forward(request, response);
			pw.println("successful login with get method");		
		}else {
			rd2.include(request, response);
			pw.println("failure try again with get method");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd1 = request.getRequestDispatcher("Home");
		RequestDispatcher rd2 = request.getRequestDispatcher("Login.html");//setting response in html
		response.setContentType("text/html");
		if(email.equals("azwardi@maybank") && password.equals("123")) {
			rd1.forward(request, response);
			pw.println("successful login with post method");		
		}else {
			pw.println("failure try again with post method");
			rd2.include(request, response);
		}
	}
		
	}


