package com.bell.nouko.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bell.nouko.domain.CatalogProductsList;
import com.bell.nouko.domain.Product;
import com.bell.nouko.domain.ShoppingCart;
import com.bell.nouko.domain.ShoppingCartLineItem;
import com.bell.nouko.form.ProductForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/forwardMainPage")
@SessionAttributes(value = { "productList",	"oldPath" })
public class ForwardMainPageController 
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


    @RequestMapping("/executeForward")    
    public String executeForward(Model model, HttpServletRequest request) throws Exception
	{	
		String handlerMethodPath =  "/forwardMainPage/executeForward";    
		
		String QueryString = "SELECT PRODUCT_ID, CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION FROM products";    
		List<Product> productList = new ArrayList<Product>() ;
		List<Product> initialProductList = productService.getListProducts(QueryString); 
				
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
		model.addAttribute("productForm", new ProductForm());    
		model.addAttribute("cartSubtotal", cartSubtotal);
		model.addAttribute("cartItemNumber", cartItemNumber);
		
		request.getSession().removeAttribute("categoryId");      
		request.getSession().removeAttribute("categoryName");      

		return ".main.page";
	}

}



