package com.kh.villagehall.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.common.MyRenamePolicy;
import com.kh.villagehall.user.model.service.UserService;
import com.kh.villagehall.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/user/pwFindEmail")
public class PwFindEmailServlet extends HttpServlet{
	
	UserService service = new UserService();
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/pwFindEmail.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	// 파라미터를 모두 변수에 저장
	String userEmail = req.getParameter("userEmail");
	String userPw = req.getParameter("userPw");

	// 파라미터를 하나의 Member 객체에 저장
	User user = new User();
	
	user.setUserEmail(userEmail);
	user.setUserPw(userPw);

	
	
	try {
		
		UserService service = new UserService();
		
		// 회원가입 서비스 호출 후 결과 반환 받기
		int result = service.pwFind(user);
		
		// 서비스 결과에 따라서 message를 다르게하여 메인 페이지 재요청(redirect)
		
		//HttpSession session = req.getSession();
		
		resp.setContentType("text/html; charset=UTF-8");
 		PrintWriter out = resp.getWriter();
		
		if(result > 0) { // 성공
			out.println("<script>alert('비밀번호 변경이 완료되었습니다.');location.href='login';</script>");
			out.flush();
			
		}else { // 실패
			
			out.println("<script>alert('비밀번호 변경이 실패하였습니다.') location.href='pwFindEmail';</script>");
			out.flush();
		}
		
		resp.sendRedirect( req.getContextPath() );
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	

}



}
