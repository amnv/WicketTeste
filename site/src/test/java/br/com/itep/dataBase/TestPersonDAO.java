package br.com.itep.dataBase;
/**
 * @author allyson.manoel
 */
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.itep.dataBase.IPersonDAO;
import br.itep.entity.Person;
import br.itep.exception.AlreadyInsertedException;
import br.itep.exception.NonExistentException;

public class TestPersonDAO {

	@Autowired
	IPersonDAO dataBase;
	@Test
	public void testInsert() {
		dataBase.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d);
		
		dataBase.insert(expected);
		Person actual = dataBase.findById(cpf);
		assertNotNull(actual);
		assertTrue(this.assertEqualsPerson(expected, actual));
	}

	/**
	 *Try to insert a person witch cpf have been already inserted  
	 */
	@Test(expected = AlreadyInsertedException.class)
	public void testInsetDuplicatePerson() {
		dataBase.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d);
		
		d.setTime((long) 123123);
		Person p2 = new Person("outro", "asd@cin.ufpe.br", cpf, "123", d);
		
		dataBase.insert(p1);
		dataBase.insert(p2);
	}
	
	@Test(expected = NonExistentException.class)
	public void testDelete() {
		dataBase.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123",d);
		
		//insert person and check if it's not null and the right person
		dataBase.insert(expected);
		Person actual = dataBase.findById(cpf);
		
		assertTrue(this.assertEqualsPerson(expected, actual));
		
		//delete person and check if it's still on dataBase
		dataBase.delete(cpf);
		dataBase.findById(cpf);
	}

	@Test(expected = NullPointerException.class)
	public void testeDeleteInexistentPerson()
	{
		dataBase.resetDatabase();
	
		dataBase.delete("123");
	}
	
	@Test
	public void testList() {
		//limpar banco
		dataBase.resetDatabase();
		
		//entities to be inserted
		Date d = new Date();
		d.setTime((long) 123123);
		Person p[] = new Person[4];
		p[0] = new Person("arthur", "ajew@cin.ufpe.br", "321", "123", d);
		p[1] = new Person("allyson", "amnv@cin.ufpe.br", "123", "123",d);
		p[2]= new Person("eric", "eric@cin.ufpe.br", "456", "123",d);
		p[3] = new Person("vinicius", "vini@cin.ufpe.br", "789", "123",d);
		
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
		dataBase.resetDatabase();
		
		assertEquals(0, dataBase.list().size());
	}
	
	@Test
	public void testfindById() {
		//clean the dataBase
		dataBase.resetDatabase();
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person expected = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d);
		dataBase.insert(expected);
		Person actual = dataBase.findById(cpf);
		assertNotNull(actual);
		assertTrue(this.assertEqualsPerson(expected, actual));
	}
	
	@Test(expected = NonExistentException.class)
	public void testfindByIdInexistentPeson() {
		// clean the dataBase
		dataBase.resetDatabase();
		
		dataBase.findById("123");
	}
	
	@Test
	public void testResetDateBase() {
		if(dataBase.list().size() == 0)
		{
			Date d = new Date();
			d.setTime((long) 123123);
			Person p[] = new Person[4];
			p[0] = new Person("arthur", "ajew@cin.ufpe.br", "321", "1234", d);
			p[1] = new Person("allyson", "amnv@cin.ufpe.br", "123", "123", d);
			p[2]= new Person("eric", "eric@cin.ufpe.br", "456", "123", d);
			p[3] = new Person("vinicius", "vini@cin.ufpe.br", "789", "123", d);
		}
		
		
		dataBase.resetDatabase();
		assertEquals(0, dataBase.list().size());
	}
	
	
	private boolean assertEqualsPerson(Person expected, Person actual)
	{
		return expected.getCpf().equals(actual.getCpf()) &&
		expected.getEmail().equals(actual.getEmail()) &&
		expected.getName().equals(actual.getName()) &&
		expected.getPassword().equals(actual.getPassword()) &&
		expected.getDate().equals(actual.getDate());
	}
}
