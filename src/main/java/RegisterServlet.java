import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	int check;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name,password,email;
		
		
		name=req.getParameter("name");
		password=req.getParameter("password");
		email=req.getParameter("email");
		
		userDetailsPojo udp = new userDetailsPojo();
		udp.setName(name);
		udp.setEmailId(email);
		udp.setPassword(password);
		
		DBC d = new DBC();
		PrintWriter out = resp.getWriter();
		try {
			check = d.add(udp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(check<0) {
			req.getRequestDispatcher("register.html").include(req, resp);
			out.print("Registration Failed");
				
		}
		else {
			req.getRequestDispatcher("WelcomeServlet").forward(req, resp);
		}
		
	}

}
