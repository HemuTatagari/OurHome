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


@WebServlet("/Remove_Member")
public class Remove_Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String username = request.getParameter("userName");
		String adminPassword = request.getParameter("adminPassword");
		

		try{
			HttpSession session2 = request.getSession(false);
			String groupName = (String) session2.getAttribute("groupName");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			String sql1 = "select * from group_details where groupName = ? ";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, groupName);
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("password").equals(adminPassword)) {
					/* String sql = "delete from "+ groupName +" where userName = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,username);
					ps.executeUpdate();
					*/
					
					String sql = "select * from "+ groupName +" where userName = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, username);
					ResultSet rs1 = ps.executeQuery();
					
					while(rs1.next()) {
						if(rs1.getString("authorization").equals("member")) {
							 String sql2 = "delete from "+ groupName +" where userName = ?";
								PreparedStatement ps2 = con.prepareStatement(sql2);
								ps2.setString(1,username);
								ps2.executeUpdate();
						} else if(rs1.getString("authorization").equals("electrician")) {
							String sql2 = "delete from "+ groupName +" where userName = ?";
							PreparedStatement ps2 = con.prepareStatement(sql2);
							ps2.setString(1,username);
							ps2.executeUpdate();
							
							String sql3 = "delete from "+ groupName +"_ElecList where name = ?";
							PreparedStatement ps3 = con.prepareStatement(sql3);
							ps3.setString(1,username);
							ps3.executeUpdate();
							
							
						} else if(rs1.getString("authorization").equals("plumber")) {
							String sql2 = "delete from "+ groupName +" where userName = ?";
							PreparedStatement ps2 = con.prepareStatement(sql2);
							ps2.setString(1,username);
							ps2.executeUpdate();
							
							String sql3 = "delete from "+ groupName +"_PlumbList where name = ?";
							PreparedStatement ps3 = con.prepareStatement(sql3);
							ps3.setString(1,username);
							ps3.executeUpdate();
							
							
						} else {
							String sql2 = "delete from "+ groupName +" where userName = ?";
							PreparedStatement ps2 = con.prepareStatement(sql2);
							ps2.setString(1,username);
							ps2.executeUpdate();
						}
					}
					
					 
					response.sendRedirect("DeleteMember_Succesfull.jsp"); //deletion succesfull
				} else {
					response.sendRedirect("RemoveMember_WrongPassword.jsp");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
