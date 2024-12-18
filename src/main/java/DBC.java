import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
    
public class DBC {
	
	Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public static Connection establishConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg_login_ayush" , "root" , "argaikar17052003@03");
		return conn;
	}
	
	public int add(userDetailsPojo udp) throws SQLException {
		
		String addUser = "insert into userDetails(userName,userPassword,userEmailId) values(?,?,?)";
		
		try {
			conn=DBC.establishConnection();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ps=conn.prepareStatement(addUser);
		ps.setString(1, udp.getName());
		ps.setString(2, udp.getPassword());
		ps.setString(3, udp.getEmailId());
		int check = ps.executeUpdate();
		
		return check;
		
	}
	
	public boolean check(userDetailsPojo udp) throws SQLException {
		
		String displayall = "select * from userDetails where userEmailId=? and userPassword=?";
		
		try {
			conn=DBC.establishConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//System.out.println(udp.getEmailId()+udp.getPassword());
		ps=conn.prepareStatement(displayall);
		ps.setString(1, udp.getEmailId());
		ps.setString(2, udp.getPassword());
		
		rs=ps.executeQuery();
		
		while(rs.next()) {
			//System.out.println(rs.getString("userPassword") + rs.getString("userEmailId"));
			return true;
		}
		
		return false;
	}
}
