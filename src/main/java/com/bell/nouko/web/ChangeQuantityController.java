package com.bell.nouko.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;
import com.bell.nouko.form.ProductForm;


@Controller
@RequestMapping("/changeQuantity")
public class ChangeQuantityController
{
    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

	
    @RequestMapping(value = "/executeChange")
	public String executeChange( @RequestParam Long productId, @RequestParam("quantity") Integer quantity, 
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception    
	{
		String actionPath =  "/changeQuantity/executeChange";
		
		if(productId == null) 
		{
			return ".page.display.shoppingcart";			
		}
		
		if (shoppingCart == null) 
		{
			return ".page.display.shoppingcart";
		}
		
	    List <ShoppingCartLineItem> singleShoppingCartLineItem = new ArrayList<ShoppingCartLineItem>();
	    List <ShoppingCartLineItem> oldShoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    ShoppingCartLineItem shoppingCartLineItem = shoppingCart.findShoppingCartLineItem(productId)  ;		    
	    singleShoppingCartLineItem.add(shoppingCartLineItem) ;		
		
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
	    Integer cartItemNumber = shoppingCartLineItems.size() ;
					
	    model.addAttribute("productForm", new ProductForm() );  		
		model.addAttribute("cartItemNumber", cartItemNumber);
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("productId", productId);  		
		model.addAttribute("aPath", actionPath);  		
		model.addAttribute("singleShoppingCartLineItem", singleShoppingCartLineItem);       
		
		return ".page.update.shoppingcart";
	}

}

