package br.com.itep.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Seller extends Person {

	@Column
	private int qntSouldProduct;
	
	public Seller() {
	
	}

	public Seller(String name, String email, String cpf, String password, Date date, byte[] image1) {
		super(name, email, cpf, password, date, image1);
		this.qntSouldProduct = 0;
	}

	public Seller(String name, String email, String cpf, String password, Date date) {
		super(name, email, cpf, password, date);
		this.qntSouldProduct = 0;
	}

	public int getQntSouldProduct() {
		return qntSouldProduct;
	}

	public void setQntSouldProduct(int qntSouldProduct) {
		this.qntSouldProduct = qntSouldProduct;
	}
	
	public void addQntSouldProduct(int value)
	{
		this.qntSouldProduct += value;
	}
}
