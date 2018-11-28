package co.edureka;

//A Servlet to give response in plain test form
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HtmlTextServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		System.out.println("Inside init method");

	}

	/*
	 * public void service(ServletRequest request,ServletResponse response) throws
	 * ServletException,IOException {
	 * 
	 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
	 * out.println("Welcome to servlet @localhost");
	 * 
	 * }
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html> <body bgcolor=maroon text=white>");
		out.println("<h1 align=center>Arijit Here</h1>");
		out.println("<h3 align=center>Singapore</h3>");
		out.println("<center><img src=images/img002.jpg></center>");
		out.println("</body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

	public void destroy() {

	}

}
