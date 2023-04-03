package com.kh.villagehall.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.user.model.service.UserService;
import com.kh.villagehall.user.model.vo.User;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/user/login.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	
		User user = new User();
		user.setUserEmail("test@gmail.com");
		user.setUserPw("AWK1nM+CjAOElicQOH742Hgdbvccpnn/sChKmDsie2JcQEGbfWqKblQ4JrLuN2ZtAVwTr3NTJqoC/05NxrR74g==");
		
		
		try {
			UserService service = new UserService();
			
			User loginUser = service.login(user);
			HttpSession session = req.getSession();
			System.out.println(loginUser);
			
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
	
	
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
		// 전달된 파라미터 변수에 저장
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		
		// getParameter() 오버라이딩 확인
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		
		// 파라미터를 VO에 세팅(롬복 확인)
		User user = new User();
		user.setUserEmail(inputEmail);
		user.setUserPw(inputPw);
		
		try {
			
			// 서비스 객체 생성
			UserService service = new UserService();
			
			// 이메일, 비밀번호가 일치하는 회원을 조회하는 서비스 호출 후 결과 반환 받기
			User loginUser = service.login(user);
			
			// 로그인 성공/실패에 따른 처리 코드
			
			// *** 로그인 ***
			// ID/PW가 일치하는 회원 정보를 Session Scope에 세팅 하는 것
			
			// Session 객체 얻어오기
			HttpSession session = req.getSession();
			
			if(loginUser != null) { // 성공
				
				// 회원 정보 Session 세팅
				session.setAttribute("loginUser", loginUser);
				session.setMaxInactiveInterval(3600);
		
			} else { // 실패
				
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			}
			

				
			resp.sendRedirect( req.getContextPath() );

		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	*/
}
