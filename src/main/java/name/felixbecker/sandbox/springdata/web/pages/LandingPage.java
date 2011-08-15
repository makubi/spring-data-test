package name.felixbecker.sandbox.springdata.web.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import name.felixbecker.sandbox.springdata.entities.User;
import name.felixbecker.sandbox.springdata.repositories.UserRepository;
import name.felixbecker.sandbox.springdata.web.MainTemplate;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class LandingPage extends MainTemplate {
	private static final Logger logger = Logger.getLogger(LandingPage.class);
	
	@SpringBean private UserRepository userRepository;
	
	public LandingPage(){
		if(logger.isDebugEnabled()) logger.debug("Landing page constructor called, user repository: " + userRepository);
		
		List<User> users = new ArrayList<User>();
		Iterator<User> it = userRepository.findAll().iterator();
		while(it.hasNext()) users.add(it.next());
		add(new ListView<User>("list", users) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<User> item) {
				User nextItem = item.getModelObject();
				String username = nextItem.getUsername();
				String firstName = nextItem.getFirstName();
				String lastName = nextItem.getLastName();
				Integer age = nextItem.getAge();
				item.add(new Label("username", username+": "+(firstName!=null?firstName:"Unknown")+" "+(lastName!=null?firstName:"Unknown")+" "+(age!=null?""+age:"0")));
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
