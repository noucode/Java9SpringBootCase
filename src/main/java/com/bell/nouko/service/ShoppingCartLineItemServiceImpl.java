package com.bell.nouko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bell.nouko.dao.ShoppingCartDao;
import com.bell.nouko.dao.ShoppingCartLineItemDao;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;

@Service(value = "shoppingCartLineItemService")
public class ShoppingCartLineItemServiceImpl implements ShoppingCartLineItemService
{

    @Autowired
    @Qualifier(value = "shoppingCartDao")
	private ShoppingCartDao shoppingCartDao;

    @Autowired
    @Qualifier(value = "shoppingCartLineItemDao")
	private ShoppingCartLineItemDao shoppingCartLineItemDao;

	
	
	@Override
	public ShoppingCartLineItem readShoppingCartLineItemByPrimaryKey(Long shoppingCartLineItemId)	throws Exception
	{
	    return shoppingCartLineItemDao.getShoppingCartLineItemByPrimaryKey(shoppingCartLineItemId);
	}
	
	    
	@Override
	public void createShoppingCartLineItem(ShoppingCartLineItem shoppingCartLineItem, Long shoppingCartId)	throws Exception
	{
		ShoppingCart shoppingCart = shoppingCartDao.getShoppingCartByPrimaryKey(shoppingCartId) ;
		shoppingCartLineItem.setShoppingCart(shoppingCart);
		shoppingCart.getShoppingCartLineItems().add(shoppingCartLineItem);
		
		shoppingCartLineItemDao.saveShoppingCartLineItem(shoppingCartLineItem); 
		shoppingCartDao.updateShoppingCart(shoppingCart);
	}
	
}
