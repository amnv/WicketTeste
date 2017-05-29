package br.com.itep.dataBase;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.itep.entity.Person;

public class PersonDAOTest {

	@Test
	public void testInsert() {
		Date d = new Date();
		d.setTime((long) 123123);
		Person p = new Person("allyson", "amnv@cin.ufpe.br", "123", d);
		
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCPF() {
		fail("Not yet implemented");
	}

}
