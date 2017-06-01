package br.com.itep.servico;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import br.com.itep.entity.Person;
import br.com.itep.entity.PersonBean;
import br.com.itep.exception.AlreadyInsertedException;
import br.com.itep.exception.NonExistentException;
import br.com.itep.exception.WrongPasswordException;

public class TestService {
	
	@Test
	public void testInsert() {
		Service service = new Service();
		service.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		PersonBean p = new PersonBean("allyson", "amnv@cin.ufpe.br", cpf, "123", "123", d); 
		
		service.insert(p);
		service.findByCPF(cpf);
	}

	@Test(expected = AlreadyInsertedException.class)
	public void testInsertDuplicatePerson()
	{
		Service service = new Service();
		service.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		PersonBean p1 = new PersonBean("allyson", "amnv@cin.ufpe.br", cpf, "123", "123", d); 
		PersonBean p2 = new PersonBean("allyson", "amnv@cin.ufpe.br", cpf, "123", "123", d);
		
		
		service.insert(p1);
		service.insert(p2);
	}
	
	@Test(expected = WrongPasswordException.class)
	public void testSenhaNaoConfere()
	{
		Service service = new Service();
		service.resetDatabase();
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		PersonBean p1 = new PersonBean("allyson", "amnv@cin.ufpe.br", cpf, "123", "321", d);
		
		service.insert(p1);
		service.findByCPF(cpf);
	}

	@Test(expected = NonExistentException.class)
	public void testDelete() {
		Service service = new Service();
		service.resetDatabase();
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		PersonBean p = new PersonBean("allyson", "amnv@cin.ufpe.br", cpf, "123", "123", d); 
		
		service.insert(p);
		service.delete(cpf);
		service.findByCPF(cpf);
	}

	@Test(expected = NullPointerException.class)
	public void testDeleteUnexistentPerson()
	{
		Service service = new Service();
		service.resetDatabase();
		
		service.delete("21231");
	}
	
	@Test
	public void testList() {
		Service service = new Service();
		service.resetDatabase();

		assertEquals(0, service.list().size());
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		PersonBean p1 = new PersonBean("allyson", "amnv@cin.ufpe.br", cpf, "123", "123", d); 
		PersonBean p2 = new PersonBean("paulo", "pasg@cin.ufpe.br", "321", "321", "321", d);
		
		service.insert(p1);
		service.insert(p2);
		
		assertEquals(2, service.list().size());
	}

	@Test
	public void testEmptyList() 
	{
		Service service = new Service();
		service.resetDatabase();

		assertEquals(0, service.list().size());
	}
	
	
	@Test
	public void testFindByCPF() {
		Service service = new Service();
		service.resetDatabase();

		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		PersonBean expected = new PersonBean("allyson", "amnv@cin.ufpe.br", cpf, "123", "123", d);
		service.insert(expected);
		
		PersonBean actual = service.findByCPF(cpf);
		
		assertTrue(this.assertEqualsPerson(expected, actual));
	}

	@Test(expected = NonExistentException.class)
	public void testUnexistentCPF()
	{
		Service service = new Service();
		service.resetDatabase();
		service.findByCPF("123");
	}
	
	@Test
	public void testLogIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsLogged() {
		fail("Not yet implemented");
	}

	private boolean assertEqualsPerson(PersonBean expected, PersonBean actual)
	{
		return expected.getCpf().equals(actual.getCpf()) &&
		expected.getEmail().equals(actual.getEmail()) &&
		expected.getName().equals(actual.getName()) &&
		expected.getPassword().equals(actual.getPassword()) &&
		expected.getDate().equals(actual.getDate());
	}
}
