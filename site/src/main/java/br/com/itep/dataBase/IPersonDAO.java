package br.com.itep.dataBase;

import java.util.List;

import br.com.itep.entity.Person;

public interface IPersonDAO {
	public void insert(Person pessoa);
	public void delete(String cpf);
	public List<Person> list();
	public Person findByCPF(String cpf);
	public void resetDatabase();
}
