<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@ page import="com.cityclassifiedandsearch.bean.*,com.cityclassifiedandsearch.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="modal-content" action="postclassified" method="post" enctype="multipart/form-data">
    <div class="container" >
      <h1>Post Classified</h1>
      
		<select id="classifiedCategory" name="classifiedCategory">
		<option value="buy">Buy</option>
		<option value="sell">Sell</option>
		<option value="rent">Rent</option>
		<option value="partime">Part Time Jobs</option>
		</select><br>
		<input type="text" id="classifiedTitle" placeHolder="Title" name="classifiedTitle" required>
		
		<input type="text" id="description" placeholder="Description" name="description" required >
		
		<input type="file" name="file" >
		 
      <div class="clearfix">
              <button type="submit" class="signupbtn">Post</button>
      </div>
    </div>
  </form>

<img src="data:image/jpeg;base64,${Classified.getClassifiedimage()}" />
</body>
</html>