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


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String groupName = request.getParameter("groupName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			String sql = "select * from "+ groupName +" where userName = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			int flag = 0;
			
			while(rs.next()) {
				flag = 1;
				if(rs.getString("password").equals(password)) {
					
					HttpSession session2 = request.getSession();
					session2.setAttribute("userName", userName);
					session2.setAttribute("groupName", groupName);
					
					if(rs.getString("authorization").equals("admin")) {
						response.sendRedirect("Admin_Home.jsp");
					} else if(rs.getString("authorization").equals("grocery")) {
						response.sendRedirect("Grocery_Home.jsp"); 
					} else if (rs.getString("authorization").equals("member")) {
						response.sendRedirect("Member_Home.jsp");
					}else {
						response.sendRedirect("ElecPlumbHome.jsp"); // Incomp
					}
				} else {
					response.sendRedirect("Wrong_LoginPassword.jsp");
				}
			}
			
			if( flag == 0) {
				response.sendRedirect("Wrong_LoginUserName.jsp");
			}
			
		}catch(Exception e) {
			response.sendRedirect("Wrong_LoginGroup.jsp");
			//e.printStackTrace();
		}
		
	}

}
