package br.com.itep.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Chave_Ternario implements Serializable {
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	@OneToOne(cascade = CascadeType.ALL)
	private Seller seller;
	@OneToOne(cascade = CascadeType.ALL)
	private Buyer buyer;
	
	public Chave_Ternario() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	

}
