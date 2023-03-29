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
		user.setUserEmail(inputEmail);
		user.setUserPw(inputPw);
		
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
				
				// 아이디 저장(쿠키)
				
				//쿠키 객체 생성
				Cookie c = new Cookie("saveId", inputEmail);
				
				// 아이디 저장이 체크된 경우
				if(req.getParameter("saveId") != null) {
					// 쿠키 파일을 30일동안 유지
					c.setMaxAge(60 * 60 * 24 * 30);
				} else {
					// 체크안된경우 0초유지(==삭제)
					c.setMaxAge(0);
				}
				
				// 쿠키파일 적용 주소 지정
				c.setPath(req.getContextPath());// 최상위주소
				
				//응답객체통해 클라이언트로 전달(해석즉시)
				resp.addCookie(c);
			} else { // 실패
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");				
			}
			
			// redirect
			resp.sendRedirect(req.getContextPath());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
