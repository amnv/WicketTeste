package br.itep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPerson implements Serializable {
	@Id
	private String cpf;
	
	@Column(name = "DATA_NASCIMENTO")
	private Date date;
	
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private byte[] image1;

	
	public AbstractPerson() {
	}
	
	public AbstractPerson(String name, String email, String cpf, String password, Date date, byte[] image1) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.date = date;
		this.image1 = image1;
	}
	
	public AbstractPerson(String name, String email, String cpf, String password, Date date) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.date = date;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}
}
