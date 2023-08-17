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
<link href="ViewProfileMember.css" rel="stylesheet" type="text/css">
<title>View Profile</title>
</head>
<body>
<%
HttpSession session2 = request.getSession(false);
String userName = (String)session2.getAttribute("userName");
String groupName = (String)session2.getAttribute("groupName");

try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");

String sql = "select * from "+ groupName +" where userName = ? ";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, userName);
ResultSet rs = ps.executeQuery();

while(rs.next()){
	out.println("<form bgcolor='white' border='9px solid Orange' >");

	out.println("<div id='pin'>");
	out.println("<label>");
	out.println("FlatNo"+"<br>");
	out.println("<input type='text' placeholder='Enter FlatNo' value="+rs.getString("flatNo")+" size='25' readonly>");
	out.println("</label>");
	out.println("</div>");
	
	out.println("<div id='pin'>");
	out.println("<label>");
	out.println("Name"+"<br>");
	out.println("<input type='text' placeholder='Enter Name' value="+rs.getString("userName")+" size='25' readonly>");
	out.println("</label>");
	out.println("</div>");
	
	out.println("<div id='pin'>");
	out.println("<label>");
	out.println("PhoneNo"+"<br>");
	out.println("<input type='text' placeholder='Enter PhoneNo' value="+rs.getString("phoneNo")+" size='25' readonly>");
	out.println("</label>");
	out.println("</div>");
	
	out.println("<div id='pin'>");
	out.println("<label>");
	out.println("Password"+"<br>");
	out.println("<input type='text' placeholder='Enter Password' value="+rs.getString("password")+" size='25' readonly>");
	out.println("</label>");
	out.println("</div>");
	
	
	//out.print("<font color='blue'>  Name : </font>"+rs.getString("userName")+"");
}

out.print("<a href='Member_Home.jsp'>Back</a>");
out.print("<a href='EditProfile_Member.jsp'>Edit</a>");

} catch(Exception e) {
e.printStackTrace();
}


%>
</body>
</html>