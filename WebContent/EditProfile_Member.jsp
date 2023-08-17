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
<title>Edit Profile</title>
</head>
<style>

.container { 
top:30%;
left:50%; 
width: 450px;  
height: 243px;  
border: 9px solid orange; 
margin-left :543px;
margin-right : 300px;
margin-top : 149px;
padding : 43px;


}
.header{
	background: #edc93d;
	height: 80px;
  }
  .header img {
	float: left;width: 90px;height: 80px;background: #555;border-radius:50%;
  }
  
  .header h1{
	position: relative;top: 1px;left: 12px;font-size:60px;margin-bottom: 43px;font-family: fantasy;font-weight: 200;
  }
}  
</style>
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

out.print("<form action='EditProfile_Member' method='get' class='container' margin='auto'  border='9px solid black '>");
while(rs.next()){
	
	out.println("<table align='center'>");

	out.println("<font color='black' >FlatNo :</font> <input type='text' name='flatNo' value='"+rs.getString("flatNo")+"'readonly>"+"<br><br>");
	
	out.println("<font color='black' >Name :</font> <input type='text' name='userName' value='"+rs.getString("userName")+"'readonly>"+"<br><br>");
	out.println("<font color='black' >PhoneNo :</font> <input type='text' name='phoneNo' value=' "+rs.getString("phoneNo")+"' >"+"<br><br>");
	out.println("<font color='black' >Password</font> <input type='text' name='password' value='"+rs.getString("password") +"'>"+"<br><br>");

out.println("</table>");
}

out.print("<input type='submit' value='OK'>");
out.print("</form>");

} catch(Exception e) {
e.printStackTrace();
}


%>
</body>
</html>