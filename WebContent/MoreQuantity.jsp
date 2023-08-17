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
<title>Order Grocery</title>
</head>
<body>
<%

HttpSession session2 = request.getSession(false);
String groupName = (String) session.getAttribute("groupName");
String userName = (String) session.getAttribute("userName");

HttpSession session1 = request.getSession(false);
String overItem = (String)session1.getAttribute("overItem");

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");

String sql = "select * from "+ groupName +"_Grocery ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
out.print("<form action='Order_Grocery' method='get'>");
out.print("<table>");
out.print("<tr> <td> Item </td> <td> Qty(available *) </td> <td> Price/kg</td>  <td>Qty(*needed) </td> <td> Select </td></tr>");

while(rs.next()) {
	
	out.print("<tr><td>"+rs.getString("itemName")+"</td>  <td> "+ rs.getString("qty")+" </td>  <td>"+rs.getString("price")+" </td> <td><input type='text' name='"+rs.getString("itemName")+"_qty' </td> <td> <input type='checkbox' name='select' value='"+rs.getString("itemName")+"' </td></tr>");
	//out.print("<tr> <td> "+ rs.getString("itemName") +" </td><td><font name='"+rs.getString("itemName")+"_qty1' value = '"+rs.getString("qty")+"'"+ rs.getString("qty") +" </font></td> <td> <input type='text' name=' "+ rs.getString("itemName") + "_qty' > </td> <td><font name='"+rs.getString("itemName")+"_price' value='"+rs.getString("price")+"'"+ rs.getString("price") +" </td> <td> <input type='checkbox' name='selected' value =' " + rs.getString("itemName") +" '</td> </tr>");
}
out.print("</table>");
out.print("<input type='submit' value='Order'>");
out.print("<font color='red'> Quantity Mismatch </font>");
out.print("<br><font color='red'> Order "+overItem+" again with appropriate quantity. </font>");
out.print("</form>");
%>
</body>
</html>