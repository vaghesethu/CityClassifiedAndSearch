<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style type="text/css">

body{
width:100%;
height:100%;
background-color:#c1edeb;
}
div{
text-align:center
}
form{
display:inline-block;
margin-left:auto;
margin-right:auto;
text-align:right;
}
h4{  
background-color:teal;
color:white;
padding:15px;
font-size:25px;	
text-align:center;
}
</style>
</head>
<body>
	<h4>Login:</h4>
	<div>
		<form name="login" action="login" method="post" onsubmit="return check()">
		Email: <input type="email" name="email">
		<br><span id=mail></span><br>
		Password: <input type="password" name="password"><br><br>
			Don't have an account? <a href="register">Sign Up</a><br><br>
		<input type="submit" value="submit">
		</form>
	</div>
<script>
function check(){
	
	var userEmail=document.getElementById("userEmail").value;
	var mailformat =/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	
	if(!userEmail.match(mailformat)){
		document.getElementById("mail").innerHTML = "Invalid Email";  
	     return false;  
	}else{
		return true;
	}
}
</script>
</body>
</html>