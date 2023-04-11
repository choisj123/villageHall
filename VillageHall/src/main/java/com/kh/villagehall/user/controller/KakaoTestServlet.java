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

@WebServlet("/user/kakaoTest")
public class KakaoTestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/kakaoTest.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("servlet");
		
		String userEmail = req.getParameter("userEmail");
		String userNickname = req.getParameter("userNickname");
		
		
		User user = new User();
		
		user.setUserEmail(userEmail);
		user.setUserNickname(userNickname);
		
		System.out.println(userEmail);
		System.out.println(userNickname);
		
		try {
			
			UserService service = new UserService();
			
			// 회원가입 서비스 호출 후 결과 반환 받기
			int result = service.kakaoLogin(userEmail,userNickname);
			
			// 서비스 결과에 따라서 message를 다르게하여 메인 페이지 재요청(redirect)
			
			HttpSession session = req.getSession();
			
			if(result > 0) { // 성공
				session.setAttribute("message", "회원 가입 성공!!");
				
			}else { // 실패
				session.setAttribute("message", "회원 가입 실패...");
				
			}
			
			//resp.sendRedirect( req.getContextPath() );
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	

}
