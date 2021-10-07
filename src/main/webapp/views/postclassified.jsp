<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="modal-content" action="PostClassified" method="post" >
    <div class="container">
      <h1>Post Classified</h1>
      
		<select id="classifiedCategory" name="classifiedCategory">
		<option value="buy">Buy</option>
		<option value="sell">Sell</option>
		<option value="rent">Rent</option>
		<option value="partime">Part Time Jobs</option>
		</select><br>
		<input type="text" id="classifiedTitle" placeHolder="Title" name="classifiedTitle" required>
		
		<input type="text" id="description" placeholder="Description" name="description" required >
		 
      <div class="clearfix">
              <button type="submit" class="signupbtn">Post</button>
      </div>
    </div>
  </form>
</body>
</html>