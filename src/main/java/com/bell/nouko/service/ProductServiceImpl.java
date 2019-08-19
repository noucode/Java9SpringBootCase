package com.bell.nouko.service;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bell.nouko.dao.CategoryDao;
import com.bell.nouko.dao.ProductDao;
import com.bell.nouko.dao.ImageThumbnailJdbcDao;
import com.bell.nouko.dao.ProductJdbcDao;
import com.bell.nouko.domain.ImageThumbnail;
import com.bell.nouko.domain.Product;


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
	public Product readProductByPrimaryKey(Long productId)	throws Exception
	{
	    return productDao.getProductByPrimaryKey(productId);
	}
	
	    
	@Override
	public void createProduct(Product product)	throws Exception
	{				
		productDao.saveProduct(product); 
	}
	
	
	@Override
	public void saveOrUpdateProduct(Product product)  throws Exception
	{	
		productDao.saveOrUpdateProduct(product);
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
    public ImageThumbnail findImageByProductNo(Long productId, Integer position) 
    {
		String sql = "SELECT * FROM PRODUCTIMAGEPATH  WHERE PRODUCT_ID = :productId  AND POSITION = :position";
		return imageThumbnailJdbcDao.findImageThumbnailByProductNo(productId, position, sql) ;	
    }
    

	@Override
    public String getImagePath(Long productId, Integer position) 
    {
		String sql = "SELECT IMAGEPATH FROM PRODUCTIMAGEPATH  WHERE PRODUCT_ID = :productId  AND POSITION = :position";
		return imageThumbnailJdbcDao.getImageThumbnailPath(productId, position, sql) ;
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
	public void updateImageParameterized(ImageThumbnail imageThumbnail)	throws Exception
	{		
		String sql = "UPDATE PRODUCTIMAGEPATH SET IMAGEPATH = :imagePath  WHERE PRODUCT_ID = :productId  AND POSITION = :position ";
		imageThumbnailJdbcDao.updateImageThumbnailParameterized(sql, imageThumbnail) ; 
	}
	
	@Override
	public void addImageToProduct(Long productId, String imagePath)	throws Exception
	{
		Product product = productDao.getProductByPrimaryKey(productId);		
		product.getImageLocations().add(imagePath);				
		productDao.updateProduct(product);
	}
		
}

