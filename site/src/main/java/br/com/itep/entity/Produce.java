package br.com.itep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Produce implements Serializable {
	@Column
	private Date date;
	@EmbeddedId
	private ComposeKey fk;

	public Produce() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ComposeKey getFk() {
		return fk;
	}

	public void setFk(ComposeKey fk) {
		this.fk = fk;
	}

	@Embeddable
	public class ComposeKey implements Serializable {
		@OneToOne(cascade = CascadeType.ALL)
		private Baker baker;
		@OneToOne(cascade = CascadeType.ALL)
		private Product product;
		@Column
		private long lote;

		public ComposeKey() {

		}

		public Baker getBaker() {
			return baker;
		}

		public void setBaker(Baker baker) {
			this.baker = baker;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

	}

}
