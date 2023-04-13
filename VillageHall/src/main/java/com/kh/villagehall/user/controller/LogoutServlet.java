package com.kh.villagehall.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그아웃
@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// session scope에 세팅된 회원 정보 삭제
		
		// session 얻어오기
		HttpSession session = req.getSession();
		
		// session 전체를 없애고 새로운 session 생성
		session.invalidate();
		
		// 메인페이지로 돌아가기
		
		String referer = req.getHeader("referer"); // 이전 페이지의 URL가져오기
	    if (referer != null && !referer.isEmpty()) {
	        resp.sendRedirect(referer); // 이전 페이지로 리다이렉트
	    } else {
	        resp.sendRedirect(req.getContextPath()); // 이전 페이지 URL이 없으면 기본 페이지로 이동
	    }

	}
}
