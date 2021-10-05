<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
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
input:invalid {
  box-shadow: 0 0 5px 1px red;
}
h4{  
background-color:teal;
color:white;
padding:15px;
font-size:25px;	
text-align:center;
}
span{
color:red;
}
</style>
</head>
<body>
	<h4>Register User:</h4>
	<div>
		<form action="register" method="post" onsubmit="return check()">
		User Name *:<input type="text" id="userName"  name="userName" required>
		<br><span id=user></span><br>
		Email *:<input type="text" id="userEmail"name="userEmail" required  >
		<br><span id=mail></span><br>
		Mobile *:<input type="number" id="mobile" name="mobile" required  >
		<br><span id=Mobile></span><br>
		Address*:<input type="text" id="userAddress" name="userAddress" required >
		<br><br>
		City*:<input type="text" id="userCity" name="userCity" required >
		<br><br>
		Password *:<input type="password" id="password" name="password" required  >
		<br><br>
		Confirm Password *:<input type="password" id="confirmPassword" name="confirmPassword" required ><br><br>
			<span id=message></span><br>
			<h6 style="color:red">${error}</h6>
			Already have an account? <a href="login">Log In</a><br><br>
		<button type="submit" value="submit" >Submit</button>
		</form>
	</div>
	
<script type="text/javascript">
function check(){
	var userName = document.getElementById("userName").value;
	var nameformat=/^[A-Za-z]+$/;
	
	if(!userName.match(nameformat)){  
	      document.getElementById("user").innerHTML = "Only characters are allowed";  
	      return false;  
	}
	
	if(userName.length<3){  
	      document.getElementById("user").innerHTML = "Enter valid name";  
	      return false;  
	}
	
	var userEmail=document.getElementById("userEmail").value;
	var mailformat =/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	
	if(!userEmail.match(mailformat)){
		document.getElementById("mail").innerHTML = "Invalid Email";  
	     return false;  
	}
	var mobile = document.getElementById("mobile").value;
	var mobileformat=/^[0-9]+$/;
	
	if(!mobile.match(mobileformat)){  
	      document.getElementById("Mobile").innerHTML = "Only numbers allowed";  
	      return false;  
	}
	if(mobile.length!=10){  
	      document.getElementById("Mobile").innerHTML = "Enter valid Mobile Number";  
	      return false;  
	}
	
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	if(password!=confirmPassword){
		document.getElementById("message").innerHTML = "Password Mismatch";  
	    return false; 
	}
	else{
	    return true;
	}
}
</script>

</body>
</html>