<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Raise_Complaint.css" rel="stylesheet" type="text/css">
<title>Report Complaint</title>
</head>
<body>

<div class="center">
<h2>Raise Complaint</h2>
<form action="Raise_Complaint" method="get" >
<div class="txt_field">
<text>Complaint</text><br><br>
<textarea type="text" placeholder="" name="complaint" requried></textarea>
<span></span>

</div>
<div class="txt_field">
<input type="password" placeholder="" name="password" required>
<span></span>
<label>Password</label>
</div>
<input type="submit" value="Done">

</form>
</div>
</body>
</html>

