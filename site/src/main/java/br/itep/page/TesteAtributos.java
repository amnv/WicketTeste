package br.itep.page;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class TesteAtributos extends WebPage {
	public TesteAtributos() {
		WebMarkupContainer a = new WebMarkupContainer("a");
		a.add(new WebMarkupContainer("as"));
		a.get("as").add(new SimpleAttributeModifier("id", "a"));
		add(a);
		Label b = new Label("b", "segundo");
		b.add(new SimpleAttributeModifier("id", "a"));
		add(b);
		
		add(new Label("c", "terceiro"));
	}
}
