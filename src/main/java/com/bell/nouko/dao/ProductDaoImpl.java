package com.bell.nouko.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.bell.nouko.domain.Product;
import com.bell.nouko.domain.ProductRowMapper;


@Repository(value = "productDao")
public class ProductDaoImpl  implements ProductDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImpl(JdbcTemplate jdbc) {
    	this.jdbcTemplate = jdbc;
    }
		
    
	public Product getProductByPrimaryKey(Long productId)
	{
		String sql = "SELECT * FROM products WHERE PRODUCT_ID = ?";
		return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), productId);	
	}
	
		    
	public void saveProduct(Product product)
	{
		jdbcTemplate.update("insert into productss  (PRODUCT_ID, CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION)  values (?, ?, ?, ?, ?, ?, ?, ?)",
				product.getProductId()	, product.getCategoryId(), product.getSerialNumber(),	product.getProdname(),	product.getProdprice(),	product.getStockQty(), product.getSize(), product.getDescription()
		);
	}
			
	
	public void updateProduct(Product product)
	{	
		jdbcTemplate.update("insert into productss  (CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION)  values (?, ?, ?, ?, ?, ?, ?, ?)",
				product.getCategoryId(), product.getSerialNumber(),	product.getProdname(),	product.getProdprice(),	product.getStockQty(), product.getSize(), product.getDescription()
		);
	}
	
	public void saveOrUpdateProduct(Product product)
	{	
		jdbcTemplate.update("insert into productss  (PRODUCT_ID, CATEGORY_ID, SERIALNUMBER, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY, SIZE, DESCRIPTION)  values (?, ?, ?, ?, ?, ?, ?, ?)",
				product.getProductId()	, product.getCategoryId(), product.getSerialNumber(),	product.getProdname(),	product.getProdprice(),	product.getStockQty(), product.getSize(), product.getDescription()
		);
	}
		
	
	public List <Product> getQueryListProducts(String QueryString) 
	{		
		return jdbcTemplate.query(QueryString, new RowMapper<Product>() {
		    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		});		
	}
		
}

