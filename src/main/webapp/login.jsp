<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Assistance</title>
<link href="css/signup.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class=" loginbox box">
			<h1>Login</h1>
			<form action="login" method="post">
				<label>UserName</label>
				<input type="text" name="email" required >
				<br>
				<label>Password</label>
				<input type="password" name="password" required>
				<br>
				<input type="submit" value="Login">
				<br>
				<a href="#">Forget Password?</a>
				<br>
				<a href="signup.jsp">Create New Account</a>
			</form>
			<%String loginMessage=(String)request.getAttribute("loginMessage"); %>
			<% if (loginMessage != null) { %>
        	<script>
         	   alert("<%= loginMessage %>");
       	 	</script>
    		<% } %>
	</div>
</body>
</html>
