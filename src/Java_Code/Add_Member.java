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

@WebServlet("/Add_Member")
public class Add_Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String authorization = request.getParameter("authorization");
		String flatNo = request.getParameter("flatNo");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String phoneNo = request.getParameter("phoneNo");
		String adminPassword = request.getParameter("adminPassword");
		
		try{
			HttpSession session2 = request.getSession(false);
			String groupName = (String) session2.getAttribute("groupName");
			String admin_userName = (String) session2.getAttribute("userName");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			String sql1 = "select * from  group_details where groupName = ? ";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, groupName);
			ResultSet rs1 = ps1.executeQuery();
			int flag = 0;
			while(rs1.next()) {
				if(rs1.getString("password").equals(adminPassword)) {
					if(authorization.equals("member")) {
						String sql2 = "select * from "+ groupName +" where userName= ?";
						PreparedStatement ps2 = con.prepareStatement(sql2);
						ps2.setString(1,  userName);
						ResultSet rs2 = ps2.executeQuery();
						while(rs2.next()){
							flag = 1;
							response.sendRedirect("AddMember_UserAlreadyExist.jsp");
						}
						
						if(flag == 0) {
							String sql = "insert into "+ groupName +" values(?,?,?,?,?)";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setString(1, flatNo);
							ps.setString(2, userName);
							ps.setString(3, password);
							ps.setString(4, phoneNo);
							ps.setString(5, authorization);
							ps.executeUpdate();
							
							String sql4 = "update "+ groupName +"_Flats set status = ? where flatNo = ?";
							PreparedStatement ps4 = con.prepareStatement(sql4);
							ps4.setString(1, "booked");
							ps4.setString(2, flatNo);
						
							ps4.executeUpdate();
							
							response.sendRedirect("AddMember_Sucessfull.jsp");
							
						}
						
						
					} else if(authorization.equals("electrician")) {
						
						String sql2 = "select * from "+ groupName +"_ElecList where name= ?";
						PreparedStatement ps2 = con.prepareStatement(sql2);
						ps2.setString(1,  userName);
						ResultSet rs2 = ps2.executeQuery();
						while(rs2.next()){
							flag = 1;
							response.sendRedirect("AddMember_UserAlreadyExist.jsp");
						}
						
						if(flag == 0) {
							String sql = "insert into "+ groupName +"_ElecList values(?,?,?)";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setString(1, userName);
							ps.setString(2, phoneNo);
							ps.setString(3, "available");
							ps.executeUpdate();
							
							String sql3 = "insert into "+ groupName +" values(?,?,?,?,?)";
							PreparedStatement ps3 = con.prepareStatement(sql3);
							ps3.setString(1,null);
							ps3.setString(2, userName);
							ps3.setString(3, password);
							ps3.setString(4, phoneNo);
							ps3.setString(5, authorization);
							ps3.executeUpdate();
							
							
							
							response.sendRedirect("AddMember_Sucessfull.jsp");
							
						}
						
					}else if(authorization.equals("plumber")) {
						String sql2 = "select * from "+ groupName +"_PlumbList where name= ?";
						PreparedStatement ps2 = con.prepareStatement(sql2);
						ps2.setString(1,  userName);
						ResultSet rs2 = ps2.executeQuery();
						while(rs2.next()){
							flag = 1;
							response.sendRedirect("AddMember_UserAlreadyExist.jsp");
						}
						
						if(flag == 0) {
							String sql = "insert into "+ groupName +"_PlumbList values(?,?,?)";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setString(1, userName);
							ps.setString(2, phoneNo);
							ps.setString(3, "available");
							ps.executeUpdate();
							
							String sql3 = "insert into "+ groupName +" values(?,?,?,?,?)";
							PreparedStatement ps3 = con.prepareStatement(sql3);
							ps3.setString(1,null);
							ps3.setString(2, userName);
							ps3.setString(3, password);
							ps3.setString(4, phoneNo);
							ps3.setString(5, authorization);
							ps3.executeUpdate();
							response.sendRedirect("AddMember_Sucessfull.jsp");
							
						}
						
					} else {
						String sql = "insert into "+ groupName +" values(?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, null);
						ps.setString(2, userName);
						ps.setString(3, password);
						ps.setString(4, phoneNo);
						ps.setString(5, authorization);
						
						ps.executeUpdate();
						
						
						
						
						response.sendRedirect("AddMember_Sucessfull.jsp");
					}
					
				} else {
					response.sendRedirect("AddMember_InvalidPassword.jsp");
				}
					
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
