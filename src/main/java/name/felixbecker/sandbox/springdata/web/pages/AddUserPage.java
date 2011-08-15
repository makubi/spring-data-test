package name.felixbecker.sandbox.springdata.web.pages;

import name.felixbecker.sandbox.springdata.entities.User;
import name.felixbecker.sandbox.springdata.repositories.UserRepository;
import name.felixbecker.sandbox.springdata.web.MainTemplate;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class AddUserPage extends MainTemplate {
	private static final Logger LOG = Logger.getLogger(AddUserPage.class);
	
	@SpringBean private UserRepository userRepository;
	
	@Override
	public String getPageTitle() {
		return "Benutzer hinzufügen";
	}
	
	User newUser = new User();
	
	public AddUserPage(){
		
		LOG.debug("constructor called");
		LOG.debug("NewUser: " + newUser);
				
		Form<PropertyModel<User>> form = new Form<PropertyModel<User>>("addUserForm"){
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				LOG.debug("addUserForm submitted! User: " + newUser);
				userRepository.save(newUser);
				setResponsePage(LandingPage.class);
			}
			
		};
		
		form.add(new RequiredTextField<Integer>("username", new PropertyModel<Integer>(newUser, "username")));
		form.add(new PasswordTextField("password", new PropertyModel<String>(newUser, "password")));
		form.add(new TextField<String>("firstName", new PropertyModel<String>(newUser, "firstName")));
		form.add(new TextField<String>("lastName", new PropertyModel<String>(newUser, "lastName")));
		form.add(new TextField<Integer>("age", new PropertyModel<Integer>(newUser, "age")));

		add(form);
	}

}
