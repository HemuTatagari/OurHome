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


@WebServlet("/Add_Item")
public class Add_Item extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String itemName = request.getParameter("itemName");
		String qty = request.getParameter("qty");
		String price = request.getParameter("price");
		
		try {
			HttpSession session2 = request.getSession(false);
			String groupName = (String) session2.getAttribute("groupName");
			String userName = (String) session2.getAttribute("userName");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			String sql = "insert into "+ groupName +"_Grocery values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setString(2, qty);
			ps.setString(3, price);
			ps.executeUpdate();
			
			response.sendRedirect("AddItem_Succesfull.jsp");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
