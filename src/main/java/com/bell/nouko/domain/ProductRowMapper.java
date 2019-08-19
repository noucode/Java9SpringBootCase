package com.bell.nouko.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class ProductRowMapper implements RowMapper<Product>
{
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
    	Product product = new Product();
    	
    	product.setProductId(rs.getLong("PRODUCT_ID"));				
    	product.setCategoryId(rs.getInt("CATEGORY_ID"));
    	product.setSerialNumber(rs.getString("SERIALNUMBER"));
    	product.setProdname(rs.getString("PRODUCTNAME"));
    	product.setProdprice(rs.getBigDecimal("PRODUCTPRICE"));
    	product.setStockQty(rs.getInt("STOCKQUANTITY"));
    	product.setSize(rs.getString("SIZE"));
    	product.setDescription(rs.getString("DESCRIPTION"));
		return product;
    }

}

