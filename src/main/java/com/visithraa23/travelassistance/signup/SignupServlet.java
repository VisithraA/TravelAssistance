package com.visithraa23.travelassistance.signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.cj.util.Util;
import com.visithraa23.travelassistance.dto.User;
import com.visithraa23.travelassistance.repository.Repository;
import com.visithraa23.travelassistance.util.UtilClass;

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

		SignupServlet signupServlet = new SignupServlet();

		if (UtilClass.isValidName(firstName)) {
			if (UtilClass.isValidName(lastName)) {
				if (UtilClass.isValidEmail(email)) {
					if (UtilClass.isValidPhoneNumber(phone)) {
						if (UtilClass.isValidPassword(password)) {
							signupServlet.addUser(user,request,response);
						} else {
							signupServlet.requestDispatcher("Enter Valid Password", request, response);
						}
					} else {
						signupServlet.requestDispatcher("Enter Valid PhoneNumber", request, response);
					}
				} else {
					signupServlet.requestDispatcher("Enter Valid Email", request, response);
				}
			} else {
				signupServlet.requestDispatcher("Enter Valid LastName", request, response);
			}
		} else {
			signupServlet.requestDispatcher("Enter Valid FirstName", request, response);
		}

	}

	private void addUser(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean userExists = repository.checkIfUserPresent(user);
		if (userExists) {
			request.setAttribute("signupMessage", "User Already Exist");
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("signup.jsp");
			reqDispatcher.forward(request, response);
		} else {
			boolean signupSuccess = repository.addUser(user);
			if (signupSuccess) {
				request.setAttribute("signupMessage", "Signup Successful");
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("home.jsp");
				reqDispatcher.forward(request, response);
			} else {
				request.setAttribute("signupMessage", "Signup not Successful Try Later..");
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("home.jsp");
				reqDispatcher.forward(request, response);
			}
		}

	}

	private void requestDispatcher(String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("signupMessage", message);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("signup.jsp");
		reqDispatcher.forward(request, response);
	}

}
