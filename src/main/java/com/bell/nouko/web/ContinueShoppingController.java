package com.bell.nouko.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bell.nouko.domain.CatalogProductsList;
import com.bell.nouko.domain.Product;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/continueshopping")
@SessionAttributes(value = { "productList",	"originalActionPath" })
public class ContinueShoppingController
{
    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;


    @Autowired
    @Qualifier(value="catalogProductsList")
    private CatalogProductsList catalogProductsList;

    
    @RequestMapping(value = "/executeShopping")    
    public String executeShopping( Model model,  HttpServletRequest request) throws Exception
	{
		String handlerMethodPath =  "/continueshopping/executeShopping";     
    	List<Product> productList = catalogProductsList.getProductList() ;  
    	
    	if(productList.size() < 1)
    	{
    		String QueryString = "SELECT PRODUCT_ID, CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION FROM products";    
    		productList = productService.getListProducts(QueryString); 
    		catalogProductsList.setProductList(productList);     		
    	}
		
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
	    Integer cartItemNumber = shoppingCartLineItems.size() ;

		model.addAttribute("aPath", handlerMethodPath);    
	    model.addAttribute("productForm", new ProductForm() );  		
	    model.addAttribute("productList", productList);     
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("cartItemNumber", cartItemNumber);
		
		return ".main.page";
	}
    
}


