package br.itep.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Seller extends AbstractPerson {

	@Column
	private int qntSouldProduct;

	
	public Seller() {

	}

	public Seller(String name, String email, String cpf, String password, Date date, byte[] image1,
			List<Product> product) {
		super(name, email, cpf, password, date, image1);
		this.qntSouldProduct = 0;
		//this.setProduct(product);
	}

	public Seller(String name, String email, String cpf, String password, Date date, List<Product> product) {
		super(name, email, cpf, password, date);
		this.qntSouldProduct = 0;
		//this.setProduct(product);
	}

	public int getQntSouldProduct() {
		return qntSouldProduct;
	}

	public void setQntSouldProduct(int qntSouldProduct) {
		this.qntSouldProduct = qntSouldProduct;
	}

	public void addQntSouldProduct(int value) {
		this.qntSouldProduct += value;
	}
}
