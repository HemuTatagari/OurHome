<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.PreparedStatement" %>
    <%@ page import="java.sql.ResultSet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Allocations</title>
</head>
<body>
<%

HttpSession session2 = request.getSession(false);
String groupName = (String) session.getAttribute("groupName");
String userName = (String) session.getAttribute("userName");

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");

String sql = "select * from "+ groupName +"_Flats ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

out.print("<table>");
//out.print("<tr> <td> Item </td> <td> Qty(available *) </td> <td> Qty(*needed) </td>  <td> Price/kg </td></tr>");


out.print("<form action='View_Details.jsp' method='get'>");

while(rs.next()) {
	out.print("<div class='card'>");
	
	if(rs.getString("status").equals("free")) {
		
		
		out.print("<font color='blue'> "+ rs.getString("flatNo") +" </font>");
	} else {
		out.print("<input type='submit' name='flatNo' value='"+rs.getString("flatNo")+"' style='color: red'>");
	}
	out.println("</div>");
	
	
}

out.print("</form>");
//out.print("</table>");
%>
</div>
</body>
</html>