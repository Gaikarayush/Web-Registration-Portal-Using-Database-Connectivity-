import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{
//	boolean check1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String name,emailId,password;
		PrintWriter out = resp.getWriter();
//		userDetailsPojo udp = new userDetailsPojo();
//		
//		resp.setContentType("text/html");
//		
//		name=req.getParameter("name");
//		password=req.getParameter("password");
//		emailId=req.getParameter("email");
//		
//		
//		
//		//udp.setName(name);
//		udp.setPassword(password);
//		udp.setEmailId(emailId);
//		
//		DBC d = new DBC();
//		
//		try {
//			//out.print(check1);
//			check1 = d.check(udp);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(check1) {
//			out.print("Welcome " + udp.getName() + " Your email is: " + udp.getEmailId());
//			out.print("<br>Successfully Login");
//		}
//		else {
//			out.print("Something went Wrong");
//		}
		
		out.print("Login Successfull");
		
	}
}
