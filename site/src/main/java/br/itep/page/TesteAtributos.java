package br.itep.page;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class TesteAtributos extends WebPage {
	public TesteAtributos() {
		Label a = new Label("a", "primeiro");
		a.add(new SimpleAttributeModifier("class", "outro"));
		add(a);
		Label b = new Label("b", "segundo");
		b.add(new SimpleAttributeModifier("id", "a"));
		add(b);
		
		
		add(new Label("c", "terceiro"));
	}
}
