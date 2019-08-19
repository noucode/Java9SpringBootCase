package com.bell.nouko.web;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bell.nouko.domain.Product;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/displayShoppingCart")
@SessionAttributes(value = { "shoppingCartLineItems", "oldPath" })
public class DisplayCartController 
{
    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;

    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

    
    @RequestMapping(value = "/displayCart")    
    public String displayCart( Model model, HttpServletRequest request) throws Exception
	{		
		String actionPath =  "/displayShoppingCart/displayCart";   
		
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
	    Integer cartItemNumber = shoppingCartLineItems.size() ;
	    
		for (int i = 0;  i < shoppingCartLineItems.size(); i++) 
		{
			Product product = shoppingCartLineItems.get(i).getProduct() ;
			String QueryList = "SELECT PRODUCT_ID, IMAGEPATH FROM PRODUCTIMAGEPATH WHERE PRODUCT_ID = " + product.getProductId() ;		
			List<String> imageLocations = productService.findImageLocations(QueryList) ;
			shoppingCartLineItems.get(i).getProduct().setImageLocations(imageLocations);
		}
	    	
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("cartItemNumber", cartItemNumber);
		model.addAttribute("shoppingCartLineItems", shoppingCartLineItems);    													  
		model.addAttribute("aPath", actionPath); 
	    model.addAttribute("productForm", new ProductForm() );  		
				
		return ".page.display.shoppingcart";
	}

}


