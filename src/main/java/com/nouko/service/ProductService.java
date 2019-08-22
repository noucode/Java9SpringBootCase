package com.nouko.service;

import java.util.List;
import java.util.Optional;
import com.nouko.domain.ImageThumbnail;
import com.nouko.domain.Product;


public interface ProductService {
	
	public Optional<Product> readProductByPrimaryKey(Long productId, String sql)	throws Exception;
	public void createProduct(Product product, String sql)	throws Exception;
	public List <Product> getListProducts(String QueryString)	throws Exception ;
	public List<ImageThumbnail> findImageList(String query)	throws Exception ;	
	public List<Long> findProductIdList(String query) 	throws Exception ;
	public void updateImageParameterized(ImageThumbnail imageThumbnail, String sql)	throws Exception;
	public void addImageToProduct(Long productId, String imagePath, String sqlRead, String sqlUpdate)	throws Exception;
	public List<String> findImageLocations(String query)	throws Exception;
    
}
