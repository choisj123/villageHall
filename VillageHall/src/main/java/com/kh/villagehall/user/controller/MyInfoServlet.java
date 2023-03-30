package com.kh.villagehall.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.villagehall.user.model.service.UserService;

@WebServlet("/mypage/myInfo")
public class MyInfoServlet extends HttpServlet{
	
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/mypage/myPage.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
