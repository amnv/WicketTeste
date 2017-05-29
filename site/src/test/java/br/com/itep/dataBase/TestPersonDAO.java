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

public class TestPersonDAO {

	@Test
	public void testInsert() {
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, d);
		PersonDAO dateBase = new PersonDAO();
		dateBase.insert(expected);
		Person actual = dateBase.findByCPF(cpf);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testDelete() {
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, d);
		PersonDAO dateBase = new PersonDAO();

		//insert person and check if it's not null and the right person
		dateBase.insert(expected);
		Person actual = dateBase.findByCPF(cpf);
		assertNotNull(actual);
		assertEquals(expected, actual);
		
		//delete person and check if it's still on database
		dateBase.delete(cpf);
		actual = dateBase.findByCPF(cpf);
		assertNull(actual);	
	}

	@Test
	public void testList() {
		Date d = new Date();
		d.setTime((long) 123123);
		Person p[] = new Person[4];
		p[0] = new Person("arthur", "ajew@cin.ufpe.br", "321", d);
		p[1] = new Person("allyson", "amnv@cin.ufpe.br", "123", d);
		p[2]= new Person("eric", "eric@cin.ufpe.br", "456", d);
		p[3] = new Person("vinicius", "vini@cin.ufpe.br", "789", d);
		
		//insert person and check if it's not null and the right person
		PersonDAO dateBase = new PersonDAO();
		for (int i = 0; i < p.length; i++) {
			dateBase.insert(p[i]);
		}

		List<Person> list = dateBase.list();
		assertNotNull(list);
		
		//improve this part
		for (Person person : list) {
			assertNotNull(person);
			for (int i = 0; i < p.length; i++) {
				//test if the person is one of the added
				
			}
		}
	}
	@Test
	public void testFindByCPF() {
		fail("Not yet implemented");
	}

}
