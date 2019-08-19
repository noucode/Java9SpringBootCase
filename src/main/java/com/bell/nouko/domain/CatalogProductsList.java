package com.bell.nouko.domain;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component("catalogProductsList")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CatalogProductsList  implements Serializable
{
	private static final long serialVersionUID = 1L;	

	/*** liste des produits du catalog pour affichage	*/
	private List<Product> productList = new CopyOnWriteArrayList<Product>();
	
		
	public CatalogProductsList()  {
	}
	
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}


