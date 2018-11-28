package co.arijit;

//A Servlet to give response in plain test form
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

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
		out.println("<center><img src=images/img002.jpg width=100 height=100></center>");
		out.println("<hr color=yellow size=3>");
		out.println("Hello, " + request.getParameter("uid"));
		out.println("</body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

	public void destroy() {

	}

}