package co.edureka;

import java.io.*;
import javax.servlet.*;

public class LifeCycleServlet extends GenericServlet {

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		System.out.println("Inside init method");

	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		System.out.println("Inside service method");

	}

	public void destroy() {

		System.out.println("Inside destroy method...");
	}

}
