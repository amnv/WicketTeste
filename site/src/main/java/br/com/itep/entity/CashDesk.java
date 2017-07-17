package br.com.itep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CashDesk {

	@Column
	private int id;
	
	@Column
	private double cash;
	
	public CashDesk() {
			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
