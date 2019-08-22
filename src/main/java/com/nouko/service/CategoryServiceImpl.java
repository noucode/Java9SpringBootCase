package com.nouko.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.nouko.dao.CategoryDao;
import com.nouko.domain.Category;


@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    @Qualifier(value = "categoryDao")
	private CategoryDao categoryDao;
	

	@Override
	public Optional<Category> readCategoryByPrimaryKey(Integer categoryId, String sql)	throws Exception
	{
	    return categoryDao.getCategoryByPrimaryKey(categoryId, sql);
	}

	
	@Override
	public List <Category> getQueryListCategories(String QueryString)	throws Exception 
	{		
		return categoryDao.getQueryListCategories(QueryString) ;
	}
		
}

