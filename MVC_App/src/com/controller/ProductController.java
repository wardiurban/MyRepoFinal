package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
		ProductService ps = new ProductService();
		List<Product> listOfProduct = ps.getAllProduct();
		request.setAttribute("obj", listOfProduct);  // store listOfProject in request scope.
		RequestDispatcher rd = request.getRequestDispatcher("displayProduct.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int pid =   Integer.parseInt(request.getParameter("pid")) ;  //string to integer 
		String pname = request.getParameter("pname");
		float price = Float.parseFloat(request.getParameter("price"));
		
		Product p = new Product();
		p.setPid(pid);
		p.setPname(pname);
		p.setPrice(price);
		
		ProductService ps = new ProductService();
		String result = ps.storeProduct(p);
		pw.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.include(request, response);
		
	}

}
