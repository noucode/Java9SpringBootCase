package com.bell.nouko.service;

import java.util.List;

import com.bell.nouko.domain.Category;


public interface CategoryService 
{
	public Category readCategoryByPrimaryKey(Integer categoryId)	throws Exception;
	
	public List <Category> getQueryListCategories(String QueryString)	throws Exception ;

}
