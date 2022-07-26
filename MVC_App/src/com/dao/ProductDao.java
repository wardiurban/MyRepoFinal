package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Product;

public class ProductDao {
	public int storeProduct(Product product) {
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
				session.save(product);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public int updateProduct(Product product) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		Product p =session.get(Product.class, product.getPid());
		if(p==null) {
			return 0;
		}else {
			tran.begin();
				p.setPrice(product.getPrice());
				session.update(p);     // update the product 
			tran.commit();
			return 1;
		}
}
	
	public Product findProductById(int pid) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Product p =session.get(Product.class, pid);
		return p;
	}
	
	public int deleteProduct(int pid) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		Product p =session.get(Product.class, pid);
		if(p==null) {
			return 0;
		}else {
			tran.begin();
				session.delete(p);    // delete the product 
			tran.commit();
			return 1;
		}
}
	
	public List<Product> getAllProduct() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select p from Product p order by p.price desc");
		List<Product> listOfProduct = qry.list();
		return listOfProduct;
	}

}
