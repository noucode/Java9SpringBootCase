package com.bell.nouko.web ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bell.nouko.domain.Category;
import com.bell.nouko.domain.Product;
import com.bell.nouko.service.CategoryService;
import com.bell.nouko.service.ProductService;


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
    	String result = null ;
    	Category category = categoryService.readCategoryByPrimaryKey(categId) ;  
    	
    	if(category != null)		result = "success" ;
    	else result = "error" ;
    	
		return result;    	        
	}

    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
	public @ResponseBody String validateProduct( @RequestParam("productId") Long productId,  
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception    
	{
    	String result = null ;
    	Product product = productService.readProductByPrimaryKey(productId) ;    
    	
    	if(product != null)		result = "success" ;
    	else result = "error" ;
    	
		return result;    	        
	}

   
}


