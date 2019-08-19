package com.bell.nouko.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bell.nouko.domain.Category;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.CategoryService;


@Controller
@RequestMapping("/forwardCreateProduct")
public class ForwardCreateProductController 
{
    @Autowired
    @Qualifier(value="categoryService")
    private CategoryService categoryService;
	

    @RequestMapping("/executeForward")    
    public String executeForward(Model model, HttpServletRequest request) throws Exception
	{	
    	String QueryString = "SELECT CATEGORY_ID, CATEGORYNAME, DESCRIPTION FROM categories";	
		List<Category> categoryList = categoryService.getQueryListCategories(QueryString) ;

		model.addAttribute("categoryList", categoryList);  				
		model.addAttribute("productForm", new ProductForm());  				

		return ".page.create.product";
	}

}


