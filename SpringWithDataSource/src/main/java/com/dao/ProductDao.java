package com.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public class ProductDao {

	@Autowired
	DataSource ds; //pull db conn from xml
	
	public int storeProduct(Product product) {
        try {
            Connection con = ds.getConnection();            // we will the get the connection. 
            PreparedStatement pstm = con.prepareStatement("insert into product values(?,?,?)");
            pstm.setInt(1, product.getPid());
            pstm.setString(2, product.getPname());
            pstm.setFloat(3, product.getPrice());
            int res = pstm.executeUpdate();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
	}
	
	public int updateProduct(Product product) {
        try {
            Connection con = ds.getConnection();            // we will the get the connection. 
            PreparedStatement pstm = con.prepareStatement("update product set price =? where pid =?");
            pstm.setFloat(1, product.getPrice());
            pstm.setInt(2, product.getPid());
            int res = pstm.executeUpdate();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
	}
	
	public int deleteProduct(Product product) {
        try {
            Connection con = ds.getConnection();            // we will the get the connection. 
            PreparedStatement pstm = con.prepareStatement("delete from product where pid =?");
            pstm.setInt(1, product.getPid());
            int res = pstm.executeUpdate();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
	}
	
//	public List<Product> findAllProduct(Product product) {
//		List<Product> listOfProd = new ArrayList<>();
//		try {
//			Connection con = ds.getConnection();            // we will the get the connection. 
//			PreparedStatement pstm = con.prepareStatement("select * from product");
//            ResultSet rs = pstm.executeQuery();
//	    while(rs.next()) {
//		//Employee emp = new Employee();
//		product.setPid(rs.getInt(1));
//		product.setPname(rs.getString(2));
//		product.setPrice(rs.getFloat(3));
//		listOfProd.add(product);
//		}
//
//		} catch(SQLIntegrityConstraintViolationException e) {
//			
//			
//		}catch (Exception e) {
//			System.out.println(e);
//		}
//		return listOfProd;
//	}
	
	public List<Product> getAllProduct() {
        List<Product> listOfProduct = new ArrayList<Product>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from product");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt(1));
                p.setPname(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                listOfProduct.add(p);
            }
            return listOfProduct;
        } catch (Exception e) {
        	System.out.println(e);
            // TODO: handle exce
        }
        return null;
    }
 }
	
