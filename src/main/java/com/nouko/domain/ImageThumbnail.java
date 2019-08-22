package com.nouko.domain;

import java.io.Serializable;

public class ImageThumbnail  implements Serializable
{
	private static final long serialVersionUID = 1L;	

    private Long productId;
	private Integer position;
	private String imagePath ;
	private String thumbnailPath ;
	
    public ImageThumbnail() {
    }

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

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

    
}
