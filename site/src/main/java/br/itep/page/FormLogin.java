package br.itep.page;


import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import br.itep.entity.PersonBean;

public class FormLogin extends Panel {
	private PersonBean person;
	public FormLogin(String id) {
		super(id);
		Form form = new Form("form", new CompoundPropertyModel(person));
		
		form.add(new TextField("login"));
		form.add(new PasswordTextField("senha"));
		
		
		add(form);
	}

}
