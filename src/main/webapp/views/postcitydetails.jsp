<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="modal-content" action="AddCity" method="post"  >
    <div class="container">
      <h1>Post CityDetails</h1>
      
		<select id="category" name="category">
		<option value="mall">Mall</option>
		<option value="hospital">Hospital</option>
		<option value="school">School</option>
		<option value="hotel">Hotel</option>
		</select>
		
		<input type="text" id="name" placeholder="Name" name="name" required>
		
		<input type="text" id="address" placeholder="Adress" name="address" required >
		
		<input type="text" id="cityName" placeholder="city" name="city" required >
		
		<input type="text" id="link" placeholder="Link" name="link" required  >
		
		 
      <div class="clearfix">
              <button type="submit" class="signupbtn">Post</button>
      </div>
    </div>
  </form>
</body>
</html>