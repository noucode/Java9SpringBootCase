package com.bell.nouko.web;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/forwardAdminPage")
@SessionAttributes(value = { "productList",	"oldPath" })
public class ForwardAdminPageController 
{
    @RequestMapping("/executeForward")    
    public String executeForward(Model model, HttpServletRequest request) throws Exception
	{	
		return ".admin.page";
	}

}





