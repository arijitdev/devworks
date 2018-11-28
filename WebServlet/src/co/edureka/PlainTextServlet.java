package co.edureka;

//A Servlet to give response in plain test form
import java.io.*;
import javax.servlet.*;

public class PlainTextServlet extends GenericServlet {

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		System.out.println("Inside init method");

	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("Welcome to servlet @localhost");

	}

	public void destroy() {

	}

}
