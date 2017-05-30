package br.com.itep.dataBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.itep.entity.Person;
import br.com.itep.exception.AlreadyInsertedException;
import br.com.itep.exception.NonExistentException;

public class TestPersonDAO {

	@Test
	public void testInsert() {
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
	//	dataBase.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, d);
		
		dataBase.insert(expected);
		Person actual = dataBase.findByCPF(cpf);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	/**
	 *Try to insert a person witch cpf have been already inserted  
	 */
	@Test(expected = AlreadyInsertedException.class)
	public void testInsetDuplicatePerson() {
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
		dataBase.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, d);
		
		Date d2 = new Date();
		d.setTime((long) 123123);
		Person p2 = new Person("outro", "asd@cin.ufpe.br", cpf, d);
		
		dataBase.insert(p1);
		dataBase.insert(p2);
	}
	
	@Test
	public void testDelete() {
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
		dataBase.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, d);
		
		//insert person and check if it's not null and the right person
		dataBase.insert(expected);
		Person actual = dataBase.findByCPF(cpf);
		assertNotNull(actual);
		assertEquals(expected, actual);
		
		//delete person and check if it's still on database
		dataBase.delete(cpf);
		actual = dataBase.findByCPF(cpf);
		assertNull(actual);	
	}

	@Test(expected = NonExistentException.class)
	public void testeDeleteInexistentPerson()
	{
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
		dataBase.resetDatabase();
		
		dataBase.delete("123");
	}
	
	@Test
	public void testList() {
		//limpar banco
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
		dataBase.resetDatabase();
		
		//entities to be inserted
		Date d = new Date();
		d.setTime((long) 123123);
		Person p[] = new Person[4];
		p[0] = new Person("arthur", "ajew@cin.ufpe.br", "321", d);
		p[1] = new Person("allyson", "amnv@cin.ufpe.br", "123", d);
		p[2]= new Person("eric", "eric@cin.ufpe.br", "456", d);
		p[3] = new Person("vinicius", "vini@cin.ufpe.br", "789", d);
		
		//insert person and check if it's not null and the right person
		for (int i = 0; i < p.length; i++) {
			dataBase.insert(p[i]);
		}

		List<Person> list = dataBase.list();
		assertNotNull(list);
		
		assertEquals(p.length, list.size());
		
		//improve this part
		for (Person person : list) {
			assertNotNull(person);
		}
	}
	
	@Test
	public void testEmptyList()
	{
		//limpar banco
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
		dataBase.resetDatabase();
		
		assertNull(dataBase.list());
	}
	
	@Test
	public void testFindByCPF() {
		//clean the database
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
		dataBase.resetDatabase();

		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, d);
		
		dataBase.insert(expected);
		Person actual = dataBase.findByCPF(cpf);
		assertNotNull(actual);
		assertEquals(expected, actual);

		
	}
	
	@Test(expected = NonExistentException.class)
	public void testfindByCPFInexistentPeson() {
		// clean the database
		IPersonDAO dataBase = HibernatePersonDAO.getInstance();
		dataBase.resetDatabase();
		
		dataBase.findByCPF("123");
	}

}
