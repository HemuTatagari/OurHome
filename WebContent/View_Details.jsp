<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.ResultSet" %>
     <%@ page import="java.sql.PreparedStatement" %>
     <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Details</title>
</head>
<body>

<%
String flatNo = request.getParameter("flatNo");
try{
	HttpSession session2 = request.getSession(false);
	String groupName = (String) session2.getAttribute("groupName");
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");

	String sql = "select * from "+ groupName +" where flatNo = ? ";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, flatNo);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()){
		out.print("<font> "+rs.getString("userName")+"</font>");
		out.print("<font> "+rs.getString("phoneNo")+"</font>");
	}
	
} catch(Exception e) {
	e.printStackTrace();
}

%>
<a href="View_Allocation.jsp" style="text-decoration : none" >Back</a>
</body>
</html>