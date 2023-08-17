<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Add_Electrician_Style.css" rel="stylesheet" type="text/css">
<title>Remove Member</title>
</head>
<body>
<div class="center">
<h2>Remove Member</h2>
<form action="./Remove_Member" method="get">
<div class="txt_field">
<input type="text"  name="userName" >
<span></span>
<label>User Name</label>
</div>

<div class="txt_field">
<input type="password"  name="adminPassword" >
<span></span>
<label>Admin Password</label>
</div>

<input type="submit" value="Remove" >
</form>
</div>
</body>
</html>
