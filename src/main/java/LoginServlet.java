import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	boolean check1;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password,emailId;
		PrintWriter out = resp.getWriter();
		//name=req.getParameter("name");
		password=req.getParameter("password");
		emailId=req.getParameter("email");
		
		userDetailsPojo udp = new userDetailsPojo();
		
		//udp.setName(name);
		udp.setPassword(password);
		udp.setEmailId(emailId);
		
		DBC d = new DBC();
		
		try {
			//out.print(check1);
			check1 = d.check(udp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(check1) {
			req.getRequestDispatcher("CheckServlet").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("login.html").include(req, resp);
			out.print("User not Found");
		}
		
	}
}
