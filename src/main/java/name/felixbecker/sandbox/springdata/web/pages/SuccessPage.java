package name.felixbecker.sandbox.springdata.web.pages;

import name.felixbecker.sandbox.springdata.web.MainTemplate;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;

public class SuccessPage extends MainTemplate{

	public SuccessPage(PageParameters parameters) {
		add(new Label("loginSuccessText", "User "+parameters.getString("username")+" logged in successfully."));
	}
	
	@Override
	public String getPageTitle() {
		return "Login successful";
	}

}
