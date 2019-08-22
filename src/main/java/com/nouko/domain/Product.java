package com.nouko.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;	

    private Long productId;
    private String serialNumber;
    private String prodname;
    private BigDecimal prodprice;
    private Integer stockQty;
    private String size;
    private String description;		
	private Date created;
    private List<String> imageLocations = new ArrayList<String>();
    private Integer categoryId;		
        
	public Product() {
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
	
	public BigDecimal getProdprice() {
		return prodprice;
	}
	public void setProdprice(BigDecimal prodprice) {
		this.prodprice = prodprice;
	}
		
	public Integer getStockQty() {
		return stockQty;
	}
	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}
		
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getImageLocations() {
		return imageLocations;
	}
	public void setImageLocations(List<String> imageLocations) {
		this.imageLocations = imageLocations;
	}
		
    public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public boolean equals(Object other) 
	{
		if (other == null) 			return false;

    	if (this != other) 
    	{
    		if ( !(other instanceof Product) ) 	return false; 

    		Product product = (Product) other;

    		if ( !product.getProductId().equals(this.getProductId()) ) 	return false;
    		if ( !product.getSerialNumber().equals(this.getSerialNumber()) ) 	return false;
    	}

    	return true;
	}
	
	public int hashCode() 
	{
    	int hashcode = 0;
    	if (productId != null)	hashcode = hashcode * 29 + productId.hashCode();
    	if (serialNumber != null)	hashcode = hashcode * 29 + serialNumber.hashCode();
    	
    	return hashcode;
	}
	    
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append( "Product: " );
		sb.append( "productId='" + productId + "'" );
		sb.append( ", serialNumber='" + serialNumber + "'" );
		sb.append( ", prodname='" + prodname + "'" );
		sb.append( ", prodprice='" + prodprice + "'" );
		sb.append( ", stockQty='" + stockQty + "'" );
		sb.append( ", size='" + size + "'" );
		sb.append( ", description='" + description + "'" );
		sb.append( ", created='" + created + "'" );
		
		return sb.toString();
	}
    
}
