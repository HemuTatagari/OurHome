<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
<link href="Add_Electrician_Style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="center">
<h1>ADD ITEM</h1>
<form action="Add_Item" method="get" class="form">
<div class="txt_field">
<input type="text"  name="itemName" place holder="" requried>
<span></span>
<label>Item Name</label>
</div>

<div class="txt_field">
<input type="text" name="qty" required>
<span></span>
<label>Quantity</label>
</div>

<div class="txt_field">
<input type="text" name="price" required>
<span></span>
<label>Price(per KG*)</label>
</div>

<input type="submit" value="Add" >
</form>
</div>
</body>
</html>