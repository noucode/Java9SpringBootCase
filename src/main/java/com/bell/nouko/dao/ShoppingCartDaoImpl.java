package com.bell.nouko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bell.nouko.domain.ShoppingCart;

@Repository(value = "shoppingCartDao")
public class ShoppingCartDaoImpl  implements ShoppingCartDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShoppingCartDaoImpl(JdbcTemplate jdbc) {
    	this.jdbcTemplate = jdbc;
    }
		
    
	public ShoppingCart getShoppingCartByPrimaryKey(Long shoppingCartId)
	{
		String sql = "SELECT * FROM shoppingcarts WHERE SHOPPINGCART_ID = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(ShoppingCart.class), shoppingCartId);
	}
	
	    
	public Long saveShoppingCart(ShoppingCart shoppingCart)	
	{
		return new Long(jdbcTemplate.update("insert into shoppingcarts  (SHOPPINGCART_ID,  SHOPPINGDATE, SHOPPINGCARTTOTAL)  values (?, ?, ?)",
				shoppingCart.getShoppingCartId(), shoppingCart.getShoppingDate(),  shoppingCart.getShoppingCarttotal()
		));
	}
	
	
	public void updateShoppingCart(ShoppingCart shoppingCart)
	{	
		jdbcTemplate.update("insert into shoppingcarts  (SHOPPINGCART_ID,  SHOPPINGDATE, SHOPPINGCARTTOTAL)  values (?, ?, ?)",
				shoppingCart.getShoppingCartId(), shoppingCart.getShoppingDate(),  shoppingCart.getShoppingCarttotal()
		);
	}
	
	

}

