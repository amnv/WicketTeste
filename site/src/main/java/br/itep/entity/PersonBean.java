package br.itep.entity;
/**
 * @author allyson.manoel
 */
import java.util.Date;

public class PersonBean {
	private String name;
	private String email;
	private String cpf;
	private String password;
	private String cPassword;
	private Date date;

	
	public PersonBean(){}
	
	public PersonBean(String name, String email, String cpf, String password, String cPassword, Date date) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.cPassword = cPassword;
		this.date = date;
	}

	public boolean checkPassword()
	{
		return this.password.equals(this.cPassword);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
