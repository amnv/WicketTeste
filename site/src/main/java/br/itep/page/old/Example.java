package br.itep.page.old;

import org.springframework.stereotype.Service;

@Service
public class Example implements IExample {

	public Example() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String printf() {
		
		return "Saiu da jaula o Spring \nBIRLLLL";
	}

}
