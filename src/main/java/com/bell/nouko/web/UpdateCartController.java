package com.bell.nouko.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/updateCart")
@SessionAttributes(value = { "cartItemNumber", "cartSubtotal" })
public class UpdateCartController
{
    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;

    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

    
    @RequestMapping(value = "/update")
	public String Create(@Valid @ModelAttribute("productForm") ProductForm myProductForm, BindingResult binding, 
		 Model model, HttpServletRequest request) throws Exception    
	{
		String actionPath =  "/updateCart/update";
		Long productId = myProductForm.getProductId();	
		Integer quantity = myProductForm.getQuantity()  ;  
		
		if (shoppingCart != null ) 
		{
			if(productId != null && quantity != null  && quantity.intValue() >= 0)
			{		
				shoppingCart.changeQuantity(productId, quantity);		
				
			    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
			    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
			    Integer cartItemNumber = shoppingCartLineItems.size() ;
			    	    									
			    model.addAttribute("cartSubtotal", cartSubtotal);
				model.addAttribute("cartItemNumber", cartItemNumber);
				model.addAttribute("cartSubtotal", cartSubtotal);
				model.addAttribute("cartItemNumber", cartItemNumber);
				model.addAttribute("shoppingCartLineItems", shoppingCartLineItems);
				model.addAttribute("aPath", actionPath);  		
				
				return ".page.display.shoppingcart";	
			}
			else
			{
			    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
			    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
			    Integer cartItemNumber = shoppingCartLineItems.size() ;

				model.addAttribute("cartItemNumber", cartItemNumber);
				model.addAttribute("cartSubtotal", cartSubtotal);			
				
				if(productId != null)
				{
					List <ShoppingCartLineItem> singleShoppingCartLineItem = new ArrayList<ShoppingCartLineItem>();
				    ShoppingCartLineItem shoppingCartLineItem = shoppingCart.findShoppingCartLineItem(productId)  ;			    
				    singleShoppingCartLineItem.add(shoppingCartLineItem) ;		
					
					model.addAttribute("singleShoppingCartLineItem", singleShoppingCartLineItem);   									
				}				
			}						
		}
		
		return ".page.update.shoppingcart";		    					
	}    
	
}

