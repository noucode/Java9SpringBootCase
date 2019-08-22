package com.nouko.dao;

import java.util.List;
import com.nouko.domain.ImageThumbnail;


public interface ImageThumbnailJdbcDao 
{	
	public  List<ImageThumbnail> findProductImages(String query)   ;
    public void updateImageThumbnailParameterized(String sql, ImageThumbnail imageThumbnail) ;
	public  List<String> findImageLocations(String query)  ;
}

