package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;
import com.dao.ProductDaoJdbcTemplate;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao; //pull the object from container
	
	@Autowired
	ProductDaoJdbcTemplate productDaoJdbcTemplate;
	
	public String storeProduct(Product product) {
        if(product.getPrice()<1000) {
            return "Product price must be > 1000";
        }else if(productDao.storeProduct(product)>0) {
            return "Product details stored successfully";
        }else {
            return "Product didn't store";
        }
    }
	
	
	
	public String storeProductUsingJdbcTemplate(Product product) {
        if(productDaoJdbcTemplate.storeProduct(product)>0) {
            return "Product details stored successfully";
        }else {
            return "Product didn't store";
        }
    }
	
//	public String updateProduct(Product product) {
//		if(productDao.updateProduct(product)>0) {
//			return "Record updated successfully";
//		}else {
//			return "Record not present";
//		}
//	}
	
//	public String deleteProduct(Product product) {
//		if(productDao.deleteProduct(product)>0) {
//			return "Record deleted successfully";
//		}else {
//			return "Record not present";
//		}
//	}
	
//	public List<Product> getAllProduct(Product product) {
//		return productDao.findAllProduct(product);
//	}
	
	public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }


	public List<Product> getAllProductUsingJdbcTemplate() {
        return productDaoJdbcTemplate.getAllProduct();
    }
	
	public String updateProduct(Product product) {
	if(productDaoJdbcTemplate.updateProduct(product)>0) {
		return "Record updated successfully";
	}else {
		return "Record not present";
	}
  }
	
	public String deleteProduct(Product product) {
		if(productDaoJdbcTemplate.deleteProduct(product)>0) {
			return "Record deleted successfully";
		}else {
			return "Record not present";
		}
	  }
	
}
