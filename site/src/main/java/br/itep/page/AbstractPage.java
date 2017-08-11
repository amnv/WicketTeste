package br.itep.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class AbstractPage extends WebPage {
	public String content;
	public AbstractPage()
	{
		add(new Link(content = "content") {
			@Override
			public void onClick() {
				setResponsePage(LoginPage.class);
			}
		});
	}
}
