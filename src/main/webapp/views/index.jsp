<%@page import="java.util.List, com.cityclassifiedandsearch.bean.Classified"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
    <title>City Classfied And Search</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">City Classfied And Search</a> <!--add in the href-->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Classifieds</a> <!--add in the href-->
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">City Details</a> <!--add in the href-->
            </li>
          </ul>
          <a class="btn btn-outline-light me-2" href="login">Sign in</a> <!--add in the href-->
          <a class="btn btn-outline-light" href="register">Sign up</a> <!--add in the href-->
        </div>
      </div>
    </nav>
    <div class="container">
	    <%
	    	List<Classified> classifieds = (List<Classified>)request.getAttribute("classifieds");
	    	int counter = 0;
	    	while(counter < classifieds.size()) {
	    %>
	    		<div class="row mt-2">
	   				<% for(int i = 0; i < 4 && counter < classifieds.size(); i++) { %>
	   					<div class="col me-2 classified">
			        		<% Classified classified = classifieds.get(counter++); %>
			        		<%= classified.getClassifiedTitle() %> <br>
			        		Category: <%= classified.getClassifiedCategory() %> <br>
			        		<%= classified.getDescription() %> <br>
			        	</div>
			        <% } %>
			      </div>
        <%
	    	}
        %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</body>
</html>