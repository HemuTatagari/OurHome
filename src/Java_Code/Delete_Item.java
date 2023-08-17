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

@WebServlet("/Delete_Item")
public class Delete_Item extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String itemName = request.getParameter("itemName");
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
					String sql1 = "delete from "+ groupName +"_grocery where itemName = ?";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ps1.setString(1, itemName);
					ps1.executeUpdate();
					
					response.sendRedirect("DeleteItem_Succesfull.jsp");
					
					
				} else {
					response.sendRedirect("DeleteItem_WrongPassword.jsp");
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
