<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
.top{
	list-style-type: none;
	display:inline-flex;
	margin-top:0px;
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
.top li {
	display:inline-flex;
	text-align:center;
	font-size:25px;	
	padding:15px 13px;
	list-style:none;
	color:#fff;
	cursor:pointer;
	float: right;
}
.top li a{
	top:30px;
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
.sidenav {
  height: 100%;
  width: 250px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: teal;
  overflow-x: hidden;
  padding-top: 20px;
  color:white;
}
.sidenav a ,.dropdown-btn {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: white;
  display: block;
  border: none;
  background: none;
  width: 100%;
  text-align: left;
  cursor: pointer;
  outline: none;
}
.sidenav a:hover, .dropdown-btn:hover {
  color: #f1f1f1;
}
.active {
  background-color:teal;
  color: white;
}
.dropdown-container {
  display: none;
  background-color:lightseagreen;
  padding-left: 8px;
}
.button,.button1,.button2 {
  width: 25px;
  height: 3px;
  background-color: white;
  margin: 6px 0;
}
.close,.open{
  background: teal;
  border: 0;
  color: white;
  cursor: pointer;
}


</style>
</head>
<body>
	<ul class="top">
		<li style="float:left">
		<button class="open" onclick="w3_open()"><div class="button"></div><div class="button1"></div><div class="button2"></div></button></li>
		<li><img src="/images/logo.jpg" ></li>
		<li>CitY Search </li>
		<li class="log"><a href="logout"><span>Logout</span></a></li>
	</ul>
	<div class="sidenav" style="display:none" id="mySidebar">
  		<button class="close" onclick="w3_close()" >&times;</button>
		<p>Hi ${user.userName}</p>
		<p  class="dropdown-btn">Classified details<i class="fa fa-caret-down"></i></p>
		<div class="dropdown-container">
			<ul>
			<li><a href="post.jsp">Post Classified</a></li>
			<li><a href="">Edit Classified</a></li>
			<li><a href="">Delete Classified</a></li>
			</ul>
		</div>
		<p  class="dropdown-btn">City Details<i class="fa fa-caret-down"></i></p>
		<div class="dropdown-container">
			<ul>
			<li><a href="city.jsp">Add City Details</a></li>
			<li><a href="city.jsp">Edit City Details</a></li>
			<li><a href="city.jsp">Delete City Details</a></li>
			</ul>
		</div>
  	</div>
<script>
function w3_open() {
  document.getElementById("mySidebar").style.width = "30%";
  document.getElementById("mySidebar").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
  this.classList.toggle("active");
  var dropdownContent = this.nextElementSibling;
  if (dropdownContent.style.display === "block") {
  dropdownContent.style.display = "none";
  } else {
  dropdownContent.style.display = "block";
  }
  });
}
</script>
</body>
</html>