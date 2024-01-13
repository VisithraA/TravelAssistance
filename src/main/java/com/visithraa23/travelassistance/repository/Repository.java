package com.visithraa23.travelassistance.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.visithraa23.travelassistance.dto.User;

public class Repository {
	private static Repository repository;
	private Connection connection;

	public Repository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_assistance", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public boolean addUser(User user) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("Insert into user (FirstName,LastName,Email,Phone,Password) values (?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean checkIfUserPresent(User user) {
		String checkUser = "SELECT COUNT(*) FROM users WHERE Email = ? OR Phone=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(checkUser);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhone());
			ResultSet resultSet = preparedStatement.executeQuery();
			int countUser = resultSet.getInt(1);
			if (countUser > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
