package br.itep.dataBase.hibernateImplementation;

import java.util.Date;

import br.itep.entity.Baker;
import br.itep.entity.Product;

public class Teste {

	public static void main(String[] args) {

		Baker b = new Baker("Padeiro", "a", "234", "123", new Date());
		Product p = new Product();
		Middle m = new Middle();
		m.add(b, p);
	}

}
