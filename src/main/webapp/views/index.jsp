<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<style type="text/css">
*{
	margin:0;
	padding:0;
}
body{
width:100%;
height:100%;
background-color:#c1edeb;
} 
ul{
display:inline-flex;
margin-top:50px;
width:100%;
overflow:hidden;
background-color:teal;
}
img{
	width:30%;
	margin-top:4px;
	margin-right:100px;
	margin-left:50px;
}
li {
	display:inline-flex;
	text-align:center;
	font-size:25px;	
	padding:15px 13px;
	list-style:none;
	color:#fff;
	cursor:pointer;
}
li a{
	top:70px;
	right: 70px;
	position: absolute;
	text-decoration:none;
	color:midnightblue;
	border:solid 3px transparent;
	border-radius:20px;
	background-image:radial-gradient(circle at top left,#f08080,#66cdaa,#4169e1);
	background-origin:border-box;
	bacground-clip:content-box,border-box;
}
li a span{
	display:block;
	padding:5px 18px;
}
</style>
</head>
<body>
	<ul>
		<li><img src="/images/logo.jpg" ></li>
		<li>CitY Search </li>
		<li><a href="login"><span>Login</span></a></li>
		
	</ul>
	<a href="postclassified">postclassified</a>
		<a href="postcitydetails">postcitydetails</a>
	<div>
	</div>
</body>
</html>