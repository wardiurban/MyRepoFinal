package com.service;

import java.util.Iterator;
import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {
	
    ProductDao pd = new ProductDao();
	
	public String storeProduct(Product product) {
		if(product.getPrice()<1000) {
			return "Price must be > 1000";
		}else if(pd.storeProduct(product)>0) {
			return "Product stored successfully";
		}else {
			return "Product didn't store";
		}
	}
	
	public List<Product> getAllProduct() {
		List<Product> listOfProdut = pd.getAllProduct();
		Iterator<Product> li = listOfProdut.iterator();
		while(li.hasNext()) {
			Product p = li.next();
			float discountAmount = p.getPrice()*0.10f;		// 120
			p.setPrice(p.getPrice()-discountAmount);
		}
		return listOfProdut;
	}
	
	public String updateProductPrice(Product product) {
		
		Product p = pd.findProductById(product.getPid());
		if(p==null) {
			return "Product not present";
		}else if(p.getPrice()==product.getPrice()) {
			return "Price is same didn't update";
		}else if(pd.updateProduct(product)>0) {
			return "Product updated successfully";
		}else {
			return "Product didn't update";
		}
}

public String deleteProductUsingId(int pid) {
		if(pd.deleteProduct(pid)>0) {
			return "Produt deleted successfully";
		}else {
			return "Product not present";
		}
}

}
