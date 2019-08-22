package com.nouko.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.nouko.domain.Category;
import org.springframework.dao.EmptyResultDataAccessException ;


@Repository(value = "categoryDao")
public class CategoryDaoImpl  implements CategoryDao
{   
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(JdbcTemplate jdbc) {
    	this.jdbcTemplate = jdbc;
    }
    	    
	
	public Optional<Category> getCategoryByPrimaryKey(Integer categId, String sql)
	{
		try {
			return Optional.of(jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Category.class), categId));
		} 
		catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}		
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
