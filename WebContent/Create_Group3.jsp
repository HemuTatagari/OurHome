<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CreateGroup1.css" rel="stylesheet" type="text/css">
<title>Create_Group</title>
</head>
<body>
<div class="center">
<h4>Enter few more details..</h4>
<form action="CreateGroup3.jsp" method="get" >

<div class="form_div">
<input type="text"  name="street"  placeholder=" " class="form_input" >
<label class="form_label">Street/Village</label>
</div>

<div class="form_div">
<input type="text"  name="city"   placeholder=" " class="form_input">
<label class="form_label">City</label>
</div>
<div class="form_div">
<input type="text"  name="state" placeholder=" "  class="form_input">
<label class="form_label">State</label>
</div>
<input type="submit" value="Create" >
</form>
</div>
</body>
</html>
