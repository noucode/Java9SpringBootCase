package com.nouko.domain;

import java.io.Serializable;

public class ShoppingCartLineItem implements Serializable
{
	private static final long serialVersionUID = 1L;	

    private Long shoppingCartLineItemId;	
    private Integer quantity;
    private Product product;   
    private ShoppingCart shoppingCart;
    
    public ShoppingCartLineItem() {
    }
    
	public Long getShoppingCartLineItemId() {
		return shoppingCartLineItemId;
	}
	public void setShoppingCartLineItemId(Long shoppingCartLineItemId) {
		this.shoppingCartLineItemId = shoppingCartLineItemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}   
	

	public boolean equals(Object other) 
	{
		if (other == null) 			return false;

    	if (this != other) 
    	{
    		if ( !(other instanceof ShoppingCartLineItem) ) 	return false; 

    		ShoppingCartLineItem shoppingCartLineItem = (ShoppingCartLineItem) other;

    		if ( !shoppingCartLineItem.getShoppingCartLineItemId().equals(this.getShoppingCartLineItemId()) ) 	return false;
    		if ( !shoppingCartLineItem.getQuantity().equals(this.getQuantity()) ) 	return false;
    	}

    	return true;
	}
	
	public int hashCode() 
	{
    	int hashcode = 0;
    	if (shoppingCartLineItemId != null)	hashcode = hashcode * 29 + shoppingCartLineItemId.hashCode();
    	if (quantity != null)	hashcode = hashcode * 29 + quantity.hashCode();
    	return hashcode;
	}
	   
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append( "ShoppingCartLineItem: " );
		sb.append( "shoppingCartLineItemId='" + shoppingCartLineItemId + "'" );
		sb.append( ", quantity='" + quantity + "'" );
		return sb.toString();
	}	
	
}
