package br.com.itep.servico;

import java.util.List;

import br.com.itep.dataBase.HibernatePersonDAO;
import br.com.itep.dataBase.IPersonDAO;
import br.com.itep.entity.Person;
import br.com.itep.entity.PersonBean;

public class Service {
	private IPersonDAO dataBase;
	
	public Service() {
		this.dataBase = HibernatePersonDAO.getInstance();
	}
	public void insert(PersonBean p)
	{
		Person person = this.buildPerson(p);
		this.dataBase.insert(person);
	}
	
	public void delete(String cpf)
	{
		
	}
	
	public List<PersonBean> list()
	{
		return null;
	}
	
	public PersonBean findByCPF(String cpf)
	{
		return null;
	}
	
	public void logIn(String email, String password)
	{
		
	}
	
	public boolean isLogged(PersonBean p)
	{
		return false;
	}
	
	public void resetDatabase()
	{
		this.dataBase.resetDatabase();
	}
	
	private Person buildPerson(PersonBean p)
	{
		return new Person(p.getName(), p.getEmail(), p.getCpf(), p.getcPassword(), p.getDate());
	}
	
	private PersonBean buildPersonBean(Person p)
	{
		return new PersonBean(p.getName(), p.getEmail(), p.getCpf(), p.getPassword(), p.getPassword(), p.getDate());
	}
}

