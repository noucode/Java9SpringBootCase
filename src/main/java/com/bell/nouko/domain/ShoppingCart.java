package com.bell.nouko.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component("shoppingCart")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable
{
	private static final long serialVersionUID = 1L;	

	private Long shoppingCartId;
    private Date shoppingDate;
    private BigDecimal shoppingCarttotal;
    private List <ShoppingCartLineItem> shoppingCartLineItems = new CopyOnWriteArrayList<ShoppingCartLineItem>();

    public ShoppingCart() {
    }
    
    public Long getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public Date getShoppingDate() {
		return shoppingDate;
	}
	public void setShoppingDate(Date shoppingDate) {
		this.shoppingDate = shoppingDate;
	}
	
	
	public void addToCart(ShoppingCartLineItem aShoppingCartLineItem) 
	{
		Long productId = aShoppingCartLineItem.getProduct().getProductId() ;
		Product product = null;
		ShoppingCartLineItem shoppingCartLineItem = null;
		boolean trouve = false;
		
		for (int i = 0; !trouve && i < shoppingCartLineItems.size(); i++) 
		{
			shoppingCartLineItem = (ShoppingCartLineItem) shoppingCartLineItems.get(i);
			product = (Product) shoppingCartLineItem.getProduct() ;
			
			// Only update the quantity if the item is already added to the Cart 
			if (product.getProductId().intValue() == productId.intValue()) 
			{
				shoppingCartLineItem.setQuantity(shoppingCartLineItem.getQuantity() + aShoppingCartLineItem.getQuantity());
				trouve = true;
			}
		}
		
		// item not found  ?
		if (!trouve) 
		{
			// add the item to cart if it is not added to cart yet
			shoppingCartLineItems.add(aShoppingCartLineItem);		
		}
	}
	
	
	public void removeFromCart(Long productId) 
	{
		for (int i = 0; i < shoppingCartLineItems.size(); i++) 
		{ 
			if ((((ShoppingCartLineItem) shoppingCartLineItems.get(i)).getProduct().getProductId()).intValue() == productId.intValue()) 
			{
				shoppingCartLineItems.remove(i);  
			}
		}
	}
	
	
	public void changeQuantity(Long productId, Integer quantity) 
	{
		if(quantity.intValue() <= 0)
		{
			removeFromCart(productId) ;
		}
		else
		{
			for (int i = 0; i < shoppingCartLineItems.size(); i++) 
			{ 

				if ((((ShoppingCartLineItem) shoppingCartLineItems.get(i)).getProduct().getProductId()).intValue() == productId.intValue()) 
				{				
					shoppingCartLineItems.get(i).setQuantity(quantity); 
				}
			}			
		}

	}
	

	public ShoppingCartLineItem findShoppingCartLineItem(Long productId) 
	{
	    ShoppingCartLineItem shoppingCartLineItem = null ;	
	    
	    for(int i = 0; i < shoppingCartLineItems.size(); i++)
	    {
	    	ShoppingCartLineItem currentShoppingCartLineItem = (ShoppingCartLineItem) shoppingCartLineItems.get(i) ; 
	    	if(productId.intValue() == (currentShoppingCartLineItem.getProduct().getProductId()).intValue()  )
	    	{
	    		shoppingCartLineItem = currentShoppingCartLineItem ;
	    	}	    		
	    }
	    
	    return shoppingCartLineItem ;
	}

	
	public BigDecimal getShoppingCarttotal() {
    	this.shoppingCarttotal = calculatePrice() ;
    	return this.shoppingCarttotal ;
	}
	
	public void setShoppingCarttotal(BigDecimal shoppingCarttotal) {
		this.shoppingCarttotal = shoppingCarttotal;
	}
	
	public List<ShoppingCartLineItem> getShoppingCartLineItems() {
		return shoppingCartLineItems;
	}
	public void setShoppingCartLineItems(List<ShoppingCartLineItem> shoppingCartLineItems) {
		this.shoppingCartLineItems = shoppingCartLineItems;
	}
	
    public BigDecimal calculatePrice()
    {
    	BigDecimal totalProdprice = new BigDecimal(0) ;
    	   	
    	// parcourir la liste shoppingCartLineItems et faire la sommation du champ prodprice de chaque Product dans la liste
		for (int i = 0; i < shoppingCartLineItems.size(); i++) 
		{
			totalProdprice = totalProdprice.add(((shoppingCartLineItems.get(i)).getProduct().getProdprice()).multiply(new BigDecimal( (shoppingCartLineItems.get(i)).getQuantity()))) ;

		}
    	return totalProdprice ;
    }
	

	public boolean equals(Object other) 
	{
		if (other == null) 			return false;

    	if (this != other) 
    	{
    		if ( !(other instanceof ShoppingCart) ) 	return false; 

    		ShoppingCart shoppingCart = (ShoppingCart) other;

    		if ( !shoppingCart.getShoppingCartId().equals(this.getShoppingCartId()) ) 	return false;
    		if ( !shoppingCart.getShoppingDate().equals(this.getShoppingDate()) ) 	return false;
    		if ( !shoppingCart.getShoppingCarttotal().equals(this.getShoppingCarttotal()) ) 	return false;
    	}

    	return true;
	}
	
	public int hashCode() 
	{
    	int hashcode = 0;
    	if (shoppingCartId != null)	hashcode = hashcode * 29 + shoppingCartId.hashCode();
    	if (shoppingDate != null)	hashcode = hashcode * 29 + shoppingDate.hashCode();
    	if (shoppingCarttotal != null)	hashcode = hashcode * 29 + shoppingCarttotal.hashCode();
    	return hashcode;
	}
	  
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append( "ShoppingCart: " );
		sb.append( "shoppingCartId='" + shoppingCartId + "'" );
		sb.append( ", shoppingDate='" + shoppingDate + "'" );
		sb.append( ", shoppingCarttotal='" + shoppingCarttotal + "'" );
		return sb.toString();
	}
	
}
