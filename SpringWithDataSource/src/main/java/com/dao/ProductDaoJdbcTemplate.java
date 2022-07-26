package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;


import com.bean.Product;

@Repository
public class ProductDaoJdbcTemplate {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int storeProduct(Product product) {
		
		try {
			return jdbcTemplate.update("insert into product values(?,?,?)",product.getPid(),product.getPname(),product.getPrice());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
		
	}
	
	public List<Product> getAllProduct() {
        try {
            MyRowMapper mrp = new MyRowMapper();
            return jdbcTemplate.query("select * from product", mrp);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

class MyRowMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Product p = new Product();
        p.setPid(rs.getInt(1));
        p.setPname(rs.getString(2));
        p.setPrice(rs.getFloat(3));
        return p;
    }    
  }


public int updateProduct(Product product) {
    try {
return jdbcTemplate.update("update product p set p.price = ? where p.pid = ?", product.getPrice(),product.getPid());
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
    return 0;
    }
}

public int deleteProduct(Product product) {
    try {
return jdbcTemplate.update("delete from product where pid = ?", product.getPid());
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
    return 0;
    }
}
}
