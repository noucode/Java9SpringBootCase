package com.nouko.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nouko.domain.ShoppingCart;
import com.nouko.domain.ShoppingCartLineItem;
import com.nouko.form.ProductForm;


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
		Optional<Long> optProductId  = Optional.ofNullable(productId);
		Optional<ShoppingCart> optShoppingCart = Optional.ofNullable(shoppingCart);
				
		if (optProductId.isPresent() && optShoppingCart.isPresent()) 
		{
			Long prodId = optProductId.get() ;
			ShoppingCart shopCart = optShoppingCart.get() ;
		    List <ShoppingCartLineItem> singleShoppingCartLineItem = new ArrayList<ShoppingCartLineItem>();
		    List <ShoppingCartLineItem> oldShoppingCartLineItems = shopCart.getShoppingCartLineItems();
		    ShoppingCartLineItem shoppingCartLineItem = shopCart.findShoppingCartLineItem(prodId)  ;		    
		    singleShoppingCartLineItem.add(shoppingCartLineItem) ;		
			
		    List <ShoppingCartLineItem> shoppingCartLineItems = shopCart.getShoppingCartLineItems();
		    BigDecimal cartSubtotal = shopCart.getShoppingCarttotal() ;
		    Integer cartItemNumber = shoppingCartLineItems.size() ;
						
		    model.addAttribute("productForm", new ProductForm() );  		
			model.addAttribute("cartItemNumber", cartItemNumber);
			model.addAttribute("cartSubtotal", cartSubtotal);
			model.addAttribute("productId", productId);  		
			model.addAttribute("aPath", actionPath);  		
			model.addAttribute("singleShoppingCartLineItem", singleShoppingCartLineItem);       
			
			return ".page.update.shoppingcart";
		}
		else 
		{
			return ".page.display.shoppingcart";			
		}
		
	}

}

