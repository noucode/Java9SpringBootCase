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
@RequestMapping("/displayCatalog")
@SessionAttributes(value = { "productList",	"oldPath" })
public class DisplayCatalogController 
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
    
    
    @RequestMapping(value = "/listCatalog")    
    public String listCatalog(Model model, HttpServletRequest request) throws Exception
	{
		String handlerMethodPath =  "/displayCatalog/listCatalog";     
		String QueryString = "From Product" ;
		List<Product> productList = new ArrayList<Product>() ;
		
		productList = productService.getListProducts(QueryString); 
		catalogProductsList.setProductList(productList); 
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
	    Integer cartItemNumber = shoppingCartLineItems.size() ;
		
		model.addAttribute("productList", productList);     
		model.addAttribute("aPath", handlerMethodPath);    
		model.addAttribute("originalActionPath", handlerMethodPath);    
		model.addAttribute("productForm", new ProductForm());    
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("cartItemNumber", cartItemNumber);
		
		request.getSession().removeAttribute("categoryId");      
		request.getSession().removeAttribute("categoryName");      
		
		return ".page.display.catalog";				
	}
    
}


