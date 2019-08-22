package com.nouko.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import com.nouko.domain.CatalogProductsList;
import com.nouko.domain.Product;
import com.nouko.domain.ShoppingCart;
import com.nouko.domain.ShoppingCartLineItem;
import com.nouko.form.CatalogForm;
import com.nouko.form.ProductForm;
import com.nouko.service.CategoryService;
import com.nouko.service.ProductService;


@Controller
@RequestMapping("/selectCatalog")
@SessionAttributes(value = { "productList",	"oldPath" })
public class SelectCatalogController 
{
    @Autowired
    @Qualifier(value="shoppingCart")
    private ShoppingCart shoppingCart;

    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;
    
    @Autowired
    @Qualifier(value="categoryService")
    private CategoryService categoryService;
    
    @Autowired
    @Qualifier(value="catalogProductsList")
    private CatalogProductsList catalogProductsList;
       
	
    @RequestMapping(value = "/listCatalog")    
    public String listCatalog( @Valid @ModelAttribute("catalogForm") CatalogForm myCatalogForm, BindingResult binding, 
    		Model model, HttpServletRequest request) 	throws Exception
	{
		String handlerMethodPath =  "/selectCatalog/listCatalog";     
    	List<Product> initialProductList = new ArrayList<Product>() ;
    	String QueryString  ;   	
	    String categoryName  = myCatalogForm.getCategname() ;
    	Optional<String> optCategoryId  = Optional.ofNullable(myCatalogForm.getIdCategory());
	    
    	if(optCategoryId.isPresent())
	    {
    		String categoryId  = optCategoryId.get() ;
			QueryString = "SELECT PRODUCT_ID, CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION FROM products WHERE CATEGORY_ID = " + categoryId;    
	    }
	    else
	    {
			QueryString = "SELECT PRODUCT_ID, CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION FROM products";    
	    }

		initialProductList = productService.getListProducts(QueryString); 
		List<Product> productList = new ArrayList<Product>() ;
				
		for (int i = 0;  i < initialProductList.size(); i++) 
		{
			Product product = initialProductList.get(i) ;
			String QueryList = "SELECT PRODUCT_ID, IMAGEPATH FROM PRODUCTIMAGEPATH WHERE PRODUCT_ID = " + product.getProductId() ;		
			List<String> imageLocations = productService.findImageLocations(QueryList) ;
			product.setImageLocations(imageLocations);
			productList.add(product) ;
		}

		catalogProductsList.setProductList(productList); 
	    List <ShoppingCartLineItem> shoppingCartLineItems = shoppingCart.getShoppingCartLineItems();
	    BigDecimal cartSubtotal = shoppingCart.getShoppingCarttotal() ;
	    Integer cartItemNumber = shoppingCartLineItems.size() ;
		
		model.addAttribute("productList", productList);     
		model.addAttribute("aPath", handlerMethodPath);    
		model.addAttribute("originalActionPath", handlerMethodPath);    
		model.addAttribute("categoryId", myCatalogForm.getIdCategory());
		model.addAttribute("categoryName", categoryName);     
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("cartItemNumber", cartItemNumber);
	    model.addAttribute("productForm", new ProductForm() );  		
		
		return ".main.page";
	}
    
}
