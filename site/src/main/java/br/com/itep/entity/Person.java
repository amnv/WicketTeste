package br.com.itep.entity;
import java.io.File;
/**
 * @author allyson.manoel
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name = "PEOPLE_TABLE")
public class Person implements Serializable {
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
	private File image1;
	@Lob
	private File image2;
	
	public Person() {
	}
	
	public Person(String name, String email, String cpf, String password, Date date, File image1, File image2) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.date = date;
		this.image1 = image1;
		this.image2 = image2;
	}
	
	public Person(String name, String email, String cpf, String password, Date date) {
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

	public File getImage1() {
		return image1;
	}

	public void setImage1(File image1) {
		this.image1 = image1;
	}

	public File getImage2() {
		return image2;
	}

	public void setImage2(File image2) {
		this.image2 = image2;
	}

}
