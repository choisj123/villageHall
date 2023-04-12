package com.kh.villagehall.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.user.model.service.UserService;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/user/kakaoSignUp")
public class KakaoSignUpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/kakaoSignUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("servlet");
		
		String userEmail = req.getParameter("userEmail");
		String userNickname = req.getParameter("userNickname");
		String kakaoUserKey = req.getParameter("kakaoUserKey");
		
		userEmail = userEmail.replaceAll("\"","");
		userNickname = userNickname.replaceAll("\"","");
		
		
		User user = new User();
		
		user.setUserEmail(userEmail);
		user.setUserPw("z4PhNX7vuL3xVChQ1m2AB9Yg5AULVxXcg/SpIdNs6c5H0NE8XYXysP+DGNKHfuwvY7kxvUdBeoGlODJ6+SfaPg==");
		user.setUserNickname(userNickname);
		user.setKakaoUserKey(kakaoUserKey);
		
		
		
		System.out.println(userEmail);
		System.out.println(userNickname);
		System.out.println(kakaoUserKey);
		
try {
			
			UserService service = new UserService();
			
			// 회원가입 서비스 호출 후 결과 반환 받기
			int result = service.kakaoSignUp(user);
			
			// 서비스 결과에 따라서 message를 다르게하여 메인 페이지 재요청(redirect)
			
			//HttpSession session = req.getSession();	
			
			resp.setContentType("text/html; charset=UTF-8");
	 		PrintWriter out = resp.getWriter();
	 		
	 		if(kakaoUserKey != null) {
	 			
	 			out.println("<script>alert('이미 가입된 회원입니다. 로그인을 진행해주시기 바랍니다.');location.href='login';</script>");
				out.flush();
				
	 		}
			
			
			if(result > 0) { // 성공
				
				out.println("<script>alert('가입이 완료되었습니다. 환영합니다!');location.href='login';</script>");
				out.flush();
				
							
			}else { // 실패
				
				out.println("<script>alert('가입이 실패하였습니다.') location.href='signUp';</script>");
				out.flush();
			
			}
			
			resp.sendRedirect( req.getContextPath() );
			
		}catch (Exception e) {
			System.out.println("SignUpServlet에서 예외 발생");
			e.printStackTrace();
		}
				
	}

}
