package Java_Code;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Create_Group2")
public class Create_Group2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try{
			HttpSession session2 = request.getSession(false);
			String groupName = (String) session2.getAttribute("groupName");
			String flatNo = (String) session2.getAttribute("flatsNo");
			
			int noOfFlats = Integer.parseInt(flatNo);
			int i =0;
			String flat="";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			
			while(i < noOfFlats) {
				flat = request.getParameter(""+i+"");
				String sql = "insert into "+groupName+"_Flats values(?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, flat);
				ps.setString(2, "free");
				ps.executeUpdate();
				i = i+1;
			}
			
			response.sendRedirect("Admin_Home.jsp");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
