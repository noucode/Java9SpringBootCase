package com.nouko.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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
		Product product = new Product();
		ShoppingCartLineItem shoppingCartLineItem = new ShoppingCartLineItem();
		boolean trouve = false;
		
		for (int i = 0; !trouve && i < shoppingCartLineItems.size(); i++) 
		{
			shoppingCartLineItem = (ShoppingCartLineItem) shoppingCartLineItems.get(i);
			product = (Product) shoppingCartLineItem.getProduct() ;
			
			/** Only update the quantity if the item is already added to the Cart */
			if (product.getProductId().intValue() == productId.intValue()) 
			{
				shoppingCartLineItem.setQuantity(shoppingCartLineItem.getQuantity() + aShoppingCartLineItem.getQuantity());
				trouve = true;
			}
		}
		
		/** item not found  ?  */
		if (!trouve) 
		{
			/** add the item to cart if it is not added to cart yet */
			shoppingCartLineItems.add(aShoppingCartLineItem);		
		}
	}
	
	
	public void removeFromCart(Long productId) 
	{
		shoppingCartLineItems.removeIf(shoppingCartLineItem -> shoppingCartLineItem.getProduct().getProductId().intValue() == productId.intValue());		
	}
	
	
	public void changeQuantity(Long productId, Integer quantity) 
	{
		if(quantity.intValue() <= 0)
		{
			removeFromCart(productId) ;
		}
		else
		{
			for (ShoppingCartLineItem shoppingCartLineItem : shoppingCartLineItems) 
			{ 
				if ((( shoppingCartLineItem).getProduct().getProductId()).intValue() == productId.intValue()) 
				{				
					shoppingCartLineItem.setQuantity(quantity); 
				}
			}			
		}
	}
	

	public ShoppingCartLineItem findShoppingCartLineItem(Long productId) 
	{
	    ShoppingCartLineItem shoppingCartLineItem = new ShoppingCartLineItem() ;	
	    
		for (ShoppingCartLineItem currentShoppingCartLineItem : shoppingCartLineItems) 
	    {
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
    	BigDecimal totalProdprice = BigDecimal.ZERO ;
    	   	
    	/** parcourir la liste shoppingCartLineItems et faire la sommation du champ prodprice de chaque Product dans la liste */
		for (ShoppingCartLineItem shoppingCartLineItem : shoppingCartLineItems) 
		{
			totalProdprice = totalProdprice.add((shoppingCartLineItem.getProduct().getProdprice()).multiply(new BigDecimal(shoppingCartLineItem.getQuantity()))) ;
		}
		
    	return totalProdprice ;
    }
	
	  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shoppingCartId == null) ? 0 : shoppingCartId.hashCode());
		result = prime * result + ((shoppingCartLineItems == null) ? 0 : shoppingCartLineItems.hashCode());
		result = prime * result + ((shoppingCarttotal == null) ? 0 : shoppingCarttotal.hashCode());
		result = prime * result + ((shoppingDate == null) ? 0 : shoppingDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (shoppingCartId == null) {
			if (other.shoppingCartId != null)
				return false;
		} else if (!shoppingCartId.equals(other.shoppingCartId))
			return false;
		if (shoppingCartLineItems == null) {
			if (other.shoppingCartLineItems != null)
				return false;
		} else if (!shoppingCartLineItems.equals(other.shoppingCartLineItems))
			return false;
		if (shoppingCarttotal == null) {
			if (other.shoppingCarttotal != null)
				return false;
		} else if (!shoppingCarttotal.equals(other.shoppingCarttotal))
			return false;
		if (shoppingDate == null) {
			if (other.shoppingDate != null)
				return false;
		} else if (!shoppingDate.equals(other.shoppingDate))
			return false;
		return true;
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
