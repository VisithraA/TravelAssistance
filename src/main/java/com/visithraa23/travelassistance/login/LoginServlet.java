package com.visithraa23.travelassistance.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visithraa23.travelassistance.dto.User;
import com.visithraa23.travelassistance.repository.Repository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Repository repository;

	public LoginServlet() {
		repository = Repository.getInstance();
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User user=new User(email);
		User userPresent=repository.checkIfUserEmailPresent(user);
		if(userPresent!=null) {
			if(userPresent.getPassword().equals(password)) {
				request.setAttribute("loginMessage", "Login Successful");
				RequestDispatcher reqDispatcher= request.getRequestDispatcher("home.jsp");
				reqDispatcher.forward(request, response);
			}
			else {
				request.setAttribute("loginMessage", "Wrong Password");
				RequestDispatcher reqDispatcher= request.getRequestDispatcher("login.jsp");
				reqDispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("loginMessage", "User Not Found");
			RequestDispatcher reqDispatcher= request.getRequestDispatcher("login.jsp");
			reqDispatcher.forward(request, response);
		}
	}

}
