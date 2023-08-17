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


@WebServlet("/Book_SwimPool")
public class Book_SwimPool extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String duration = request.getParameter("duration");
		String password = request.getParameter("password");
		
		int _date, _time, _duration;
		int user_date = Integer.parseInt(date);
		int user_time = Integer.parseInt(time);
		int user_duration = Integer.parseInt(duration);
		
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
			
			int flag = 1, flag1 = 0;
			while(rs.next()) {
				if(rs.getString("password").equals(password)) {
					flag1 = 1;
					
					String sql2 = "select * from "+ groupName +"_SwimPool";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ResultSet rs2 = ps2.executeQuery();
					
					while(rs2.next()) {
					
						_date = Integer.parseInt(rs2.getString("date"));
						_time = Integer.parseInt(rs2.getString("time"));
						_duration = Integer.parseInt(rs2.getString("duration"));
					
						
						if(user_date == _date && (user_time < (_time + _duration) || (user_time + user_duration) < _time + _duration)) {
							flag = 0;
							response.sendRedirect("SwimPool_AlreadyBooked.jsp");
						}
					}
				} else {
					response.sendRedirect("Wrong_BookPool_Password.jsp");
				}	
			}
			
			if(flag == 1 && flag1 == 1) {
				String sql1 = "insert into "+ groupName +"_SwimPool values(?,?,?,?)";
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ps1.setString(1, userName);
				ps1.setInt(2, user_date);
				ps1.setInt(3, user_time);
				ps1.setInt(4, user_duration);
				
				ps1.executeUpdate();
				
				response.sendRedirect("SwimPool_BookingSuccessfull.jsp");
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
				
	}

}
