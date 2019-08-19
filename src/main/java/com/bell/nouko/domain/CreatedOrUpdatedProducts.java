package com.bell.nouko.domain;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component("createdOrUpdatedProducts")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CreatedOrUpdatedProducts implements Serializable
{
	/*** liste des produits saisis ou modifies	*/
	private List<Product> productList = new ArrayList<Product>();
	
		
	public CreatedOrUpdatedProducts()  {
	}
	
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	/** CAS1:  On ajoute tout produit saisi ou modifie
	 *   @param aProduct  a Product 	*/
	public void addProduct2(Product aProduct) 
	{
		this.productList.add(aProduct);
	}
	
	
	/** CAS2:  On n'ajoute que les produits saisis ou modifies qui n'ont pas encore ete ajoutes
	 *   @param aProduct  Product	*/						
	public void addProduct(Product aProduct) 
	{
		Long idProduct = aProduct.getProductId();		
		Product product = null;
		boolean trouve = false;
		
		for (int i = 0; !trouve && i < productList.size(); i++) 
		{
			product = (Product) productList.get(i);
			if ((product.getProductId()).intValue() == idProduct.intValue()) 
			{
				productList.remove(i);
				trouve=true;
			}
		}
		
		productList.add(aProduct);	
	}


	/** @param idProduct   idProduct to remove 	*/
	public void removeProduct(Long idProduct) 
	{
		for (int i = 0; i < productList.size(); i++) 
		{ 
			Product product = (Product) productList.get(i) ;
					
			if (product.getProductId().intValue() == idProduct.intValue()) 
			{
				System.out.println("mylist.size() = " + productList.size()) ;		
				this.productList.remove(i);
			}
		}
	}
	
	
	/** @return une chaine representant le panier	*/
	public String toString() 
	{
		return this.productList.toString();
	}

}
