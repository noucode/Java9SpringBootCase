package com.nouko.web;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
import com.nouko.domain.CreatedOrUpdatedProducts;
import com.nouko.domain.Product;
import com.nouko.form.ProductForm;
import com.nouko.service.ProductService;


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
	public String Update( @RequestParam("productId") Long prodId,  @RequestParam("sourceview") String sourceview, 
		 Model model, RedirectAttributes rmodel, HttpServletRequest request) throws Exception    
	{
		ProductForm myProductForm = new ProductForm() ;
		String CRUDerrorMsg = "" ;		
		String sql = "SELECT * FROM products WHERE PRODUCT_ID = ?";		
		Optional<Long> optProductId  = Optional.ofNullable(prodId);
					
		if(optProductId.isPresent())
		{			
			Long productId = optProductId.get() ;
			Optional<Product> optProduct = productService.readProductByPrimaryKey(productId, sql);
	
			if(optProduct.isPresent())
			{
				Product product = optProduct.get() ;
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
			else {
				CRUDerrorMsg = "Product #" + productId + " does not exist..." ;	
			}
		}
		else {
			CRUDerrorMsg = "Invalid number entered: " + prodId  ;	
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
		String sql = "SELECT * FROM products WHERE PRODUCT_ID = ?";		
		Optional<Long> optProductId  = Optional.ofNullable(myProductForm.getProductId());
				
		if(optProductId.isPresent())
		{			
			Long productId = optProductId.get() ;
			Optional<Product> optProduct = productService.readProductByPrimaryKey(productId, sql);
			
			if(optProduct.isPresent())
			{
				Product product = optProduct.get() ;
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
			else {
				CRUDerrorMsg = "Product #" + productId + " does not exist..." ;	
			}
		}
		else {
			CRUDerrorMsg = "Invalid number entered: " + myProductForm.getProductId()  ;	
		}			
				
		rmodel.addFlashAttribute("CRUDerrorMsg", CRUDerrorMsg); 		
		return "redirect:/forwardLookupProduct/executeForward" ;
	}

}
