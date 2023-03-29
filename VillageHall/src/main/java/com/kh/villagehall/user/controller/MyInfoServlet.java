package com.kh.villagehall.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.villagehall.user.model.service.UserService;
import com.kh.villagehall.user.model.vo.User;


@WebServlet("/mypage/myPage")
public class MyInfoServlet extends HttpServlet {
	
	UserService service = new UserService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/mypage/myInfo.jsp";
				
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = null;
		
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		
		int userNo = loginUser.getUserNo();
		String inputPw = req.getParameter("inputPw");
		
		int result = 0;
		
		try {
			
			result = service.myInfoCheckPw(userNo, inputPw);
			
			
			if(result == 1) {
				
				path = "/WEB-INF/views/mypage/myInfo.jsp";
				
			}else {
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	
		req.getRequestDispatcher(path).forward(req, resp);
	
	
	}
	
}


