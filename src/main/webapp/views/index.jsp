<%@page import="java.util.List, com.cityclassifiedandsearch.bean.Classified, org.apache.commons.codec.binary.Base64"%>
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
        <a class="navbar-brand" href="#">City Classfied And Search</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Classifieds</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">City Details</a> <!--add in the href-->
            </li>
          </ul>
          <button type="button" class="btn btn-outline-light me-2" data-bs-toggle="modal" data-bs-target="#signinmodal">
          	Sign in
		  </button>
		  <button type="button" class="btn btn-outline-light" data-bs-toggle="modal" data-bs-target="#signupmodal">
          	Sign up
		  </button>
        </div>
      </div>
    </nav>
    <div class="container">
    	<%
	    	List<Classified> classifieds = (List<Classified>)request.getAttribute("classifieds");
	    	int counter = 0;
	    	while(counter < classifieds.size()) {
	    %>
	   			<div class="row row-cols-1 row-cols-md-5 g-4 mt-2">
	   				<% for(int i = 0; i < 5 && counter < classifieds.size(); i++) { %>
		  					<div class="col">
		  						<% Classified classified = classifieds.get(counter++); %>
							    <div class="card h-100">
							      <%
							      	String img = "";
							      	String classifiedImage = classified.getClassifiedimage();
							      	if(classifiedImage == null) {
							      		img = "/images/noimage.jpg";
							      	}
							      	else {
							      		img = "/images/noimage.jpg"; //code for fetching the image
							      	}
							      %>
							      <img src="<%= img %>" class="card-img-top">
							      <div class="card-body">
							        <h5 class="card-title"><%= classified.getClassifiedTitle() %></h5>
							        <p class="card-text">
							        	Category: <%= classified.getClassifiedCategory() %> <br>
							        	<%= classified.getDescription() %> <br>
							        </p>
							      </div>
							      <div class="card-footer">
							      	<a class="btn btn-sm btn-outline-dark col-md-12" href="/viewclassified/<%= classified.getClassifiedId() %>">More Info</a>
							      </div>
		    					</div>
	  						</div>
	  				<% } %>
				</div>
		<% } %>
	</div>
	
	<!-- Sign in Modal -->
	<div class="modal fade" id="signinmodal" tabindex="-1" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Sign in</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="container">
	      	<form class="my-3" name="login" action="login" method="post" onsubmit="return loginmodalcheck()">
			  <div class="mb-3">
			    <label for="useremail" class="form-label">Email address</label>
			    <span id=mail></span>
			    <input type="email" class="form-control" id="useremail" name="username">
			  </div>
			  <div class="mb-3">
			    <label for="password" class="form-label">Password</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
		  	  <button type="submit" class="btn btn-outline-dark">Login</button>
		  	</form>
		 </div>
	    </div>
	  </div>
	</div>
	
	<!-- Sign up Modal -->
	<div class="modal fade" id="signupmodal" tabindex="-1" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Sign up</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="container">
	      	<form class="my-3" name="register" action="register" method="post">
			  <div class="mb-3">
			    <label for="userName" class="form-label">User Name</label>
			    <input type="text" class="form-control" id="userName" name="userName">
			  </div>
			  <div class="mb-3">
			    <label for="userEmail" class="form-label">Email Address</label>
			    <input type="email" class="form-control" id="userEmail" name="userEmail">
			  </div>
			  <div class="mb-3">
			    <label for="mobile" class="form-label">Mobile</label>
			    <input type="tel" class="form-control" id="mobile" name="mobile">
			  </div>
			  <div class="mb-3">
			    <label for="userAddress" class="form-label">Address</label>
			    <input type="text" class="form-control" id="userAddress" name="userAddress">
			  </div>
			  <div class="mb-3">
			    <label for="userCity" class="form-label">City</label>
			    <input type="text" class="form-control" id="userCity" name="userCity">
			  </div>
			  <div class="mb-3">
			    <label for="password" class="form-label">Password</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
			  <div class="mb-3">
			    <label for="confirmPassword" class="form-label">Confirm Password</label>
			    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
			  </div>
			  Already have an account? <a href="login">Log In</a> <br>
		  	  <button type="submit" class="btn btn-outline-dark">Submit</button>
		  	</form>
		 </div>
	    </div>
	  </div>
	</div>
	
	<script>
		function loginmodalcheck() {
			var email = document.getElementById("useremail").value;
			var mailformat =/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
			if(!email.match(mailformat)) {
				document.getElementById("mail").innerHTML = "<br>Invalid Email";  
			  	return false;  
			}else{
				return true;
			}
		}
	</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</body>
</html>