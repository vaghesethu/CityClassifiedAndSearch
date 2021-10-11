<link rel="stylesheet" href="" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<style >
body{
 background-color:#9AC0A3; 
}

</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/index">City Classified And Search</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>
	<form>
		<div class="container">
			<h1>Edit CityDetails</h1>
			<div class="row">
			<select id="category" class="btn btn-secondary dropdown-toggle"
				name="category" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">
				<option value="mall">Mall</option>
				<option value="hospital">Hospital</option>
				<option value="school">School</option>
				<option value="hotel">Hotel</option>
			</select>  
			<input type="text" id="name" value="" name="name" placeholder="name" required>
			<input type="text" id="address" value="" name="address" placeholder="address"required>
			<input type="text" id="cityName" value="" name="city" placeholder="cityname" required>
			<input type="text" id="link" value="" name="link"  placeholder="link"required>
               <div class="clearfix"><br>
				<button type="submit" class="btn btn-dark">Post</button>
			</div>
			</div>
		</div>
	
	</form>
	
</body>
</html>