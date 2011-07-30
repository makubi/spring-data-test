package name.felixbecker.sandbox.springdata.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.felixbecker.sandbox.springdata.entities.User;
import name.felixbecker.sandbox.springdata.services.UserService;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		HttpServletResponse response = (HttpServletResponse) resp;
		response.getWriter().println("oh hai!");
		// test the spring framework
		ServletContext servletContext =this.getServletContext();

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		UserService userService = (UserService)wac.getBean("userService");
		
		response.getWriter().println(userService.createUser("Hans", "Pansen", 42, "Goltsteinstrasse", "48"));
		response.getWriter().println(userService.createUser("Peter", "Fnord", 23, "Goltsteinstrasse", "2"));
		
		response.getWriter().println("<ul>");
		for(User user : userService.getAllUsers()){
			response.getWriter().println("<li>" + user + "</li>");
		}
		response.getWriter().println("</ul>");
		
		response.getWriter().println("Fnords:");
		for(User user : userService.getUserRepository().findByLastName("Fnord")){
			response.getWriter().println(user);

		}

		response.getWriter().println("Hans Pansen:");
		for(User user : userService.getUserRepository().findByFirstNameAndLastName("Hans", "Pansen" )){
			response.getWriter().println(user);

		}
		
		response.getWriter().println("Hans aus der Goltsteinstrasse:");
		for(User user : userService.getUserRepository().findByFirstNameAndAddressStreetName("Hans", "Goltsteinstrasse")){
			response.getWriter().println(user);
		}
		
		response.getWriter().println("Schinken");
		for(User user : userService.getUserRepository().schinken("Fnord")){
			response.getWriter().println(user);
		}

	}

	
}
