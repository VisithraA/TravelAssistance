package com.visithraa23.travelassistance.screens;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visithraa23.travelassistance.dto.Destination;
import com.visithraa23.travelassistance.repository.Repository;

@WebServlet("/destinationlist")
public class DestinationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Repository repository;

	public DestinationListServlet() {
		repository = Repository.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String clickedDestination = request.getParameter("place");
		//System.out.println(clickedDestination);

		ResultSet resultSet = repository.getPlacesInDestination(clickedDestination);
		List<Destination> placesInDestination = convertResultSetToDestinationList(resultSet);
		//System.out.println(placesInDestination.toString());
		//request.setAttribute("clickedDestination", clickedDestination);
		request.setAttribute("PlacesInDestination", placesInDestination);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listofdestinations.jsp");
		requestDispatcher.forward(request, response);
	}

	private List<Destination> convertResultSetToDestinationList(ResultSet resultSet) {
		List<Destination> destinationList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Destination destination = new Destination();
				destination.setPlaceName(resultSet.getString("placename"));
				destination.setLocation(resultSet.getString("location"));
				destination.setImage(resultSet.getString("image"));
				destination.setBudget(resultSet.getString("budget"));
				destination.setNoOfDays(resultSet.getInt("noofdays"));
				destination.setHotelRating(resultSet.getString("hotelrating"));
				destinationList.add(destination);		
				//System.out.println(destination.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(destinationList.toString());
		return destinationList;
	}

}
