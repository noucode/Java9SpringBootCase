package com.bell.nouko.form;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;


public class ProductForm 
{
    private Long productId;
    
    @Min(100)
    private Integer categId;
    
    @NotNull
    @NotBlank
	private String serialNumber;
    
    @NotNull
    @NotBlank
    private String prodname;
    
    @NotNull
    @NotBlank
    private String prodprice  ;
    
    private String discountprice;
    private Integer stockQty;
    private String type;
    private String size;
    private String color;
    private String description;		
	private Date created;
	private Date modified;
    private List<String> imageLocations = new ArrayList<String>();
    private List<String> thumbnailLocations = new ArrayList<String>();
    private Integer quantity;
	private String sourceview ;

    
    public ProductForm() {
    }
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProdprice() {
		return prodprice;
	}
	public void setProdprice(String prodprice) {
		this.prodprice = prodprice;
	}
	public String getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(String discountprice) {
		this.discountprice = discountprice;
	}
	public Integer getStockQty() {
		return stockQty;
	}
	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public List<String> getImageLocations() {
		return imageLocations;
	}
	public void setImageLocations(List<String> imageLocations) {
		this.imageLocations = imageLocations;
	}
	public List<String> getThumbnailLocations() {
		return thumbnailLocations;
	}
	public void setThumbnailLocations(List<String> thumbnailLocations) {
		this.thumbnailLocations = thumbnailLocations;
	}
    public Integer getCategId() {
		return categId;
	}
	public void setCategId(Integer categId) {
		this.categId = categId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getSourceview() {
		return sourceview;
	}

	public void setSourceview(String sourceview) {
		this.sourceview = sourceview;
	}



	
	public void reset()     
	{
	    productId = null;
	    categId = null ;
	    serialNumber = "";
	    prodname = "" ;
	    prodprice = "" ;
	    discountprice = "";
	    stockQty = null;
	    type = "";
	    size = "";
	    color = "";
	    description = "";		
		created = null;
		modified = null;
		quantity = null ;
	}    
	
	
}
