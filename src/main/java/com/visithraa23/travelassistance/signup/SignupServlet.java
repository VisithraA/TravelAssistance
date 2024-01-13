package com.visithraa23.travelassistance.signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visithraa23.travelassistance.dto.User;
import com.visithraa23.travelassistance.repository.Repository;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private Repository repository;
	private static final long serialVersionUID = 1L;

	
	public SignupServlet() {
		repository = Repository.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		User user = new User(firstName, lastName, email, phone, password);
		repository.addUser(user);
//		boolean userExists = repository.checkIfUserPresent(user);
//		if (userExists) {
//			
//		} else {
//			boolean signupSuccess = repository.addUser(user);
//			
//		}

	}

}
