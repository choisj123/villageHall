package com.kh.villagehall.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/mypage/myBoard")
public class MyBoardServlet extends HttpServlet {
	
	// 내글목록 페이지 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그인 객체 불러오
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		int userNo = loginUser.getUserNo();
		
		String path = "/WEB-INF/views/mypage/myBoard.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		// 내글목록 데이터 불러오기
		try {
			BoardService service = new BoardService();
			
			List<Board> boardList = service.selectMyBoard(userNo);
			System.out.println(boardList);
			
			new Gson().toJson(boardList, resp.getWriter());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
