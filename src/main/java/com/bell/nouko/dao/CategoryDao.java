package com.bell.nouko.dao;

import java.util.List;

import com.bell.nouko.domain.Category;

public interface CategoryDao 
{	
	public Category getCategoryByPrimaryKey(Integer categId);
	public void saveOrUpdateCategory(Category category);		
	public List <Category> getQueryListCategories(String QueryString); 
	
}
