package br.com.itep.page;
/**
 * @author allyson.manoel
 */
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;


public class GenericPage extends WebPage {
	public static String CONTENT = "mainScreen";
	
	@SpringBean
	private IExample example;
	
	
	public GenericPage() {
		
		add(new Label(CONTENT, this.example.printf()));
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
