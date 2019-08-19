package com.bell.nouko.web;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bell.nouko.domain.Product;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/addtocart")
@SessionAttributes(value = { "cartSubtotal", "cartItemNumber" })	
public class AddToCartController
{
    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;		

    
    @RequestMapping(value = "/executeAdd")
	public String executeAdd(@Valid @ModelAttribute("productForm") ProductForm myProductForm, BindingResult binding, 
		@RequestParam("productId") Long productId, Model model, HttpServletRequest request) throws Exception    
	{		
		Product product = new Product();
		Integer quantity = new Integer(1) ; 
								
		if (productId == null) 
		{
			return ".main.page";
		}
		else
		{
			product = productService.readProductByPrimaryKey(productId) ;
						
			String QueryList = "SELECT PRODUCT_ID, IMAGEPATH FROM PRODUCTIMAGEPATH WHERE PRODUCT_ID = " + product.getProductId() ;		
			List<String> imageLocations = productService.findImageLocations(QueryList) ;
			product.setImageLocations(imageLocations);
			
			ShoppingCartLineItem shoppingCartLineItem = new ShoppingCartLineItem() ;
			
			shoppingCartLineItem.setProduct(product);
			shoppingCartLineItem.setQuantity(quantity);
						
			shoppingCart.addToCart(shoppingCartLineItem);	
			
		    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
		    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
		    Integer cartItemNumber = shoppingCartLineItems.size() ;
		    						
		    model.addAttribute("productForm", new ProductForm() );  		
		    model.addAttribute("cartSubtotal", cartSubtotal);
		    model.addAttribute("cartItemNumber", cartItemNumber);
		    model.addAttribute("shoppingCartLineItems", shoppingCartLineItems);
			
			return ".page.display.shoppingcart";
		}
				    						
	}

}

