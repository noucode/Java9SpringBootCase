package com.bell.nouko.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


public class ImageThumbnailForm 
{
    private Long productId;
    private MultipartFile formfile;
	private Integer position;
	private String imagePath ;
	private String thumbnailPath ;
	private String sourceview ;

	
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	
	public String getSourceview() {
		return sourceview;
	}

	public void setSourceview(String sourceview) {
		this.sourceview = sourceview;
	}

    
    
    public ImageThumbnailForm() {
    }
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public MultipartFile getFormfile() {
		return formfile;
	}
	public void setFormfile(MultipartFile formfile) {
		this.formfile = formfile;
	}
	
	
	public void reset()     
	{
	    productId = null;
	    formfile = null;
	}    

}
