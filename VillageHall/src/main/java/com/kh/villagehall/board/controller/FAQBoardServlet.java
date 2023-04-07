package com.kh.villagehall.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;

@WebServlet("/board/FAQBoard")
public class FAQBoardServlet extends HttpServlet {
	
	// FAQ게시판 조회 기능
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/FAQBoard.jsp";
		// 주소값
		
		try {
		// 서비스 객체 생성
		BoardService service = new BoardService();
		//조회한거 리스트 담을 객체 생성
		List<Board> boardList = service.selectFAQBoard();
		System.out.println(boardList);
		
		req.setAttribute("boardList", boardList);		
		req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}
}
