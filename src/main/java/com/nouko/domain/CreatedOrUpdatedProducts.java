package com.nouko.domain;

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
	private static final long serialVersionUID = 1L;	

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
	

	/** @param idProduct   idProduct to remove 	*/
	public void removeProduct(Long idProduct) 
	{		
		productList.removeIf(product -> product.getProductId().intValue() == idProduct.intValue());
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
		productList.removeIf(product -> product.getProductId().intValue() == idProduct.intValue());		
		productList.add(aProduct);	
	}
	
	
	/** @return une chaine representant le panier	*/
	public String toString() 
	{
		return this.productList.toString();
	}

}
