<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Add_Electrician_Style.css" rel="stylesheet" type="text/css">
<title>Delete Item</title>
</head>
<body>
<div class="center">
<h2 >Delete Item</h2>
<form action="Delete_Item" method="get" >
<div class="txt_field">
<input type="text"  name="itemName" requried>
<span></span>
<label>Item Name</label>
</div>

<div class="txt_field">
<input type="password"  name="password" requried>
<span></span>
<label>Password</label>
</div>
<input type="submit" value="Delete" >
</form>
</div>
</body>
</html>


