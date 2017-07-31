package br.itep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CashDesk implements Serializable {

	@Id
	private String id;
	
	@Column
	private double cash;
	
	public CashDesk() {
			
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public void addCash(double value)
	{
		this.cash += value;
	}
}
