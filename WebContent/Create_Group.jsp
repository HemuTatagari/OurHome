<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CreateGroup0.css" rel="stylesheet" type="text/css">
<title>Create_Group</title>
</head>
<body>
<div class="center">
<h2>Create Group</h2>
<form action="Create_Group" method="get" >
<div class="form_div">
<input type="text"  name="groupName"  placeholder=" " class="form_input" >
<label class="form_label">Group Name</label>
</div>
<div class="form_div">
<input type="text"  name="adminName"  placeholder=" " class="form_input" >
<label class="form_label">Admin Name</label>
</div>
<div class="form_div">
<input type="password"  name="password"  placeholder=" " class="form_input" >
<label class="form_label">Password</label>
</div>
<input type="submit" value="Continue" >
</form>
</div>
</body>
</html>



