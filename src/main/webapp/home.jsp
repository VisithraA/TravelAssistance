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
            	<a href="login.jsp"><img alt="dubai" src="img/Dubai.jpg"></a>
        	</div>
       	 	<div class="destination-item">
            	<p>Thailand</p>
            	<a><img alt="thailand" src="img/Thailand.jpg"></a>
        	</div>
        	<div class="destination-item">
            	<p>Singapore</p>
            	<a><img alt="singapore" src="img/Singapore.jpg"></a>
        	</div>
    		</div>
			
    		<div class="destination">
        	<div class="destination-item">
            	<p>Paris</p>
            	<a><img alt="paris" src="img/Paris.jpg"></a>
        	</div>
        	<div class="destination-item">
            	<p>NewYork</p>
            	<a><img alt="newyork" src="img/NewYork.jpg"></a>
        	</div>
        	<div class="destination-item">
            	<p>Maldives</p>
            	<a><img alt="maldives" src="img/Maldives.jpg"></a>
        	</div>
    		</div>
    	</div>
    </div>
    
</body>
</html>