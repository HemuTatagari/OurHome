<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Login.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
<div class="center">
<h3>Login</h3>
<form action="Login" method="get">
<div class="form_div">
<input type="text"  name="groupName"  placeholder=" " class="form_input" >
<label class="form_label">Group Name</label>
</div>

<div class="form_div">
<input type="text"  name="userName" placeholder=" " class="form_input">
<label class="form_label">UserName</label>
</div>


<div class="form_div">
<input type="text"  name="password" placeholder=" " class="form_input" >
<label class="form_label">Password:</label>
</div>

<input type="submit" value="submit" ><br>
<a href="Create_Group.jsp" >Create a Group</a>
</form>

</div>

</body>
</html>






























