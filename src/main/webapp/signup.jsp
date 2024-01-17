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
	<div class="container">
		<div class="signupbox box">
			<h1>Signup</h1>
			<form action="signup" method="post">
				<label>FirstName</label> <input type="text" name="firstname"
					required> <label>LastName</label> <input type="text"
					name="lastname" required> <label>Email</label> <input
					type="email" name="email" required><br> <label>PhoneNumber</label>
				<input type="tel" name="phone" required><br> <label>Password</label>
				<input type="password" name="password" required><br> <input
					type="submit" value="signup"> <a href="login.jsp">Already
					have Account? Login</a>
			</form>
		</div>
		<%String signupMessage=(String)request.getAttribute("signupMessage"); %>
		<% if (signupMessage != null) { %>
        <script>
            alert("<%= signupMessage %>");
       	 </script>
    	<% } %>
	</div>
</body>
</html>

