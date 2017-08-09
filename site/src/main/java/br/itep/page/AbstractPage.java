package br.itep.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class AbstractPage extends WebPage {
	public AbstractPage()
	{
		add(new Label("content", "funcinou"));
	}
}
