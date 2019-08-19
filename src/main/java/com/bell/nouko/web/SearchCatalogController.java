package com.bell.nouko.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bell.nouko.domain.CatalogProductsList;
import com.bell.nouko.domain.Product;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/searchCatalog")
@SessionAttributes(value = { "productList",	"originalActionPath", "searchedProduct", "QueryString" })
public class SearchCatalogController  
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

    
    @RequestMapping(value = "/executeSearch")    
    public String executeSearch( @ModelAttribute("productForm") ProductForm myProductForm, @RequestParam("prodname") String searchedProduct, 
    	Model model, HttpServletRequest request) 	throws Exception
	{
		String handlerMethodPath =  "/searchCatalog/executeSearch";     		
		Product product = new Product();
		List<Product> productList = new ArrayList<Product>();  		
		
		if(searchedProduct == null) 	searchedProduct = "" ;
	    
	    String QueryString = "SELECT PRODUCT_ID FROM products WHERE MATCH (PRODUCTNAME, DESCRIPTION) AGAINST ('" + searchedProduct ;
	    QueryString = QueryString + "') ORDER BY MATCH (PRODUCTNAME, DESCRIPTION) AGAINST ('" + searchedProduct + "') DESC"	;	
	    
	    List<Long> productIdList = productService.findProductIdList(QueryString) ;
	    
	    for( int i = 0; i < productIdList.size(); i++)
	    {
			product = productService.readProductByPrimaryKey(productIdList.get(i));	    	 
			productList.add(product) ;
	    }
		
		catalogProductsList.setProductList(productList); 
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
	    Integer cartItemNumber = shoppingCartLineItems.size() ;
		
		model.addAttribute("productList", productList);     
		model.addAttribute("aPath", handlerMethodPath);    
		model.addAttribute("originalActionPath", handlerMethodPath);    
		model.addAttribute("searchedProduct", searchedProduct);  		
		model.addAttribute("QueryString", QueryString);    
		model.addAttribute("productForm", new ProductForm());    
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("cartItemNumber", cartItemNumber);
		
		return ".main.page";
	}

}

