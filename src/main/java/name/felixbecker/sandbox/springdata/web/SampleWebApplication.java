package name.felixbecker.sandbox.springdata.web;

import name.felixbecker.sandbox.springdata.web.pages.LandingPage;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class SampleWebApplication extends WebApplication {

	public void init() {
		super.init();
		// benoetigt damit die @SpringBean annotations in den WebPages funktionieren
		addComponentInstantiationListener(new SpringComponentInjector(this));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return LandingPage.class;
	}

}
