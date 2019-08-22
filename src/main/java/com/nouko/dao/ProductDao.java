package com.nouko.dao;

import java.util.List;
import java.util.Optional;
import com.nouko.domain.Product;

public interface ProductDao 
{	
	public Optional<Product> getProductByPrimaryKey(Long productId, String sql);
	public void saveProduct(Product product, String sql);
	public List <Product> getQueryListProducts(String QueryString) ;
	public void updateProduct(Product product, String sql);

}
