package br.itep.page;

import org.apache.wicket.markup.html.basic.Label;

public class LoginPage extends AbstractPage {
	public LoginPage() {
		replace(new FormLogin(super.content));
		//replace(new Label(super.content, "content")));
	}
}
