package com.bell.nouko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bell.nouko.dao.CategoryDao;
import com.bell.nouko.domain.Category;


@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService
{

	
    @Autowired
    @Qualifier(value = "categoryDao")
	private CategoryDao categoryDao;
	
	    
	

	@Override
	public Category readCategoryByPrimaryKey(Integer categoryId)	throws Exception
	{
	    return categoryDao.getCategoryByPrimaryKey(categoryId);
	}

	
	@Override
	public List <Category> getQueryListCategories(String QueryString)	throws Exception 
	{		
		return categoryDao.getQueryListCategories(QueryString) ;
	}
		
	

}

