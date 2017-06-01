package br.com.itep.servico;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import br.com.itep.entity.Person;
import br.com.itep.entity.PersonBean;
import br.com.itep.exception.NonExistentException;

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

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCPF() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsLogged() {
		fail("Not yet implemented");
	}

}
