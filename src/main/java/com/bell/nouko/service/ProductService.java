package com.bell.nouko.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bell.nouko.domain.ImageThumbnail;
import com.bell.nouko.domain.Product;


public interface ProductService {
	
	public Product readProductByPrimaryKey(Long productId)	throws Exception;
	public void createProduct(Product product)	throws Exception;
	public void saveOrUpdateProduct(Product product)  throws Exception;
	public List <Product> getListProducts(String QueryString)	throws Exception ;
	public List<ImageThumbnail> findImageList(String query)	throws Exception ;	
	public List<Long> findProductIdList(String query) 	throws Exception ;
    public ImageThumbnail findImageByProductNo(Long productId, Integer position) ;
    public String getImagePath(Long productId, Integer position) ;
	public void updateImageParameterized(ImageThumbnail imageThumbnail)	throws Exception;
	public void addImageToProduct(Long productId, String imagePath)	throws Exception;
	public List<String> findImageLocations(String query)	throws Exception;
    
}
