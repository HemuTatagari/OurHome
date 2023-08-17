<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="ViewProfile.css">
<title>View Profile</title>
</head>
<body>

    	
        <header>
        	
             <div class="container">
             
                <div class="left">
                <h2>USER PROFILE</h2>
                    <form>
                        First name
                        <input type="text" name="" placeholder="Enter First name" readonly>
                        Last name
                        <input type="text" name="" placeholder="Enter Last name"  readonly>
                        Email
                        <input type="text" name="" placeholder="Enter email" readonly>
                        Phone Number
                        <input type="text" name="" placeholder="Enter Phone number" readonly>
                        Address
                        <input type="text" name="location" placeholder="Enter address" readonly>
                        
                    </form>
                </div>
                <div class="right">
                    
                    <form action="" method="get" class="form">
	                    <p></p>
	                    City
	                        <input type="text" name="" placeholder="Enter city" readonly>
	                        <div id="pin">
	                            <label>
	                                State<br>
	                                <select>
	                                    <option>Choose Option</option>
	                                    <option>Andhra Pradesh</option>
	                                    <option>Telangana</option>
	                                </select>
	                            </label>
	                                
	                        </div>
	                        <div id="pin">
	                         <label>
	                                 Pin Code<br>
	                                    <input type="number" name="" placeholder="pin code" readonly>
	                                </label>
	                    	</div>
	                    	<input type="submit" value="View Profile">
	                    	<a href="">Home</a>
	                   </form>
                        
                </div>
                
               
             </div>
        </header>
        
    </body>
</html>