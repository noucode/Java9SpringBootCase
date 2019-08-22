package com.nouko.dao;

import java.util.List;
import java.util.Optional;
import com.nouko.domain.Category;

public interface CategoryDao 
{	
	public Optional<Category> getCategoryByPrimaryKey(Integer categId, String sql);
	public List <Category> getQueryListCategories(String QueryString); 
	
}
