package br.com.itep.entity;

import javax.persistence.Entity;

@Entity
public class Product {

	private int id;
	private int amountProduct;
	
	public Product() {
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}
	
	/**
	 * Add qnt of products. Don't accept negative values
	 * @param value qnt of product to add
	 */
	public void addAmountProduct(int value)
	{
		if (value > 0) this.amountProduct += value;
	}
	
	/**
	 * @param Value to reduce. value don't accept negative values
	 */
	public void reduceAmountProduct(int value)
	{
		if (value > 0) this.amountProduct -= value;
	}
}
