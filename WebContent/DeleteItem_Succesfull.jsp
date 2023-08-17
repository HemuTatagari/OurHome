<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="RemoveItemSuccessful.css" rel="stylesheet" type="text/css">
<title>Delete Item</title>
</head>
<body>
<div class="popup" id="p">
<img src="images/RemoveItem.png">
<h3>Updation Successful</h3>
<p><%=request.getAttribute("Name") %> is removed Successfully</p>
<a href="Grocery_Home.jsp">Home</a>
</div>
</body>
</html>