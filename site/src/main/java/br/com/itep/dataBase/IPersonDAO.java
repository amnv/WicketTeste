package br.com.itep.dataBase;

import java.util.List;

import org.hibernate.Session;

import br.com.itep.entity.Person;

public interface IPersonDAO {
	public void insert(Person person);
	public void delete(String cpf);
	public List<Person> list();
	public Person findByCPF(String cpf);
	public void resetDatabase();
	public Session getSession();
}
