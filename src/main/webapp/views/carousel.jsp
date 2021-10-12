<%@page import="java.util.List, com.cityclassifiedandsearch.bean.Multimedia, org.apache.commons.codec.binary.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<style>
.carousel .carousel-item {
  height: 500px;
}

.carousel-item img {
    position: relative;
    height: 100%;
    width:100%;
}

</style>
</head>

<body>
        <%List<Multimedia> carousels = (List<Multimedia>)request.getAttribute("carousel");%>
		<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
               <% for(int i=0;i<carousels.size();i++){%>
                <li data-target=".carouselExampleCaptions" data-slide-to="<%=i%>" class="active"></li>
                <%} %>
            </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		    <%for(Multimedia carousel:carousels) {
		  		String img="data:image/jpeg;base64," + carousel.getCarouselimage();%>
		      <img src="<%=img%>" class="d-block w-100" alt="Traffic">
		      <div class="carousel-caption d-none d-md-block">
		        <h5><%=carousel.getCarouselTitle() %></h5>
		        <p><%=carousel.getCarouselupdate() %></p>
		      </div>
		     
		       <%} %>
		    </div>
		    
		  </div>
		  
		  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		
		</div>

</body>
</html>