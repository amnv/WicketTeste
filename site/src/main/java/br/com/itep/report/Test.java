package br.com.itep.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import br.com.itep.dataBase.HibernatePersonDAO;
import br.com.itep.dataBase.JDBCPersonDAO;
import br.com.itep.entity.Person;
import br.com.itep.entity.PersonBean;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
		/*
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d); 
		Person p2 = new Person("carlos", "cas@cin.ufpe.br", "312", "123", d);
		
		HibernatePersonDAO i = HibernatePersonDAO.getInstance();		
		i.insert(p1);
		i.insert(p2);
		*/
		GenereteReport g = new GenereteReport();
		Connection c = JDBCPersonDAO.getInstance().getConnection();
		g.writeReport("Usuarios.jrxml", c, new FileOutputStream("saida.pdf"));
		
	}
}
