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

@WebServlet("/user/signUp")
public class SignUpServlet extends HttpServlet {
	
	

	// GET 방식 요청 시 JSP로 바로 응답할 수 있도록 요청 위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/user/signUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	// POST 방식 요청 시 회원가입 서비스 수행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 파라미터를 모두 변수에 저장
		String userEmail = req.getParameter("userEmail");
		String userPw = req.getParameter("userPw");
		String userNickname = req.getParameter("userNickname");
		String userTel = req.getParameter("userTel");
		
		// 주소는 3개의 input으로 이루어져 있으므로 배열로 전달 받음
		// -> DB 컬럼을 1개이므로 배열을 하나의 문자열로 합칠 예정
		String[] address = req.getParameterValues("userAddress");
		
		// 주소가 입력되지 않으면 null이 아니라 빈칸 3개
		
		String userAddress = null;
		
		if(!address[0].equals("")) { // 우편번호가 빈칸이 아니라면 == 주소 작성
			userAddress = String.join(",,", address);
			
			// String.join("구분자", 배열)
			// -> 배열 요소를 하나의 문자열로 반환
			//    요소 사이에 "구분자" 추가
		}
		
		
		// 파라미터를 하나의 Member 객체에 저장
		User user = new User();
		
		user.setUserEmail(userEmail);
		user.setUserPw(userPw);
		user.setUserNickname(userNickname);
		user.setUserTel(userTel);
	
		
		
		try {
			
			UserService service = new UserService();
			
			// 회원가입 서비스 호출 후 결과 반환 받기
			int result = service.signUp(user);
			
			// 서비스 결과에 따라서 message를 다르게하여 메인 페이지 재요청(redirect)
			
			HttpSession session = req.getSession();
			
			if(result > 0) { // 성공
				session.setAttribute("message", "회원 가입 성공!!");
				
			}else { // 실패
				session.setAttribute("message", "회원 가입 실패...");
				
			}
			
			resp.sendRedirect( req.getContextPath() );
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
}

