package br.com.itep.entity;

import java.util.Date;

public class Buyer extends Person {

	public Buyer() {
		// TODO Auto-generated constructor stub
	}

	public Buyer(String name, String email, String cpf, String password, Date date, byte[] image1) {
		super(name, email, cpf, password, date, image1);
		// TODO Auto-generated constructor stub
	}

	public Buyer(String name, String email, String cpf, String password, Date date) {
		super(name, email, cpf, password, date);
		// TODO Auto-generated constructor stub
	}

}
