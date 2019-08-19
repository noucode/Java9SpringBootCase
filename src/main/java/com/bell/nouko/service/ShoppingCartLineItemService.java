package com.bell.nouko.service;

import com.bell.nouko.domain.ShoppingCartLineItem;


public interface ShoppingCartLineItemService {
	
	public ShoppingCartLineItem readShoppingCartLineItemByPrimaryKey(Long shoppingCartLineItemId)	throws Exception;
	public void createShoppingCartLineItem(ShoppingCartLineItem shoppingCartLineItem, Long shoppingCartId)	throws Exception;

}
