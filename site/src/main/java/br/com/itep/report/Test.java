package br.com.itep.report;
import java.io.File;
/**
 * @author allyson.manoel
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import br.com.itep.dataBase.HibernatePersonDAO;
import br.com.itep.dataBase.JDBCPersonDAO;
import br.com.itep.entity.Person;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		File img1 = new File("img1.jpg");
		File img2 = new File("img2.jpg");
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d, img1, img2); 
		Person p2 = new Person("carlos", "cas@cin.ufpe.br", "312", "123", d, img1, img2);
		
		HibernatePersonDAO i = HibernatePersonDAO.getInstance();
		i.delete("123");
		i.delete("312");
		i.insert(p1);
		i.insert(p2);
		
		/*
		RelatorioRPITeste rrpi = new RelatorioRPITeste();
		rrpi.gerarRelatorioTeste();
		GenereteReport g = new GenereteReport();
		Connection c = JDBCPersonDAO.getInstance().getConnection();
		g.writeReport("Usuarios.jrxml", c, new FileOutputStream("saida.pdf"));
*/		
		
		Person p = i.findByCPF("123");
		System.out.println(p.getImage1());
		System.out.println(p.getImage1().compareTo(p1.getImage1()));
		
	}
}
