package br.com.itep.report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Vector;

import br.com.itep.entity.Person;

public class PersonFactory {
	
	public static Vector<Person> generateColection()
	{
		Vector<Person> p = new Vector<Person>();

		File f1 = new File("img/img1.jpg");
		File f2 = new File("img/img2.jpg");
		byte[] img1 = null;
		byte[] img2 = null;
		try {
			img1 = Files.readAllBytes(f1.toPath());
			img2 = Files.readAllBytes(f2.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		Date d = new Date();
		d.setTime((long) 123123);
		String cpf = "123";
		Person p1 = new Person("allyson", "amnv@cin.ufpe.br", cpf, "123", d, img1); 
		Person p2 = new Person("carlos", "cas@cin.ufpe.br", "312", "123", d, img2);
		p.add(p1);
		p.add(p2);
		
		return p;
	}
	
	public static Vector<Person> generateColection(Vector<Person> p)
	{
		return p;
	}
}
