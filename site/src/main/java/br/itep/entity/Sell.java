package br.itep.entity;

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
	private Sell_composed_key pk;
	
	public Sell() {
		
	}

	public Sell_composed_key getPK() {
		return pk;
	}
}
