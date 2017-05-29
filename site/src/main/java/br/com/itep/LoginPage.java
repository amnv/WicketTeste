package br.com.itep;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class LoginPage extends GenericPage {

	public LoginPage(PageParameters p) {
		super(p);
		replace(new Label("login", "Login"));
		replace(new Link("home")
		{
			@Override
			public void onClick() {
				setResponsePage(GenericPage.class);	
			}
		});
	}

}
