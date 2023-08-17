<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Add_Electrician_Style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div class="center">
<h1 >Add Member</h1>
<form action="Add_Member" method="get"  class="form">
<div class="txt_field">
<input type="text"  name="userName"  >
<span></span>
<label>User Name</label>
</div>
<p class="error" ><font color="red">UserName Already Exists</font></p>
<div class="txt_field">
<input type="password"  name="password"  >
<span></span>
<label>Password</label>
</div>
<div class="txt_field">
<input type="text"  name="authorization" >
<span></span>
<label>Authorization</label>
</div>
<input type="submit" value="Add" >
</form>
</div>
</body>
</html>