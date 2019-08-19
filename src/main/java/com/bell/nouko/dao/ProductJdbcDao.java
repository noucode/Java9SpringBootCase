package com.bell.nouko.dao;

import java.util.List;

public interface ProductJdbcDao 
{
	public  List<Long> findProductIdList(String query) ;

}


