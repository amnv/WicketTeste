package br.com.itep.servico;
/**
 * @author allyson.manoel
 */
import java.util.ArrayList;
import java.util.List;

import br.com.itep.dataBase.HibernatePersonDAO;
import br.com.itep.dataBase.IPersonDAO;
import br.com.itep.entity.Person;
import br.com.itep.entity.PersonBean;
import br.com.itep.exception.WrongPasswordException;

public class Service {
	private IPersonDAO dataBase;
	
	public Service() {
		this.dataBase = HibernatePersonDAO.getInstance();
	}
	public void insert(PersonBean p)
	{
		if (p.checkPassword())
		{
			Person person = this.buildPerson(p);
			this.dataBase.insert(person);
		}
		else throw new WrongPasswordException();
	}
	
	public void delete(String cpf)
	{
		this.dataBase.delete(cpf);
	}
	
	public List<PersonBean> list()
	{
		List<PersonBean> list = new ArrayList<>();
	
		for (Person person : this.dataBase.list()) {
			list.add(this.buildPersonBean(person));
		}
		return list;
	}
	
	public PersonBean findByCPF(String cpf)
	{
		Person p = this.dataBase.findByCPF(cpf);
		return this.buildPersonBean(p);
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

