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
<title>Insert title here</title>
</head>
<body>
<%
try{
	HttpSession session2 = request.getSession(false);
	String groupName = (String) session2.getAttribute("groupName");
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");

	String sql = "select * from "+ groupName +"_groceryorder";
	PreparedStatement ps = con.prepareStatement(sql);
	
	ResultSet rs = ps.executeQuery();
	
	out.print("<table>");
	
	out.print("<tr> <td>Name </td> <td>Item </td> <td>Quantity </td> <td>Amount </td> </tr>");
	
	while(rs.next()){
		out.print("<tr> <td>"+rs.getString("userName")+" </td> <td>"+rs.getString("itemName")+" </td> <td>"+rs.getString("qty")+" </td> <td>"+rs.getString("price")+" </td> </tr>");
	}
	out.print("</table>");
	
	
	
} catch(Exception e) {
	e.printStackTrace();
}

%>

<a href="Grocery_Home.jsp" >Back</a>
</body>
</html>