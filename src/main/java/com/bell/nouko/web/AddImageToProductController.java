package com.bell.nouko.web;

import java.io.File;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;
import com.bell.nouko.domain.ImageThumbnail;
import com.bell.nouko.form.ImageThumbnailForm;
import com.bell.nouko.service.ProductService;


@Controller
@RequestMapping("/addImageToProduct")
public class AddImageToProductController 
{
    @Autowired
    @Qualifier(value="productService")
    private ProductService productService;
    
    		
    @RequestMapping(value = "/create")
    public String Create(@Valid @ModelAttribute("fileUploadForm") ImageThumbnailForm myImageThumbnailForm, BindingResult binding,
    		@RequestParam("productId") Long productId, @RequestParam("formfile") MultipartFile multipartFile ,
    		Model model, HttpServletRequest request ) throws Exception    
	{    	
	    
	    String imageName = multipartFile.getOriginalFilename();	    
	    String imagePath =  "resources/images/ecommerce/" + imageName ;
	    String imagePath2 = request.getContextPath() + "/resources/images/ecommerce/" + imageName ;
	    String fileSystemLocation = System.getenv("CATALINA_HOME") + "/webapps" + imagePath2 ;
	    	    
		// write the uploaded file to the filesystem
	    multipartFile.transferTo(new File( fileSystemLocation ));	
	    	    		    
		// save the file location to the DB
	    productService.addImageToProduct(new Long(productId), imagePath);	    
	    
		model.addAttribute("fileUploadForm", new ImageThumbnailForm());     
				
		return ".page.add.imagetoproduct";
	}
    
    
    
    @RequestMapping(value = "/update")
    public String Update(@Valid @ModelAttribute("imageThumbnailForm") ImageThumbnailForm myImageThumbnailForm, BindingResult binding,
    		Model model, HttpServletRequest request ) throws Exception    
	{
		String actionPath =  "/addImageToProduct/update";
	    Long productId  = myImageThumbnailForm.getProductId();
	    Integer position = myImageThumbnailForm.getPosition() ;
	    String imagePath =  myImageThumbnailForm.getImagePath() ;
	    
	    ImageThumbnail imageThumbnail = new ImageThumbnail() ;
	    imageThumbnail.setProductId(productId);
	    imageThumbnail.setPosition(position);
	    imageThumbnail.setImagePath(imagePath);
	    productService.updateImageParameterized(imageThumbnail);
	    
		String QueryList = "SELECT PRODUCT_ID, POSITION, IMAGEPATH FROM PRODUCTIMAGEPATH WHERE PRODUCT_ID = " + productId ;		
		List<ImageThumbnail> imageList = productService.findImageList(QueryList) ;
		
		model.addAttribute("aPath", actionPath);  		
		model.addAttribute("idProduct", productId);  		
		model.addAttribute("imageList", imageList);  	    
		model.addAttribute("imageThumbnailForm", new ImageThumbnailForm());     
					
		return ".page.list.images";
	}

}
