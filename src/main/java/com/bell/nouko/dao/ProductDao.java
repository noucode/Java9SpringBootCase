package com.bell.nouko.dao;

import java.util.List;
import com.bell.nouko.domain.Product;

public interface ProductDao 
{	
	public Product getProductByPrimaryKey(Long productId);
	public void saveProduct(Product product);
	public void saveOrUpdateProduct(Product product);
	public List <Product> getQueryListProducts(String QueryString) ;
	public void updateProduct(Product product);

}
