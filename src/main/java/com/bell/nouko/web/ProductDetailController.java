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
@RequestMapping("/showProductDetail")
@SessionAttributes(value = { "originalActionPath" })
public class ProductDetailController
{
    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;

    @RequestMapping(value = "/showDetail")    
    public String showDetail(@Valid @ModelAttribute("productForm") ProductForm myProductForm, BindingResult binding, 
    	@RequestParam("productId") Long productId, Model model, HttpServletRequest request) throws Exception
	{
		String handlerMethodPath =  "/showProductDetail/showDetail";     
		Product product = productService.readProductByPrimaryKey(productId);
				
		String QueryList = "SELECT PRODUCT_ID, IMAGEPATH FROM PRODUCTIMAGEPATH WHERE PRODUCT_ID = " + product.getProductId() ;		
		List<String> imageLocations = productService.findImageLocations(QueryList) ;
		product.setImageLocations(imageLocations);
				
		myProductForm.setImageLocations(imageLocations) ;
		myProductForm.setProductId(product.getProductId()) ;
		myProductForm.setCategId(product.getCategoryId()); ;
		myProductForm.setCreated(product.getCreated()) ;
		myProductForm.setDescription(product.getDescription());
		myProductForm.setProdname(product.getProdname()) ;
		myProductForm.setProdprice("" + product.getProdprice());
		myProductForm.setSerialNumber(product.getSerialNumber()) ;
		myProductForm.setSize(product.getSize()) ;
		myProductForm.setStockQty(product.getStockQty());
		
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
	    Integer cartItemNumber = shoppingCartLineItems.size() ;
		
		model.addAttribute("productForm", myProductForm );  		
		model.addAttribute("aProduct", product);  		
		model.addAttribute("imageList", product.getImageLocations());  
		model.addAttribute("originalActionPath", handlerMethodPath);    
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("cartItemNumber", cartItemNumber);
		
		return ".page.detail.product";
	}
	
}


