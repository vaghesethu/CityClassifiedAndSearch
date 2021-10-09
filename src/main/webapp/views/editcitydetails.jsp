<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
 <form class="modal-content" action="/admin/editcitydetails?cityId=?" method="post"  >
    <div class="container">
      <h1>Edit CityDetails</h1>
      
		<select id="category" name="category"  >
		<option value="mall">Mall</option>
		<option value="hospital">Hospital</option>
		<option value="school">School</option>
		<option value="hotel">Hotel</option>
		</select>
		
		<input type="text" id="name" value="" name="name" required>
		
		<input type="text" id="address" value="" name="address" required >
		
		<input type="text" id="cityName" value=""name="city" required >
		
		<input type="text" id="link" value="" name="link" required  >
		
		 
      <div class="clearfix">
              <button type="submit" class="signupbtn">Post</button>
      </div>
    </div>
  </form>

</body>
</html>