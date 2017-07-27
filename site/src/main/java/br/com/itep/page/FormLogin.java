package br.com.itep.page;
/**
 * @author allyson.manoel
 */
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import br.com.itep.entity.PersonBean;

public class FormLogin extends Panel {
	private PersonBean person;
	
	public FormLogin(String id) {
		super(id);
		Form form;
		this.person = new PersonBean();
		form = new Form("form", new CompoundPropertyModel(person))
		{
			@Override
			protected void onSubmit() {
				super.onSubmit();
			}
		};

		form.add(new TextField("name"));
		form.add(new PasswordTextField("password"));
		add(form);
	}

}
