<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Add_Electrician_Style.css" rel="stylesheet" type="text/css">
<title>SwimPool Booking</title>
</head>
<body>
<div class="center">
<h1>Book Swimming Pool</h1>
<form action="Book_SwimPool" method="get" >

<div class="txt_field">
<input type="text"name="date" >
<span></span>
<label>Enter Date</label>
</div>
<div  class="txt_field">
<input type="text"  name="time" >
<span></span>
<label >Enter Time(in 24 hours Format)</label>
</div>
<div   class="txt_field">
<input type="text" name="duration">
<span></span>
<label >Enter Duration</label>
</div>
<div class="txt_field">
<input type="password"  name="password" >
<span></span>
<label>Password:</label>
</div>

<input type="submit" value="Book" >

</form>
</div>

</body>
</html>