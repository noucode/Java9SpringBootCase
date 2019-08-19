package com.bell.nouko.dao;

import com.bell.nouko.domain.ShoppingCart;

public interface ShoppingCartDao 
{
	public ShoppingCart getShoppingCartByPrimaryKey(Long shoppingCartId);
	public Long saveShoppingCart(ShoppingCart shoppingCart);
	public void updateShoppingCart(ShoppingCart shoppingCart);
	
}
