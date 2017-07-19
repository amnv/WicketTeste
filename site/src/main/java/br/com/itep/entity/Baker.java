package br.com.itep.entity;

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
	private int quantidadeProdutosProduzidos;
	@ManyToMany(
			targetEntity = Product.class,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Product> product; 
	
	public Baker() {
		
	}

	public Baker(String name, String email, String cpf, String password, Date date, byte[] image1) {
		super(name, email, cpf, password, date, image1);
		this.quantidadeProdutosProduzidos = 0;
	}

	public Baker(String name, String email, String cpf, String password, Date date) {
		super(name, email, cpf, password, date);
		this.quantidadeProdutosProduzidos = 0;
	}

	public int getQuantidadeProdutosProduzidos() {
		return quantidadeProdutosProduzidos;
	}

	public void setQuantidadeProdutosProduzidos(int quantidadeProdutosProduzidos) {
		this.quantidadeProdutosProduzidos = quantidadeProdutosProduzidos;
	}

	public void  addProduct(Product product)
	{
		this.product.add(product);
		this.quantidadeProdutosProduzidos += product.getAmountProduct();
	}
	
}
