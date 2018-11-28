package co.arijit;

//A Servlet to give response in plain test form
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static PreparedStatement pst = null;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "aRijit1@3");
			pst = connection.prepareStatement("select * from users where username=? and password=?");
		} catch (Exception e) {

			e.printStackTrace();

		}

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

		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");

		try {
			pst.setString(1, uid);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println("username = " + rs.getString(2) + " password = " + rs.getString(3));
				if (uid.equals(rs.getString(2)) && pwd.equals(rs.getString(3))) {
					// valid user

					RequestDispatcher rd = request.getRequestDispatcher("admin");
					rd.forward(request, response);

				} else {
					// invalid user

					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println(
							"<p style=color:cyan;font-size:20px;text-align:center>Invalid Username/Password!!!!</p>");

					RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					rd.include(request, response);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

	public void destroy() {

	}
}
