package com.bell.nouko.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bell.nouko.domain.CreatedOrUpdatedProducts;
import com.bell.nouko.domain.Product;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/adm/lookupProduct")
@SessionAttributes(value = { "createdOrUpdatedProducts", "origineAction", "originalActionPath" })
public class ProductLookupController 
{
    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;
	
    @Autowired
    @Qualifier(value="createdOrUpdatedProducts")
    private CreatedOrUpdatedProducts createdOrUpdatedProducts;

    
    @RequestMapping(value = "/update")
	public String Update( @RequestParam("productId") Long productId,  @RequestParam("sourceview") String sourceview, 
		 Model model, RedirectAttributes rmodel, HttpServletRequest request) throws Exception    
	{
		ProductForm myProductForm = new ProductForm() ;
		String CRUDerrorMsg = null ;		
		String handlerMethodPath =  "/adm/lookupProduct/update";  
			
		if(productId != null && NumberUtils.isDigits(productId.toString()))
		{			
			Product product = productService.readProductByPrimaryKey(productId);
	
			if(product != null)
			{
				myProductForm.setProductId(product.getProductId()) ;
				myProductForm.setCategId(product.getCategoryId()); ;
				myProductForm.setCreated(product.getCreated()) ;
				myProductForm.setDescription(product.getDescription());
				myProductForm.setProdname(product.getProdname()) ;
				myProductForm.setProdprice("" + product.getProdprice());
				myProductForm.setSerialNumber(product.getSerialNumber()) ;
				myProductForm.setSize(product.getSize()) ;
				myProductForm.setStockQty(product.getStockQty());
				
				myProductForm.setSourceview(sourceview);    
				model.addAttribute("productForm", myProductForm);  		
		
				return  ".page.update.product";		
			}
			else
			{
				CRUDerrorMsg = "Product #" + productId + " does not exist..." ;	
			}
		}
		else
		{
			CRUDerrorMsg = "Invalid number entered: " + productId  ;	
		}			
				
		rmodel.addFlashAttribute("CRUDerrorMsg", CRUDerrorMsg); 
		
		return "redirect:/forwardLookupProduct/executeForward" ;
	}

	
    @RequestMapping(value = "/read")
	public String Read(@Valid @ModelAttribute("productForm") ProductForm myProductForm, BindingResult binding,  
		Model model, RedirectAttributes rmodel, HttpServletRequest request) throws Exception    
	{
		String CRUDerrorMsg = null ;		
		String origineAction = "btnRead" ;		
		Long productId = myProductForm.getProductId() ;
			
		if(productId != null && NumberUtils.isDigits(productId.toString()))
		{			
			Product product = productService.readProductByPrimaryKey(productId);
			
			if(product != null)
			{
				myProductForm.setProductId(product.getProductId()) ;
				myProductForm.setCategId(product.getCategoryId()); ;
				myProductForm.setCreated(product.getCreated()) ;
				myProductForm.setDescription(product.getDescription());
				myProductForm.setProdname(product.getProdname()) ;
				myProductForm.setProdprice("" + product.getProdprice());
				myProductForm.setSerialNumber(product.getSerialNumber()) ;
				myProductForm.setSize(product.getSize()) ;
				myProductForm.setStockQty(product.getStockQty());
				
				model.addAttribute("origineAction", origineAction);  		
				model.addAttribute("productForm", myProductForm);  			
		
				return ".page.display.product";
			}
			else
			{
				CRUDerrorMsg = "Product #" + productId + " does not exist..." ;	
			}
		}
		else
		{
			CRUDerrorMsg = "Invalid number entered: " + productId  ;	
		}			
				
		rmodel.addFlashAttribute("CRUDerrorMsg", CRUDerrorMsg); 
		
		return "redirect:/forwardLookupProduct/executeForward" ;
	}

}

