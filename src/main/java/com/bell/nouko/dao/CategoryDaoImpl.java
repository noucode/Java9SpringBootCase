package com.bell.nouko.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bell.nouko.domain.Category;
import com.bell.nouko.domain.Product;


@Repository(value = "categoryDao")
public class CategoryDaoImpl  implements CategoryDao
{
    
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(JdbcTemplate jdbc) {
    	this.jdbcTemplate = jdbc;
    }
    	    
	
	public Category getCategoryByPrimaryKey(Integer categId)
	{
		String sql = "SELECT * FROM categories WHERE CATEGORY_ID = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Category.class), categId);
	}

	
	public void saveOrUpdateCategory(Category category)
	{	
		jdbcTemplate.update("insert into categories  (CATEGORY_ID, CATEGORYNAME,  DESCRIPTION)  values (?, ?)",
				category.getCategname(), category.getDescription()
		);
	}
		
	
	public List <Category> getQueryListCategories(String QueryString) 
	{				
		return jdbcTemplate.query(QueryString, new RowMapper<Category>() {
		    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	Category category = new Category();
		    	category.setCategId(rs.getInt(1));				
		    	category.setCategname(rs.getString(2));
		    	category.setDescription(rs.getString(3));
				return category;
		    }
		});		
	}
	
}
