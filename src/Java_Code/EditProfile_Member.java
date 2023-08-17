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


@WebServlet("/EditProfile_Member")
public class EditProfile_Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String flatNo = request.getParameter("flatNo");
		String phoneNo = request.getParameter("phoneNo");
		String password = request.getParameter("password");
		
		try {
			HttpSession session2 = request.getSession(false);
			String groupName = (String) session2.getAttribute("groupName");
			//String userName = (String)session2.getAttribute("userName");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");

			String sql = "update "+ groupName +" set phoneNo = ? , password = ? where userName = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, phoneNo);
			ps.setString(2, password);
			ps.setString(3, userName);
			ps.executeUpdate();
			
			response.sendRedirect("EditProfile_Succesfull.jsp");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
