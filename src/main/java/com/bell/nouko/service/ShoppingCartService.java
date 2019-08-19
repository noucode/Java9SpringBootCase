package com.bell.nouko.service;

import java.util.List;

import com.bell.nouko.domain.ShoppingCart;


public interface ShoppingCartService {
	
	public ShoppingCart readShoppingCartByPrimaryKey(Long shoppingCartId)	throws Exception;	
	public Long createShoppingCart(ShoppingCart shoppingCart, Long customerId)	throws Exception	;
	public Long saveShoppingCart(ShoppingCart shoppingCart, Long customerId)	throws Exception ;

}





