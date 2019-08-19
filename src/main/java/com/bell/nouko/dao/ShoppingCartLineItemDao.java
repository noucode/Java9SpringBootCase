package com.bell.nouko.dao;

import com.bell.nouko.domain.ShoppingCartLineItem;

public interface ShoppingCartLineItemDao 
{
	public ShoppingCartLineItem getShoppingCartLineItemByPrimaryKey(Long shoppingCartLineItemId);
	 
	public void saveShoppingCartLineItem(ShoppingCartLineItem shoppingCartLineItem);
}
