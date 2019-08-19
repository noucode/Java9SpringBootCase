package com.bell.nouko.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bell.nouko.form.ImageThumbnailForm;


@Controller
@RequestMapping("/forwardAddImage")
public class ForwardAddImageController 
{
    @RequestMapping("/addImageToProduct")    
    public String addImageToProduct(Model model, HttpServletRequest request) throws Exception
	{	
		model.addAttribute("fileUploadForm", new ImageThumbnailForm());   
		return ".page.add.imagetoproduct";
	}

}



