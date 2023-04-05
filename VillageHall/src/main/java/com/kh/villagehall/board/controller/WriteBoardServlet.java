package com.kh.villagehall.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/board/writeBoard")
public class WriteBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/board/writeBoard.jsp";
	
	
		req.getRequestDispatcher(path).forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("summernote");
		
		Board board = new Board();
		
		
		// ** 로그인 회원 번호 얻어오기 **
		HttpSession session = req.getSession(); // 세션 얻어오기
		
		// 로그인 정보 얻어오기
		User loginUser = (User)( session.getAttribute("loginUser") ) ;
		
		int userNo = loginUser.getUserNo(); // 로그인 회원 번호
		
		
		board.setBoardTitle(title);
		board.setBoardContent(content);
		board.setCategoryName(category);
		board.setUserNo(userNo);
		
		
		System.out.println(category);
		System.out.println(title);
		System.out.println(content);
	
	
	
	}
}
