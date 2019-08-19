package com.bell.nouko.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.bell.nouko.domain.ImageThumbnail;


public interface ImageThumbnailJdbcDao 
{	
	public  List<ImageThumbnail> findProductImages(String query)   ;
    public ImageThumbnail findImageThumbnailByProductNo(Long productId, Integer position, String sql) ;
    public String getImageThumbnailPath(Long productId, Integer position, String sql) ;
    public void updateImageThumbnailParameterized(String sql, ImageThumbnail imageThumbnail) ;
	public  List<String> findImageLocations(String query)  ;

}

