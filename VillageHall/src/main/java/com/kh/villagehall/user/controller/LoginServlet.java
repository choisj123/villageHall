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

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	
	// 로그인 페이지로 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/user/login.jsp";

		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	// 로그인 기능
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		User user = new User();
		
		try {
			
			UserService service = new UserService();
			
			User loginUser = service.login(user);
			
			// Session 객체 얻어오기
			HttpSession session = req.getSession();
			
			if(loginUser != null) { // 로그인 성공시
				
				// 회원 정보 session 세팅
				session.setAttribute("loginUser", loginUser);
				
				// 3600초동안 요청없으면 세션 만료
				session.setMaxInactiveInterval(3600);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
