package name.felixbecker.sandbox.springdata.web;

import name.felixbecker.sandbox.springdata.web.pages.AddUserPage;
import name.felixbecker.sandbox.springdata.web.pages.LandingPage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public abstract class MainTemplate extends WebPage {
	public MainTemplate(){
		add(new BookmarkablePageLink<LandingPage>("userOverviewLink", LandingPage.class));
		add(new BookmarkablePageLink<LandingPage>("addUserLink", AddUserPage.class));
		add(new Label("pageTitle", getPageTitle()));
		add(new FeedbackPanel("feedbackPanel"));
	}
	
	public abstract String getPageTitle();
}
