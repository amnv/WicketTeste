package br.itep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author allyson.manoel
 */

@Entity
@Table(name = "PEOPLE")
public class Person extends AbstractPerson implements Serializable {

	public Person() {
	}
	
	
	public Person(String name, String email, String cpf, String password, Date date) {
		super(name, email, cpf, password, date);
	}
	
	
	public Person(String name, String email, String cpf, String password, Date date, byte[] image1) {
		super(name, email, cpf, password, date, image1);
	}

}
