package br.com.itep.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "USU_SEQ", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize = 1)
public class Buyer extends AbstractPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USU_SEQ")
	private Long id;
	
	public Buyer() {
	}

	public Buyer(String name, String email, String cpf, String password, Date date, byte[] image1) {
		super(name, email, cpf, password, date, image1);
	}

	public Buyer(String name, String email, String cpf, String password, Date date) {
		super(name, email, cpf, password, date);
	}

}
