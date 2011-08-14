package name.felixbecker.sandbox.springdata.web.pages;

import name.felixbecker.sandbox.springdata.repositories.UserRepository;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class LandingPage extends WebPage {
	private static final Logger logger = Logger.getLogger(LandingPage.class);
	
	@SpringBean private UserRepository userRepository;
	
	public LandingPage(){
		if(logger.isDebugEnabled()) logger.debug("Landing page constructor called, user repository: " + userRepository);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
}
