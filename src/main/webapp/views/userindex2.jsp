<%@page import="java.util.List, com.cityclassifiedandsearch.bean.CityDetails, org.apache.commons.codec.binary.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
    <title>City Classified And Search</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="/user/index">City Classified And Search</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="/user/index">Classifieds</a>
            </li>
            <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"></a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="/user/postclassified">Post Classified</a></li>
	            <li><a class="dropdown-item" href="/user/myclassifieds">My Classifieds</a></li>
	          </ul>
        	</li>
            <li class="nav-item">
              <a class="nav-link active" href="#">City Details</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/user/viewupdates">New Updates</a>
            </li>
          </ul>
		  <a class="btn btn-outline-light" href="/logout">Logout</a>
        </div>
      </div>
    </nav>
    
    <div class="container">
    	<%
	    	List<CityDetails> cityDetails = (List<CityDetails>)request.getAttribute("cityDetails");
	    	int counter = 0;
	    	while(counter < cityDetails.size()) {
	    %>
	   			<div class="row row-cols-1 row-cols-md-5 g-4 mt-2">
	   				<% for(int i = 0; i < 5 && counter < cityDetails.size(); i++) { %>
		  					<div class="col">
		  						<% CityDetails cityDetail = cityDetails.get(counter++); %>
							    <div class="card h-100">
							      <%
							      	String img = "";
							      	String cityimage = cityDetail.getCityimage();
							      	if(cityimage == null) {
							      		img = "/images/noimage.jpg";
							      	}
							      	else {
							      		img = "data:image/jpeg;base64," + cityimage;
							      	}
							      %>
							      <div class="mt-2 mx-auto index-image-parent">
							      	<img src="<%= img %>" class="index-image">
							      </div>
							      <div class="card-body">
							        <h5 class="card-title"><%= cityDetail.getName() %></h5>
							        <p class="card-text">
							        	Category: <%= cityDetail.getCategory() %> <br>
							        	City: <%= cityDetail.getCity() %> <br>
							        	Address: <%= cityDetail.getAddress() %> <br>
							        </p>
							      </div>
							      <div class="card-footer text-center">
							      	<a class="btn btn-sm btn-outline-dark col-md-4" href="/user/viewcitydetails/<%= cityDetail.getCityId() %>">View</a>
							      </div>
		    					</div>
	  						</div>
	  				<% } %>
				</div>
		<% } %>
	</div>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</body>
</html>