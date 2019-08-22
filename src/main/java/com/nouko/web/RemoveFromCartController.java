package com.nouko.web;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/removeFromCart")
public class RemoveFromCartController
{
    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

	
    @RequestMapping(value = "/executeRemove")
	public String executeRemove( @RequestParam Long productId, 	Model model, HttpServletRequest request) throws Exception    
	{
		String actionPath =  "/removeFromCart/executeRemove";
		
		if((productId != null) && (shoppingCart != null))  
		{
			shoppingCart.removeFromCart(productId);			
		    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
		    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
		    Integer cartItemNumber = shoppingCartLineItems.size() ;
			
		    model.addAttribute("productForm", new ProductForm() );  		
			model.addAttribute("cartItemNumber", cartItemNumber);
			model.addAttribute("cartSubtotal", cartSubtotal);
			model.addAttribute("aPath", actionPath); 
			model.addAttribute("shoppingCartLineItems", shoppingCartLineItems);
		}
				
		return ".page.display.shoppingcart";				
	}

}
