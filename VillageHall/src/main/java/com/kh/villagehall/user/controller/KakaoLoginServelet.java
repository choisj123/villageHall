package com.kh.villagehall.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.user.model.service.UserService;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/user/kakaoLogin")
public class KakaoLoginServelet extends HttpServlet {
	
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/login.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String kakaoUserKey = req.getParameter("kakaoUserKey");

	
		try {  
			

			UserService service = new UserService();
			
			User loginUser = service.kakaoLogin(kakaoUserKey);
			
			HttpSession session = req.getSession();
			
			System.out.println("로그인" + loginUser);
		
			if(loginUser != null) {
				
				
				session.setAttribute("loginUser", loginUser);
				
				session.setMaxInactiveInterval(3600);


			} else {
	
				session.setAttribute("message", "가입된 회원이 아닙니다.");
				
			}

			// redirect
			//resp.sendRedirect(req.getContextPath());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
