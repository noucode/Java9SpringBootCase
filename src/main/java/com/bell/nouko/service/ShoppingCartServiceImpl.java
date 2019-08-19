package com.bell.nouko.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bell.nouko.dao.ShoppingCartDao;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;


@Service(value = "shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService
{
    @Autowired
    @Qualifier(value = "shoppingCartDao")
	private ShoppingCartDao shoppingCartDao;

    @Autowired
    @Qualifier(value="shoppingCartLineItemService")
    private ShoppingCartLineItemService shoppingCartLineItemService;
    
	private Date dateDuJour = new java.sql.Date((new GregorianCalendar()).getTime().getTime());
	
	
	@Override
	public ShoppingCart readShoppingCartByPrimaryKey(Long shoppingCartId)	throws Exception
	{
	    return shoppingCartDao.getShoppingCartByPrimaryKey(shoppingCartId);
	}
	
	    
	@Override
	public Long createShoppingCart(ShoppingCart shoppingCart, Long customerId)	throws Exception
	{
		shoppingCart.setShoppingCartLineItems(new ArrayList<ShoppingCartLineItem>());
		shoppingCart.setShoppingDate(dateDuJour);
		
		Long shoppingCartId = shoppingCartDao.saveShoppingCart(shoppingCart); 
		
		return  shoppingCartId ;
	}
		
	
	@Override
	public Long saveShoppingCart(ShoppingCart shoppingCart, Long customerId)	throws Exception
	{
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();	    	    		

	    ShoppingCart myshoppingCart = new ShoppingCart() ;
		myshoppingCart.setShoppingCarttotal(shoppingCart.getShoppingCarttotal());
		myshoppingCart.setShoppingDate(shoppingCart.getShoppingDate());		

		// Save the shoppingCart
		Long shoppingCartId = createShoppingCart(myshoppingCart, customerId); 
				
		// Save all shoppingCartLineItems in the shoppingCart
		for (int i = 0; i < shoppingCartLineItems.size(); i++)
		{
			ShoppingCartLineItem shoppingCartLineItem = shoppingCartLineItems.get(i) ;
			shoppingCartLineItemService.createShoppingCartLineItem(shoppingCartLineItem, shoppingCartId);
		}
				
		return  shoppingCartId ;
	}
	
}
