<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="homeContainer">
		<div class="topDisplay">
			<div class="navButtonContainer">
			<a href="login.jsp" class="button">Login</a> 
			<a href="signup.jsp"class="button">Signup</a>
			<a href="#"class="button">Contact Us</a>
			</div>
			<%String signupMessage=(String)request.getAttribute("signupMessage"); %>
			<% if (signupMessage != null) { %>
        	<script>
            	alert("<%= signupMessage %>");
       	 	</script>
    		<% } %>
		</div>
		
    <div class="destinationsDisplay" >
    		<h2>Top Places for Visit</h2>
    		<div class="destination">
        		<div class="destination-item">
            	<p>Dubai</p>
            	<a href="destinationlist?place=Dubai"><img alt="dubai" src="img/Home/Dubai.jpg"></a>
        	</div>
       	 	<div class="destination-item">
            	<p>Thailand</p>
            	<a href="destinationlist?place=Thailand"><img alt="thailand" src="img/Home/Thailand.jpg"></a>
        	</div>
        	<div class="destination-item">
            	<p>Singapore</p>
            	<a href="destinationlist?place=Singapore"><img alt="singapore" src="img/Home/Singapore.jpg"></a>
        	</div>
    		</div>
			
    		<div class="destination">
        	<div class="destination-item">
            	<p>Paris</p>
            	<a href="destinationlist?place=Paris"><img alt="paris" src="img/Home/Paris.jpg"></a>
        	</div>
        	<div class="destination-item">
            	<p>NewYork</p>
            	<a href="destinationlist?place=NewYork"><img alt="newyork" src="img/Home/NewYork.jpg"></a>
        	</div>
        	<div class="destination-item">
            	<p>Maldives</p>
            	<a href="destinationlist?place=Maldives"><img alt="maldives" src="img/Home/Maldives.jpg"></a>
        	</div>
    		</div>
    	</div>
    </div>
    
</body>
</html>