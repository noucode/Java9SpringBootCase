package com.bell.nouko.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component("createdProductsList")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CreatedProductsList 
{
	/*** list of products created	*/
	private List<Product> createdProducts = new CopyOnWriteArrayList<Product>();
	
	public  CreatedProductsList() 	{
	}
	
	/** @return Returns the createdProducts.	*/
	public List getCreatedProducts() 
	{
		return createdProducts;
	}
	
	/** CAS1:  On ajoute tout produit saisi ou modifie
	 *   @param product  product	*/
	public void addProduct(Product product) 
	{
		createdProducts.add(product);
	}
	

	/** @param idProduct   idProduct to remove	*/
	public void removeProduct(int idProduct) 
	{
		for (int i = 0; i < createdProducts.size(); i++) 
		{ 
			if (((Product) createdProducts.get(i)).getProductId() == idProduct) 
			{
				createdProducts.remove(i);
			}
		}
	}
	
	
	/** @return une chaine representant le panier	*/
	public String toString() 
	{
		return this.createdProducts.toString();
	}

}

