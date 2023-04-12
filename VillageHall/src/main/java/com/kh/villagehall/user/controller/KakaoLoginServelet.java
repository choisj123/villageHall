package com.kh.villagehall.user.controller;

import java.io.IOException;

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
		
		String userEmail = req.getParameter("userEmail");
		
		userEmail = userEmail.replaceAll("\"","");
		
		
		

		User user = new User();
		user.setUserEmail(userEmail);
		user.setUserPw("z4PhNX7vuL3xVChQ1m2AB9Yg5AULVxXcg/SpIdNs6c5H0NE8XYXysP+DGNKHfuwvY7kxvUdBeoGlODJ6+SfaPg==");
		
		
		try {  
		
			 
			UserService service = new UserService();
			
			User loginUser = service.login(user);
			
			HttpSession session = req.getSession();
			
		
			System.out.println("로그인2" + loginUser);
			
			if(loginUser != null) {
				
				
				session.setAttribute("loginUser", loginUser);
				
				session.setMaxInactiveInterval(3600);
				
				
				
				
				 
			} else {
	
				session.setAttribute("message", "실패");
			}
			
			
			
			// redirect
			resp.sendRedirect(req.getContextPath());

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
