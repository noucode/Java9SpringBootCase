package com.nouko.web ;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nouko.domain.Category;
import com.nouko.domain.Product;
import com.nouko.service.CategoryService;
import com.nouko.service.ProductService;


@Controller
@RequestMapping(value="/ajaxvalidation")
public class AjaxValidationController 
{
    @Autowired
    @Qualifier(value="categoryService")
    private CategoryService categoryService;
    
    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;
                
    
    @RequestMapping(value = "/category", method = RequestMethod.POST)
	public @ResponseBody String validateCategoty( @RequestParam("categId") Integer categId,  
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception    
	{
		String sql = "SELECT * FROM categories WHERE CATEGORY_ID = ?";
    	Optional<Category> optCategory = categoryService.readCategoryByPrimaryKey(categId, sql) ;  
    	    	
        if (optCategory.isPresent()) {
        	return  "success" ;
        } 
        else {
        	return  "error" ;
        }
	}

    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
	public @ResponseBody String validateProduct( @RequestParam("productId") Long productId,  
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception    
	{
		String sql = "SELECT * FROM products WHERE PRODUCT_ID = ?";
    	String result = null ;
    	Optional<Product> optProduct = productService.readProductByPrimaryKey(productId, sql) ;    
    	
        if (optProduct.isPresent()) {
        	return  "success" ;
        } 
        else {
        	return  "error" ;
        }
	}
 
}

