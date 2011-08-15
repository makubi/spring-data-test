package name.felixbecker.sandbox.springdata.web.pages;

import name.felixbecker.sandbox.springdata.entities.User;
import name.felixbecker.sandbox.springdata.repositories.UserRepository;
import name.felixbecker.sandbox.springdata.web.MainTemplate;

import org.apache.log4j.Logger;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class LoginPage extends MainTemplate {

	private static final Logger logger = Logger.getLogger(LoginPage.class);
	
	@SpringBean private UserRepository userRepository;
	
	private User loginUser = new User();
	
	public LoginPage() {
		if(logger.isDebugEnabled()) logger.debug("Landing on "+getClass().getSimpleName());
		
		final RequiredTextField<String> usernameField = new RequiredTextField<String>("username", new PropertyModel<String>(loginUser, "username"));
		
		Form<PropertyModel<User>> form = new Form<PropertyModel<User>>("loginForm"){
			@Override
			protected void onSubmit() {
				
				User userToLogin = userRepository.findByUsername(loginUser.getUsername());
				if(userToLogin != null) {
					if(logger.isDebugEnabled()) logger.debug("Found user "+userToLogin.getUsername()+" in the database.");
					
					if(loginUser.getPassword().equals(userToLogin.getPassword())) {
						if(logger.isDebugEnabled()) logger.debug("Logged user "+userToLogin.getUsername()+" in, password matched.");
						
						PageParameters pageParameters = new PageParameters();
						pageParameters.add("username", usernameField.getModelObject());
						setResponsePage(SuccessPage.class, pageParameters);
					}
				}
				else {
					if(logger.isDebugEnabled()) logger.debug("Did not find user in the database.");
				}
			}
		};
		form.add(usernameField);
		form.add(new PasswordTextField("password", new PropertyModel<String>(loginUser, "password")));
		
		add(form);
	}
	
	@Override
	public String getPageTitle() {
		return "Login";
	}

}
