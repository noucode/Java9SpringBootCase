package com.bell.nouko.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bell.nouko.domain.ImageThumbnail;


@Repository(value = "imageThumbnailJdbcDao")
public class ImageThumbnailJdbcDaoImpl implements ImageThumbnailJdbcDao
{
    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    								       
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
	
    public ImageThumbnailJdbcDaoImpl () {
    }
    
		
	public  List<ImageThumbnail> findProductImages(String query)  
	{	       
		List <ImageThumbnail> imageList = new ArrayList<ImageThumbnail>();	    
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		List<Map<String,Object>>rows = namedParameterJdbcTemplate.queryForList(query, namedParameters);
		for (Map<String, Object> row : rows) 
		{
			ImageThumbnail image = new ImageThumbnail() ;
        	image.setProductId( Long.parseLong( (row.get("PRODUCT_ID")).toString() ) );
        	image.setImagePath((String) row.get("IMAGEPATH"));  
        	imageList.add(image);
		}
			    
	    return imageList ;
    }
	
	
	public  List<String> findImageLocations(String query)  
	{	
		List<String> imageLocations =  new ArrayList<String>();
		List <ImageThumbnail> imageList = findProductImages(query) ;
		
		for (int i = 0;  i < imageList.size(); i++) 
		{
			imageLocations.add(imageList.get(i).getImagePath()) ;
		}

	    return imageLocations ;
	}
	
	
    public void updateImageThumbnailParameterized(String sql, ImageThumbnail imageThumbnail) 
    {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(imageThumbnail);
		namedParameterJdbcTemplate.update(sql, namedParameters);
    }


   
    public ImageThumbnail findImageThumbnailByProductNo(Long productId, Integer position, String sql) 
    {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource() ;
      	namedParameters.addValue("productId", productId);
      	namedParameters.addValue("position", position);

		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, BeanPropertyRowMapper.newInstance(ImageThumbnail.class)) ;
    }

    
    public String getImageThumbnailPath(Long productId, Integer position, String sql) 
    {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource() ;
      	namedParameters.addValue("productId", productId);
      	namedParameters.addValue("position", position);

    	return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    
	
	
	
}

