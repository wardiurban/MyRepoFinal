package com.main;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Product;
import com.service.ProductService;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//	    ProductService ps = (ProductService)ac.getBean("productService");
//	    Product p = (Product)ac.getBean("product");
//	    p.setPid(100);
//	    p.setPname("Tv");
//	    p.setPrice(58000);
//	    String result = ps.storeProduct(p);
//	    System.out.println(result);
	    
//	    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//	    ProductService ps = (ProductService)ac.getBean("productService");
//	    Product p = (Product)ac.getBean("product");
//	    p.setPrice(53000);
//	    p.setPid(100);
//	    String result = ps.updateProduct(p);
//	    System.out.println(result);
	    
//	    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//	    ProductService ps = (ProductService)ac.getBean("productService");
//	    Product p = (Product)ac.getBean("product");
//	    p.setPid(3);
//	    String result = ps.deleteProduct(p);
//	    System.out.println(result);
	    
//	    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//	    ProductService ps = (ProductService)ac.getBean("productService");
//		List<Product> listOfProduct = ps.getAllProduct();
//		System.out.println(listOfProduct.size());
//	    for(Product p : listOfProduct) {
//	        System.out.println(p);            // it will call toString method to display records 
//	    }
		
//	    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//	    ProductService ps = (ProductService)ac.getBean("productService");
//	    Product p =(Product)ac.getBean("product");
//	    p.setPid(101);
//	    p.setPname("Computer");
//	    p.setPrice(34000);
//	    String result=ps.storeProduct(p);
//	    System.out.println(result);
	    
//	    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//	    ProductService ps = (ProductService)ac.getBean("productService");
//	    List<Product> listOfProduct = ps.getAllProductUsingJdbcTemplate();
//	    for(Product p : listOfProduct) {
//	        System.out.println(p);
//	}
	    
//	    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//	    ProductService ps = (ProductService)ac.getBean("productService");
//	    Product p = (Product)ac.getBean("product");
//	    p.setPrice(54000);
//	    p.setPid(100);
//	    String result = ps.updateProduct(p);
//	    System.out.println(result);
//	}
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	    ProductService ps = (ProductService)ac.getBean("productService");
	    Product p = (Product)ac.getBean("product");
	    p.setPid(100);
	    String result = ps.deleteProduct(p);
	    System.out.println(result);
	} 
}
