package br.com.itep.report;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.collections4.map.HashedMap;

import br.com.itep.dataBase.HibernatePersonDAO;
import br.com.itep.entity.Person;
import net.sf.jasperreports.engine.JRException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, JRException {

		ArrayList<Integer> a =  new ArrayList<>();
		a.add(10);
		a.add(30);
		a.add(14);
		a.add(34);
		
		HibernatePersonDAO h = HibernatePersonDAO.getInstance();
		h.findByCPF("234");
		int b = a.stream().reduce(0, (x, y) -> x + y);
		System.out.println(b);
		/*File f1 = new File("img1.jpg");
		File f2 = new File("img2.jpg");
		byte[] img1 = Files.readAllBytes(f1.toPath());
		byte[] img2 = Files.readAllBytes(f2.toPath());
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d, img1); 
		Person p2 = new Person("carlos", "cas@cin.ufpe.br", "312", "123", d, img2);
		
		HibernatePersonDAO i = HibernatePersonDAO.getInstance();
		i.delete("123");
		i.delete("312");
		i.insert(p1);
		i.insert(p2);
		
		*/
		//RelatorioRPITeste rpi = new RelatorioRPITeste();
		//rpi.gerarRelatorioTeste();
		/*
		File f1 = new File("img/img1.jpg");
		byte[] img1 = Files.readAllBytes(f1.toPath());
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d, img1);
		
		Map<String, Object> parametros = new HashedMap<>();
		Vector<Person> p = new Vector<>();
		p.add(p1);
		DadosJrxml dados = new DadosJrxml("JRXMLSources/NoBancReport.jrxml", parametros);
		List<DadosJrxml> list = new ArrayList<>();
		list.add(dados);
		DadosRelatorio dadosRelatorio = new DadosRelatorio(list, new FileOutputStream("reports/teste1.pdf"));
		GenereteReport g = new GenereteReport();
		g.geraRelatorio(dadosRelatorio, p);
		
		//Connection connection = JDBCPersonDAO.getInstance().getConnection();
		//g.writeReport("Usuarios.jrxml", c, new FileOutputStream("saida.pdf"));
		List<String> filesName = new ArrayList();
		filesName.add("dadosPrincipais.jrxml");
		filesName.add("Imagens.jrxml");
		g.writeMutipageReport(filesName, connection, new FileOutputStream("multipageReport.pdf"));
		
		//Person p = i.findByCPF("123");
		//System.out.println(p.getImage1());
		*/
	}
}
