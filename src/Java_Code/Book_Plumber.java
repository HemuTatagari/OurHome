package Java_Code;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Book_Plumber")
public class Book_Plumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String password = request.getParameter("password");
		
		try {
			HttpSession session2 = request.getSession(false);
			String userName = (String) session2.getAttribute("userName");
			String groupName = (String) session2.getAttribute("groupName");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			String sql = "select * from "+ groupName +" where userName = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("password").equals(password)) {
					String sql1 = "select * from "+ groupName +"_PlumbList ";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ResultSet rs1 = ps1.executeQuery();
					
					int flag = 1;
					while(rs1.next()) {
						if(rs1.getString("status").equals("available")) {
							flag = 0;
							String plumb_name = rs1.getString("name");
							
							String sql2 = "insert into "+ groupName +"_PlumbReq values(?,?)";
							PreparedStatement ps2 = con.prepareStatement(sql2);
							ps2.setString(1, userName );
							ps2.setString(2, plumb_name);
							
							ps2.executeUpdate();
							
							String sql3 = "update "+ groupName +"_PlumbList set status = ? where name= ?";
							PreparedStatement ps3 = con.prepareStatement(sql3);
							ps3.setString(1, "booked" );
							ps3.setString(2, plumb_name);
							
							ps3.executeUpdate();
							
							
							response.sendRedirect("PlumbBooking_Succesfull.jsp");
							break ;
						}
					} 
					
					if(flag == 1 ) {
						response.sendRedirect("PlumbBooking_Unsucessfull.jsp");
					}
					
					
				} else {
					response.sendRedirect("BookPlumb_InvalidPassword.jsp");
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
