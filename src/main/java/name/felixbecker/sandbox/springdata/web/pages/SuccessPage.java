package name.felixbecker.sandbox.springdata.web.pages;

import name.felixbecker.sandbox.springdata.web.MainTemplate;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.util.string.Strings;

public class SuccessPage extends MainTemplate{

	public SuccessPage(PageParameters parameters) {
		CharSequence escapedUsername = Strings.escapeMarkup(parameters.getString("username"));
		add(new Label("loginSuccessText", "User <b>"+escapedUsername+"</b> logged in successfully.").setEscapeModelStrings(false));
	}
	
	@Override
	public String getPageTitle() {
		return "Login successful";
	}

}
