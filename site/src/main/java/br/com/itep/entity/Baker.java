package br.com.itep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
public class Baker extends Person implements Serializable {

	@Column
	private int quantidadeProdutosProduzidos;
	
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

	public void addQntProduto(int qntProduto)
	{
		this.quantidadeProdutosProduzidos += qntProduto;
	}
	
}
