package com.nouko.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.nouko.domain.Product;
import static java.util.stream.Collectors.toList;


@Repository(value = "productJdbcDao")
public class ProductJdbcDaoImpl implements ProductJdbcDao
{
    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    								       
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
	public ProductJdbcDaoImpl() {
	}
		
	
	public  List<Long> findProductIdList(String query) 
	{	       
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		List<Map<String,Object>>rows = namedParameterJdbcTemplate.queryForList(query, namedParameters);
			    
	    List<Long> myList = rows.stream()
	    						 .map((Map<String, Object> row) -> (Long) row.get("PRODUCT_ID"))
	    						 .collect(toList());
	    return myList ;
	}
	
		
	public  List<Product> searchCatalogList(String query)  
	{	       
		List <Product> productList = new ArrayList<Product>();	    
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		List<Map<String,Object>>rows = namedParameterJdbcTemplate.queryForList(query, namedParameters);
		for (Map<String, Object> row : rows) 
		{
			Product product = new Product() ;
			product.setCreated((Date) row.get("CREATED"));
			product.setDescription((String) row.get("DESCRIPTION"));
			product.setProdname((String) row.get("PRODUCTNAME"));
			product.setProdprice((BigDecimal) row.get("PRODUCTPRICE"));
			product.setProductId((Long) row.get("PRODUCT_ID"));
			product.setSerialNumber((String) row.get("SERIALNUMBER"));
			product.setSize((String) row.get("SIZE"));
			product.setStockQty((Integer) row.get("STOCKQUANTITY"));
	    	productList.add(product);
		}
			    
	    return productList ;
	}
	
	
}

