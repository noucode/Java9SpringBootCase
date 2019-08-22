package com.nouko.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.nouko.domain.Category;
import com.nouko.service.CategoryService;


/**
  Une requete AJAX utilise ce pgm qui interroge la BD, et retourne le resultat de la requete 
  sous forme de document JSON.
*/
@Controller
@RequestMapping("/categorySelection")
@SessionAttributes(value = { "categories" })
public class CategorySelectionController
{
    @Autowired
    @Qualifier(value="categoryService")
    private CategoryService categoryService;
        
    
    @RequestMapping(value = "/selectCategories")
	public @ResponseBody String selectCategories( @RequestParam String q, @RequestParam String sid, 
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception    
	{   	
    	String QueryString = "SELECT CATEGORY_ID, CATEGORYNAME, DESCRIPTION FROM categories";	   	
    	List<Category> categoriesList = categoryService.getQueryListCategories(QueryString) ;
    	  	    	
    	/** create root node  */
    	JSONObject categories  = new JSONObject() ;
    	List<JSONObject> myListe = new ArrayList<JSONObject>();    	
    	    	
    	for (Category category :  categoriesList) 
    	{
    		/** create a node */
	   		JSONObject categoryObj  = new JSONObject() ;
	   		
	   		/** create a line for the arraylist */
	   		categoryObj.put("categId", category.getCategId()) ;
	   		categoryObj.put("categname", category.getCategname()) ;
	   		
	   		/** add the line to the arraylist */
	   		myListe.add(categoryObj);
        }

    	categories.put("category", myListe) ;  // "category" sera utilisee client-side pour acceder aux donnees 
		model.addAttribute("categories", categories);     
   		    		
		return categories.toString();    	        
	}

}
