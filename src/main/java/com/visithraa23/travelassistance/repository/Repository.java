package com.visithraa23.travelassistance.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.visithraa23.travelassistance.dto.Destination;
import com.visithraa23.travelassistance.dto.User;

public class Repository {
	private static Repository repository;
	private Connection connection;

	private Repository() {
		String url = "jdbc:mysql://localhost:3306/travel_assistance";
		String userName = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}
	
	
//					---------------------------------User--------------------------------------

	public boolean addUser(User user) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("Insert into user (FirstName,LastName,Email,Phone,Password) values (?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean checkIfUserPresent(User user) {
		String checkUser = "SELECT COUNT(*) FROM user WHERE Email = ? OR Phone=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(checkUser);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhone());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int countUser = resultSet.getInt(1);
				return countUser > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User checkIfUserEmailPresent(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where Email=?");
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String password=resultSet.getString("password");
				String email=resultSet.getString("email");
				User userPresent=new User(email,password);
				return userPresent;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
//					-------------------------------------Destination---------------------------------------------
	
	public ResultSet getPlacesInDestination(String clickedDestination) {
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from destinationlist where location=?");
			preparedStatement.setString(1, clickedDestination);
			ResultSet resultSet= preparedStatement.executeQuery();
			//System.out.println(resultSet);
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
