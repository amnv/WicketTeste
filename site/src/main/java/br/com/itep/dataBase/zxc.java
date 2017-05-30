package br.com.itep.dataBase;

import br.com.itep.entity.Person;

public class zxc {

	public static void main(String[] args) {
		IPersonDAO i =  HibernatePersonDAO.getInstance();
		i.insert(new Person());
	}

}
