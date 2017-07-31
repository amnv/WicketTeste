package br.itep.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Baker extends AbstractPerson {

	@Column
	private int madeProductAmount;
	@ManyToMany(
			targetEntity = Product.class,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Product> product; 
	
	
	public Baker() {
		
	}

	public Baker(String name, String email, String cpf, String password, Date date, byte[] image1) {
		super(name, email, cpf, password, date, image1);
		this.madeProductAmount = 0;
	}

	public Baker(String name, String email, String cpf, String password, Date date) {
		super(name, email, cpf, password, date);
		this.madeProductAmount = 0;
	}

	public int getMadeProductAmount() {
		return madeProductAmount;
	}

	public void setMadeProductAmount(int quantidadeProdutosProduzidos) {
		this.madeProductAmount = quantidadeProdutosProduzidos;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public void  addProduct(Product product)
	{
		this.product.add(product);
		this.madeProductAmount += product.getAmountProduct();
	}
	
}
