package br.itep.page.old;

/**
 * @author allyson.manoel
 */

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class RegisterPage extends GenericPage {

	public RegisterPage() {
		replace(new Label("cadastro", "Cadastro"));
		replace(new Link("home")
		{
			@Override
			public void onClick() {
				setResponsePage(GenericPage.class);	
			}
		});
	}
	
}
