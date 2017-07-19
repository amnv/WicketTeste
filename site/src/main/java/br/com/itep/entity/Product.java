package br.com.itep.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product implements Serializable {

	@Id
	private int id;
	
	@Column
	private int amountProduct;
	
	@ManyToMany(mappedBy = "product")
	private List<Seller> seller;
	
	@ManyToMany(mappedBy = "product")
	private List<Baker> bakers;
	
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

	public List<Baker> getBakers() {
		return bakers;
	}

	public void setBakers(List<Baker> bakers) {
		this.bakers = bakers;
	}
}
