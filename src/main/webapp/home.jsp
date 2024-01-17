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
	</div>
</body>
</html>