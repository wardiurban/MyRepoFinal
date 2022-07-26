package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductService;

/**
 * Servlet implementation class ProductOperationController
 */
public class ProductOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductOperationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		ProductService ps = new ProductService();
		String result = ps.deleteProductUsingId(pid);
		pw.println(result);
		pw.println();
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		float price = Float.parseFloat(request.getParameter("price"));
		Product pp = new Product();
		pp.setPid(pid);
		pp.setPrice(price);
		ProductService ps = new ProductService();
		String result = ps.updateProductPrice(pp);
		pw.println(result);
		pw.println();
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.include(request, response);
	}

}
