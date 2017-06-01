package br.com.itep.dataBase;

import java.util.Date;

import br.com.itep.entity.Person;

public class zxc {

	public static void main(String[] args) {
		IPersonDAO i =  HibernatePersonDAO.getInstance();
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "3456";
		Person expected = new Person("asda", "asdasd@cin.ufpe.br", cpf, d);
		expected.setCpf(cpf);
		i.insert(expected);
		
		System.out.println(i.list().size());
		i.resetDatabase();
		System.out.println(i.list().size());
		
		//i.list();
		
		
	}

}
