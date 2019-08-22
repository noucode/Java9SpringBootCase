package com.nouko.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nouko.domain.Product;
import com.nouko.service.ProductService;


@Controller
@RequestMapping("/productListPage")
public class ProductListController
{
    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;

	
    @RequestMapping(value = "/executeList")    
    public String executeList( Model model, HttpServletRequest request) throws Exception
	{
		String QueryString = "SELECT PRODUCT_ID, CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION FROM products";    
		
		List<Product> productList = productService.getListProducts(QueryString); 
		model.addAttribute("productList", productList);
		model.addAttribute("aPath", "/productListPage/executeList");
		
		return ".page.list.products";				
	}

}
