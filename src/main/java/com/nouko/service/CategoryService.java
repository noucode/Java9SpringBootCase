package com.nouko.service;

import java.util.List;
import java.util.Optional;
import com.nouko.domain.Category;


public interface CategoryService 
{
	public Optional<Category> readCategoryByPrimaryKey(Integer categoryId, String sql)	throws Exception;
	public List <Category> getQueryListCategories(String QueryString)	throws Exception ;
}
