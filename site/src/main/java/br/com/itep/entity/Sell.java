package br.com.itep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Sell implements Serializable 
{
	@EmbeddedId
	private Chave_Ternario pk;
	
	@Column
	private Date date;
	
	public Sell() {
		
	}

	public Chave_Ternario getPk() {
		return pk;
	}

	public void setPk(Chave_Ternario pk) {
		this.pk = pk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
