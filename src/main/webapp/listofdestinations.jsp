<%@page import="com.visithraa23.travelassistance.dto.Destination"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/destinationlist.css" rel="stylesheet" type="text/css">
</head>
<body>
 	<div class="destinationlistdiv">
 		<% List<Destination> destinationList = (List<Destination>) request.getAttribute("PlacesInDestination"); %>
	 <% if (destinationList != null && !destinationList.isEmpty()) { %>
        
            <% for (Destination destination : destinationList) { %>
                <div class="listplaces">
                	<div class="imagediv"><img alt="<%= destination.getPlaceName()%>" src="<%= request.getContextPath()+""+destination.getImage() %>"></div>
                	<div class="detailsdiv"><h3>
                	<%= destination.getPlaceName() %></h3>
               		<p>Location: <%= destination.getLocation() %></p>
               		<p>Budget: <%= destination.getBudget() %></p>
               		<p>Days: <%= destination.getNoOfDays() %></p>
               		<p>Hotel: <%= destination.getHotelRating() %></p></div>   
                </div>
            <% } %>
       
    <% } else { %>
        <p>No Places Found.</p>
    <% } %>
 	</div>
	
</body>
</html>

