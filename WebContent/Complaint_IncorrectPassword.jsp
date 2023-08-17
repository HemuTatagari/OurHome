<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Add_Electrician_Style.css" rel="stylesheet" type="text/css">
<title>Raise Complaint</title>
</head>
<body>
<div class="center" >
<h1>Add Electrician</h1>
<form action="Raise_Complaint" method="get"  class="form">
<div class="txt_field">
<input type="text"  name="name"  >
<span></span>
<label>Issue</label>
</div>

<div class="txt_field">
<input type="password"  name="password" >
<span></span>
<label>Password :</label>
</div>
<p class="error" ><font color="red" >Invalid Password.</font></p>
<input type="submit" value="Done">
</form>
</div>
</body>
</html>

