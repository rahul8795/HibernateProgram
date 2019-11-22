package com.cts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.factory.UserServiceFactory;
import com.cts.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		UserService userService = UserServiceFactory.getUserService();
		String status = userService.checkLogin(uname, upwd);
		
		RequestDispatcher dispatcher = null;
		if(status.equals("success")){
			dispatcher = request.getRequestDispatcher("success.html");
			dispatcher.forward(request, response);
		}else {
			dispatcher = request.getRequestDispatcher("failure.html");
			dispatcher.forward(request, response);
		}
	}

}
