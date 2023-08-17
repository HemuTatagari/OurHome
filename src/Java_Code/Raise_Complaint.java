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

@WebServlet("/Raise_Complaint")
public class Raise_Complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String complaint = request.getParameter("complaint");
		String password = request.getParameter("password");
		
		try{
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
					String sql1="insert into " + groupName + "_Complaint values(?,?)";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ps1.setString(1, userName);
					ps1.setString(2,  complaint);
					ps1.executeUpdate();
					response.sendRedirect("Complaint_Succesfull.jsp");
				} else {
					response.sendRedirect("Complaint_IncorrectPassword.jsp");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
