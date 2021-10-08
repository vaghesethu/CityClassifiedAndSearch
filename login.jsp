<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style>
body {
	width: 100%;
	height: 100%;
	background-color: #c1edeb;
}

container {
	text-align: center
}

form {
	border: #3CB371;
	padding: px;
	background-color: #20B2AA;
	width: 400px;
	margin:auto;
	border-style:groove;
	border-color:teal;
}

h4 {
	background-color: teal;
	color: white;
	padding: 15px;
	font-size: 25px;
	text-align: left;
	
}

h1 {
	color: white;
	padding: 15px;
	font-size: 20px;
}

</style>
</head>
<body>
	<h4>Login</h4>
	<h1>
	<div>
	<b><form name="login" action="login"  style="color:#063F32" method="post" onsubmit="return check()">
					Email: <input type="email"  class="alert alert-danger" size="64" placeholder="Enter email"
						name="username" required> Please enter the email<br> <span id=mail></span><br>
					Password: <input type="password" placeholder="Enter password"
						size="63" name="password"><br> <br> Don't have
					an account? <a href="register">Sign Up</a><br> <br> 
					<input type="submit" value="submit" style="background-color:#43BFC7;" >
				</form></b>	</div>
	</h1>
	<script>
		function check() {

			var userEmail = document.getElementById("userEmail").value;
			var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

			if (!userEmail.match(mailformat)) {
				document.getElementById("mail").innerHTML = "Invalid Email";
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>