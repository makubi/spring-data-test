package name.felixbecker.sandbox.springdata.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().println(userService.createUser("bla", "foo", 42));
		
	}

	
}
