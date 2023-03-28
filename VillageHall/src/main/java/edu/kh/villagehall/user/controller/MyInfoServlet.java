package edu.kh.villagehall.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<<< HEAD:VillageHall/src/main/java/edu/kh/villagehall/user/controller/SignUpServlet.java
@WebServlet("/user/signUp")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/user/signUp.jsp";
========
@WebServlet("/user/myInfo")
public class MyInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/user/myInfo.jsp";
>>>>>>>> 040e9c8af860ee46287f8705e2551b88e8166051:VillageHall/src/main/java/edu/kh/villagehall/user/controller/MyInfoServlet.java
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
