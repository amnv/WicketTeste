package br.com.itep;
/**
 * @author allyson.manoel
 */
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class GenericPage extends WebPage {
	public static String CONTENT = "mainScreen";
	
	public GenericPage(final PageParameters p) {
		super(p);
		
		add(new Label(CONTENT, "ass"));
		add(new Label("home", "home"));
		add(new Link("login") {
			@Override
			public void onClick() {
				setResponsePage(LoginPage.class);
			}
		});
		
		add(new Link("cadastro") {
			@Override
			public void onClick() {
				setResponsePage(RegisterPage.class);
			}
		});
	}
}
