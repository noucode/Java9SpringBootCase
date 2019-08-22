package com.nouko.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.nouko.dao.CategoryDao;
import com.nouko.dao.ProductDao;
import com.nouko.dao.ImageThumbnailJdbcDao;
import com.nouko.dao.ProductJdbcDao;
import com.nouko.domain.ImageThumbnail;
import com.nouko.domain.Product;


@Service(value = "productService")
public class ProductServiceImpl implements ProductService
{

    @Autowired
    @Qualifier(value = "imageThumbnailJdbcDao")
	private ImageThumbnailJdbcDao imageThumbnailJdbcDao;
    
    @Autowired
    @Qualifier(value = "categoryDao")
	private CategoryDao categoryDao;

    @Autowired
    @Qualifier(value = "productDao")
	private ProductDao productDao;

    @Autowired
    @Qualifier(value = "productJdbcDao")
	private ProductJdbcDao productJdbcDao;
	
	
	@Override
	public Optional<Product> readProductByPrimaryKey(Long productId, String sql)	throws Exception
	{
	    return productDao.getProductByPrimaryKey(productId, sql);
	}
	
	    
	@Override
	public void createProduct(Product product, String sql)	throws Exception
	{				
		productDao.saveProduct(product, sql); 
	}
	
	
	@Override
	public List <Product> getListProducts(String QueryString)	throws Exception 
	{		
		return productDao.getQueryListProducts(QueryString);
	}
		
	
	@Override
	public  List<Long> findProductIdList(String query) 	throws Exception
	{		
		List <Long> myList = productJdbcDao.findProductIdList(query) ;		
        return myList ;		
	}

	@Override
	public List<ImageThumbnail> findImageList(String query)	throws Exception
	{		
        List<ImageThumbnail> imageList = imageThumbnailJdbcDao.findProductImages(query) ;         
        return imageList ;		
	}
	
	@Override
	public List<String> findImageLocations(String query)	throws Exception
	{		
		List<String> imageLocations =  imageThumbnailJdbcDao.findImageLocations(query) ;         
        return imageLocations ;		
	}
	
	
	@Override
	public void updateImageParameterized(ImageThumbnail imageThumbnail, String sql)	throws Exception
	{		
		imageThumbnailJdbcDao.updateImageThumbnailParameterized(sql, imageThumbnail) ; 
	}
	
	
	@Override
	public void addImageToProduct(Long productId, String imagePath, String sqlRead, String sqlUpdate)	throws Exception
	{
		Optional<Product> optProduct = productDao.getProductByPrimaryKey(productId, sqlRead);	
		if(optProduct.isPresent())
		{
			Product product = optProduct.get() ;
			product.getImageLocations().add(imagePath);				
			productDao.updateProduct(product, sqlUpdate);			
		}
	}
		
}

