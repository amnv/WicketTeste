package br.com.itep.report;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import br.com.itep.dataBase.HibernatePersonDAO;
import br.com.itep.dataBase.JDBCPersonDAO;
import br.com.itep.entity.Person;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		File f1 = new File("img1.jpg");
		File f2 = new File("img2.jpg");
		byte[] img1 = Files.readAllBytes(f1.toPath());
		byte[] img2 = Files.readAllBytes(f2.toPath());
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d, img1); 
		Person p2 = new Person("carlos", "cas@cin.ufpe.br", "312", "123", d, img2);
		
		//HibernatePersonDAO i = HibernatePersonDAO.getInstance();
		//i.delete("123");
		//i.delete("312");
		//i.insert(p1);
		//i.insert(p2);
		
		
		//RelatorioRPITeste rrpi = new RelatorioRPITeste();
		//rrpi.gerarRelatorioTeste();
		GenereteReport g = new GenereteReport();
		Connection c = JDBCPersonDAO.getInstance().getConnection();
		g.writeReport("Usuarios.jrxml", c, new FileOutputStream("saida.pdf"));
		
		
		//Person p = i.findByCPF("123");
		//System.out.println(p.getImage1());		
	}
}
