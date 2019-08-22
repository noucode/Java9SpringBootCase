package com.nouko.web;

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
import com.nouko.domain.ShoppingCart;
import com.nouko.domain.ShoppingCartLineItem;
import com.nouko.form.ProductForm;
import com.nouko.service.ProductService;
import java.util.Optional;


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
		Optional<Long> optProductId  = Optional.ofNullable(myProductForm.getProductId());
		Optional<Integer> optQuantity  = Optional.ofNullable(myProductForm.getQuantity());
		Optional<ShoppingCart> optShoppingCart = Optional.ofNullable(shoppingCart);
		String actionPath =  "/updateCart/update";		
						
		if (optShoppingCart.isPresent()) 
		{
			ShoppingCart shopCart = optShoppingCart.get() ;

			if(optProductId.isPresent() && optQuantity.isPresent())
			{						
				Long productId  = optProductId.get() ;
				Integer quantity = optQuantity.get() ;				
				shopCart.changeQuantity(productId, quantity);		
				
			    List <ShoppingCartLineItem> shoppingCartLineItems = shopCart.getShoppingCartLineItems();
			    BigDecimal cartSubtotal = shopCart.getShoppingCarttotal() ;
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
			    List <ShoppingCartLineItem> shoppingCartLineItems = shopCart.getShoppingCartLineItems();
			    BigDecimal cartSubtotal = shopCart.getShoppingCarttotal() ;
			    Integer cartItemNumber = shoppingCartLineItems.size() ;

				model.addAttribute("cartItemNumber", cartItemNumber);
				model.addAttribute("cartSubtotal", cartSubtotal);			
				
				if(optProductId.isPresent())
				{
					Long productId  = optProductId.get() ;
					List <ShoppingCartLineItem> singleShoppingCartLineItem = new ArrayList<ShoppingCartLineItem>();
				    ShoppingCartLineItem shoppingCartLineItem = shopCart.findShoppingCartLineItem(productId)  ;			    
				    singleShoppingCartLineItem.add(shoppingCartLineItem) ;		
					
					model.addAttribute("singleShoppingCartLineItem", singleShoppingCartLineItem);   									
				}				
			}						
		}
		
		return ".page.update.shoppingcart";		    					
	}    
	
}
