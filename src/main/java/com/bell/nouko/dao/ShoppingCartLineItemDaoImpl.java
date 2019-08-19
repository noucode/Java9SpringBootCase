package com.bell.nouko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bell.nouko.domain.ShoppingCartLineItem;


@Repository(value = "shoppingCartLineItemDao")
public class ShoppingCartLineItemDaoImpl  implements ShoppingCartLineItemDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShoppingCartLineItemDaoImpl(JdbcTemplate jdbc) {
    	this.jdbcTemplate = jdbc;
    }
		
    
	public ShoppingCartLineItem getShoppingCartLineItemByPrimaryKey(Long shoppingCartLineItemId)
	{
		String sql = "SELECT * FROM shoppingcartlines WHERE SHOPPINGCARTLINE_ID = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(ShoppingCartLineItem.class), shoppingCartLineItemId);
	}
	
	    
	public void saveShoppingCartLineItem(ShoppingCartLineItem shoppingCartLineItem)
	{
		jdbcTemplate.update("insert into shoppingcartlines  (SHOPPINGCARTLINE_ID,  QUANTITY, PRODUCT_ID, SHOPPINGCART_ID)  values (?, ?, ?)",
				shoppingCartLineItem.getShoppingCartLineItemId(), shoppingCartLineItem.getQuantity(),  shoppingCartLineItem.getProduct(), shoppingCartLineItem.getShoppingCart().getShoppingCartId()
		);
	}
	

}
