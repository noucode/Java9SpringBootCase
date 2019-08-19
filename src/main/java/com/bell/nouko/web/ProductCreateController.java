package com.bell.nouko.web;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bell.nouko.domain.CreatedOrUpdatedProducts;
import com.bell.nouko.domain.Product;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/adm/createProduct")
public class ProductCreateController
{
    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;   
            
	
    @Autowired
    @Qualifier(value="createdOrUpdatedProducts")
    private CreatedOrUpdatedProducts createdOrUpdatedProducts;

	private Date dateDuJour = new java.sql.Date((new GregorianCalendar()).getTime().getTime());

    @RequestMapping(value = "/create")
	public String Create(@Valid @ModelAttribute("productForm") ProductForm myProductForm, BindingResult binding, 
			Model model) throws Exception    
	{
		String actionPath =  "/adm/createProduct/create";     
		Product product = new Product();	
		
		product.setCategoryId(new Integer(myProductForm.getCategId()));
		product.setImageLocations(new ArrayList<String>());
		product.setCreated(dateDuJour);
		product.setDescription(myProductForm.getDescription());
		product.setProdname(myProductForm.getProdname());
		product.setSerialNumber(myProductForm.getSerialNumber());
		product.setSize(myProductForm.getSize());
		product.setStockQty(myProductForm.getStockQty());
		product.setProdprice(new BigDecimal(myProductForm.getProdprice()));
		
		productService.createProduct(product);
		
		createdOrUpdatedProducts.addProduct(product);		
		List<Product> createdOrUpdatedProductList = new ArrayList<Product>();
		createdOrUpdatedProductList = createdOrUpdatedProducts.getProductList() ;
				
		model.addAttribute("createdOrUpdatedProducts", createdOrUpdatedProducts);    
		model.addAttribute("createdOrUpdatedProductList", createdOrUpdatedProductList);  		
		model.addAttribute("aPath", actionPath);  		
		model.addAttribute("productForm", new ProductForm());  				

		return ".page.create.product";
	}
    
}


