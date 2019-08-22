package com.nouko.web;

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
import com.nouko.domain.CatalogProductsList;
import com.nouko.domain.Product;
import com.nouko.domain.ShoppingCart;
import com.nouko.domain.ShoppingCartLineItem;
import com.nouko.form.ProductForm;
import com.nouko.service.ProductService;
import java.util.Optional;


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
    public String executeSearch( @ModelAttribute("productForm") ProductForm myProductForm, @RequestParam("prodname") String searchedProd, 
    	Model model, HttpServletRequest request) 	throws Exception
	{
		String handlerMethodPath =  "/searchCatalog/executeSearch";     		
		String sql = "SELECT * FROM products WHERE PRODUCT_ID = ?";
		List<Product> productList = new ArrayList<Product>();  				
		String searchedProduct  = Optional.ofNullable(searchedProd).orElse("");
	    String QueryString = "SELECT PRODUCT_ID FROM products WHERE MATCH (PRODUCTNAME, DESCRIPTION) AGAINST ('" + searchedProduct ;
	    QueryString = QueryString + "') ORDER BY MATCH (PRODUCTNAME, DESCRIPTION) AGAINST ('" + searchedProduct + "') DESC"	;		    
	    List<Long> productIdList = productService.findProductIdList(QueryString) ;
	    
	    for( Long prodId :  productIdList)
	    {
	    	Optional<Product> optProduct = productService.readProductByPrimaryKey(prodId, sql);
	    	Product product = optProduct.get() ;
			
	    	if(optProduct.isPresent())	productList.add(product) ;
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
