<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Plumber</title>
<link href="Add_Electrician_Style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="center">
<h1>ADD A PLUMBER</h1>
<form action="Add_Plumber" method="get" class="form">
<div class="txt_field">
<input type="text"  name="name" >
<span></span>
<label>Name</label>
</div>
<div class="txt_field">
<input type="text"  name="phone" >
<span></span>
<label>Contact</label>
</div>
<div class="txt_field">
<input type="password" name="password" >
<span></span>
<label>Admin Password</label>
</div>
<input type="submit" value="Add" >
</form>
</div>
</body>
</html>