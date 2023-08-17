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

@WebServlet("/Create_Group1")
public class Create_Group1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String phoneNo = request.getParameter("phoneNo");
		String e_mail = request.getParameter("e-mail");
		String flatsNo = request.getParameter("flatsNo");
		String hNo = request.getParameter("hNo");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		
		try{
			HttpSession session1 = request.getSession(false);
			String groupName = (String) session1.getAttribute("groupName");
			String adminName = (String) session1.getAttribute("adminName");
			String password = (String) session1.getAttribute("password");
			
			HttpSession session2 = request.getSession();
			session2.setAttribute("groupName", groupName);
			session2.setAttribute("adminName", adminName);
			session2.setAttribute("password", password);
			session2.setAttribute("phoneNo", phoneNo);
			session2.setAttribute("e_mail", e_mail);
			session2.setAttribute("flatsNo", flatsNo);
			session2.setAttribute("hNo", hNo);
			session2.setAttribute("street", street);
			session2.setAttribute("city", city);
			session2.setAttribute("state", state);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");
			String sql = "insert into group_details values(?,?,?,?,?,?,?,?,?,?)";
			String sql1= "create table "+ groupName +"(flatNo varchar(100),userName VARCHAR(100),password VARCHAR(100),phoneNo VARCHAR(100), authorization VARCHAR(100))";
			String sql2 = "insert into "+ groupName +" values(?,?,?,?,?)";
			String sql3 = "create table "+ groupName +"_SwimPool (userName VARCHAR(100), date int(10), time int(100), duration int(10))";
			String sql4 = "create table "+ groupName +"_BanquetHall (userName VARCHAR(100), date int(10), time int(100), duration int(10))";
			String sql5 = "create table "+ groupName +"_Stadium (userName VARCHAR(100), date int(10), time int(100), duration int(10))";
			String sql6 = "create table "+ groupName +"_ElecList(name varchar(100), mobile varchar(100), status varchar(100) )";
			String sql7 = "create table "+ groupName +"_PlumbList(name varchar(100), mobile varchar(100), status varchar(100) )";
			String sql8 = "create table "+ groupName +"_ElecReq (userName VARCHAR(100), elecName varchar(100))";
			String sql9 = "create table "+ groupName +"_PlumbReq (userName VARCHAR(100), plumbName varchar(100) )";
			String sql10 = "create table "+ groupName +"_Help (userName VARCHAR(100))";
			String sql11 = "create table "+ groupName +"_Complaint (userName VARCHAR(100), complaint varchar(1000))";
			String sql12 = "create table "+ groupName +"_Grocery (itemName VARCHAR(100), qty varchar(100), price varchar(100))";
			String sql13 = "create table "+ groupName +"_GroceryOrder (userName varchar(100), itemName VARCHAR(100), qty varchar(100), price varchar(100))";
			String sql14 = "create table "+ groupName +"_Flats (flatNo varchar(100), status VARCHAR(100))";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps1 = con.prepareStatement(sql1);
			PreparedStatement ps2 = con.prepareStatement(sql2);
			PreparedStatement ps3 = con.prepareStatement(sql3);
			PreparedStatement ps4 = con.prepareStatement(sql4);
			PreparedStatement ps5 = con.prepareStatement(sql5);
			PreparedStatement ps6 = con.prepareStatement(sql6);
			PreparedStatement ps7 = con.prepareStatement(sql7);
			PreparedStatement ps8 = con.prepareStatement(sql8);
			PreparedStatement ps9 = con.prepareStatement(sql9);
			PreparedStatement ps10 = con.prepareStatement(sql10);
			PreparedStatement ps11 = con.prepareStatement(sql11);
			PreparedStatement ps12 = con.prepareStatement(sql12);
			PreparedStatement ps13 = con.prepareStatement(sql13);
			PreparedStatement ps14 = con.prepareStatement(sql14);
			
			ps.setString(1, groupName);
			ps.setString(2, adminName);
			ps.setString(3, password);
			ps.setString(4, phoneNo);
			ps.setString(5, e_mail);
			ps.setString(6, flatsNo);
			ps.setString(7, hNo);
			ps.setString(8, street);
			ps.setString(9, city);
			ps.setString(10, state);
			
			//ps1.setString(1, groupName);
			
			ps2.setString(1, null);
			ps2.setString(2, adminName);
			ps2.setString(3, password);
			ps2.setString(4, phoneNo);
			ps2.setString(5, "admin");
			
			ps.executeUpdate();
			ps1.executeUpdate();
			ps2.executeUpdate();
			ps3.executeUpdate();
			ps4.executeUpdate();
			ps5.executeUpdate();
			ps6.executeUpdate();
			ps7.executeUpdate();
			ps8.executeUpdate();
			ps9.executeUpdate();
			ps10.executeUpdate();
			ps11.executeUpdate();
			ps12.executeUpdate();
			ps13.executeUpdate();
			ps14.executeUpdate();
			
			
			out.print("Enter Flat numbers ...");
			out.print("<form action='Create_Group2' method='get'>");
			int i = 0, j=0;
			int noOfFlats = Integer.parseInt(flatsNo);
			
			int[] numbers = new int[noOfFlats];
			while(j < noOfFlats) {
				numbers[j] = j; 
				j = j +1;
			}
			
			while(i < noOfFlats) {
				out.print("<input type='text' name='"+numbers[i]+"'>");
				i = i+1;
			}
			out.print("<input type='submit' value='Go'>");
			out.print("</form>");
			//response.sendRedirect("Admin_Home.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
