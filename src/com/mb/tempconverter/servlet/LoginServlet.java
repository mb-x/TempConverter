package com.mb.tempconverter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mb.tempconverter.models.User;

public class LoginServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet - doGet method");
		//PrintWriter out = resp.getWriter();
		//out.println("<html><head></head><body><h1>Hello World !</h1></body></html>");
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet - doPost method");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("Email : "+ email + "  -- Password : " + password);
		if(email.equals("test@test.com") && password.equals("123456")){
			req.getSession().setAttribute("user", new User(email, password));
			resp.sendRedirect("converter");
		}else{
			resp.sendRedirect("login");
		}
	}
}
