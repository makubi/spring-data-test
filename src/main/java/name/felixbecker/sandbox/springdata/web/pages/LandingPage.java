package name.felixbecker.sandbox.springdata.web.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import name.felixbecker.sandbox.springdata.entities.User;
import name.felixbecker.sandbox.springdata.repositories.UserRepository;
import name.felixbecker.sandbox.springdata.web.MainTemplate;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class LandingPage extends MainTemplate {
	private static final Logger logger = Logger.getLogger(LandingPage.class);
	
	@SpringBean private UserRepository userRepository;
	
	public LandingPage(){
		if(logger.isDebugEnabled()) logger.debug("Landing page constructor called, user repository: " + userRepository);
		userRepository.save(new User("Felix", "becker", 42));
		LoadableDetachableModel<User> userModel = new LoadableDetachableModel<User>() {

			@Override
			protected User load() {
				return userRepository.findAll().iterator().next();
			}
		};
		
		add(new Label("firstName", new PropertyModel<String>(userRepository.findAll().iterator().next(), "firstName")));
		add(new Label("lastName", new PropertyModel<String>(userRepository.findAll().iterator().next(), "lastName")));
		add(new Label("age", new PropertyModel<Integer>(userRepository.findAll().iterator().next(), "age")));
		
		
		
		List<String> someList = Arrays.asList("first item", "second item", "third item");
		add(new ListView<String>("list", someList) {

		    @Override
		    protected void populateItem(ListItem<String> item) {
		        String text = item.getModelObject();
		        // Achtung: item.add(...)!
		        item.add(new Label("text", text));
		    }

		});
		
	}



	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public String getPageTitle() {
		return "Userübersicht";
	}
	
	
}
