package edu.kh.villagehall.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		String path = "/WEB-INF/views/user/login.jsp";
=======

		String path = "/WEB-INF/views/user/login.jsp";

>>>>>>> 040e9c8af860ee46287f8705e2551b88e8166051
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
