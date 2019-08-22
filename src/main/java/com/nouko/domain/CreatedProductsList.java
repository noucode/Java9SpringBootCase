package com.nouko.domain;

import java.util.List;
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

	
	/** @param idProduct   idProduct to remove	*/
	public void removeProduct(int idProduct) 
	{		
		createdProducts.removeIf(product -> product.getProductId().intValue() == idProduct);	
	}
	
	
	/** @return Returns the createdProducts.	*/
	public List<Product> getCreatedProducts() 
	{
		return createdProducts;
	}
	
	/** CAS1:  On ajoute tout produit saisi ou modifie
	 *   @param product  product	*/
	public void addProduct(Product product) 
	{
		createdProducts.add(product);
	}

	
	/** @return une chaine representant le panier	*/
	public String toString() 
	{
		return this.createdProducts.toString();
	}

}

