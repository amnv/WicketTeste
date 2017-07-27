package br.com.itep.page;
/**
 * @author allyson.manoel
 */
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import br.com.itep.entity.PersonBean;

public class LoginPage extends GenericPage {
	private Component formLogin;
	
	public LoginPage() {
		replace(new Label("login", "Login"));
		replace(new Link("home")
		{
			@Override
			public void onClick() {
				setResponsePage(GenericPage.class);	
			}
		});
		
		replace(formLogin = new FormLogin(super.CONTENT));	
	}
	
}
