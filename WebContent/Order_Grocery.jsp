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
<style>
body
{
background-color:#bdf5bd;
}
th,td
{
text-align:center;
}
table
{
	border-collapse:seperate;
	background-color:#edc83d;
	border-color:1px solid black;
}
th,td
{
font-size:15px;
padding-bottom:10px;

}
input[type=radio] {
    border: 0px;
    width: 100%;
    height: 2em;
}

.center
{
  height:65vh;
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 443px;
  background:#edc93d;
  border-radius: 10px;
  box-shadow: 10px 10px 15px rgba(0,0,0,0.05);
  text-align:center;
  justify-content: center;
  align-items: center;
  

}
caption
{
 font-weight: bold;
 padding:3px;
}
input
{
margin-top:10px;
margin-left:20px;
background-color:black;
color:white;
padding:3px;
}


</style>
<title>Order Grocery</title>
</head>

<body>
<div class="center">

 <%

HttpSession session2 = request.getSession(false);
String groupName = (String) session.getAttribute("groupName");
String userName = (String) session.getAttribute("userName");

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Our_Home","root","");

String sql = "select * from "+ groupName +"_Grocery ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
out.print("<form action='Order_Grocery' method='get'>");
out.print("<table>");
out.println("<caption>Click on radio button to order required grocery.</caption>");
out.print("<tr> <th style='width:25%'> Item </th> <th style='width:25%'> Qty(available *) </th> <th style='width:25%'> Price/kg</th>  <th style='width:25%'>Qty(*needed) </th> <th style='width:25%'> Select </th></tr>");

while(rs.next()) {
	
	out.print("<tr> <td style='width:25%'>"+rs.getString("itemName")+"</td> <td style='width:25%'> "+ rs.getString("qty")+" </td> <td style='width:25%'>"+rs.getString("price")+" </td> <td style='width:25%'><input type='text' name='"+
	rs.getString("itemName")+"_qty' </td> <td style='width:25%'><input type='checkbox' name='select' value='"+rs.getString("itemName")+"' </td></tr>");
	//out.print("<tr> <td> "+ rs.getString("itemName") +" </td><td><font name='"+rs.getString("itemName")+"_qty1' value = '"+rs.getString("qty")+"'"+ rs.getString("qty") +" </font></td> <td> <input type='text' name=' "+ rs.getString("itemName") + "_qty' > </td> <td><font name='"+rs.getString("itemName")+"_price' value='"+rs.getString("price")+"'"+ rs.getString("price") +" </td> <td> <input type='checkbox' name='selected' value =' " + rs.getString("itemName")
}
out.print("</table>");
out.print("<input type='submit' value='Order'>");
out.print("</form>");
%>

</div>
</body>
</html>