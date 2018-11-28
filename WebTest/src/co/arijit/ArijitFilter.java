package co.arijit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ArijitFilter
 */
@WebFilter("/admin")
public class ArijitFilter implements Filter {

	public void destroy() {


	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		out.println("<h1>Pre-Processing....</h1>");
		
		if(uid.equals("ardeb") && pwd.equals("123")) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		out.println("<h1>Post-Processing....</h1>");

	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
