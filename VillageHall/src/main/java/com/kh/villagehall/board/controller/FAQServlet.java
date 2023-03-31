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

@WebServlet("/board/FAQ")
public class FAQServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/FAQ.jsp";
		// 주소값
		
		try {
		// 서비스 객체 생성
		BoardService service = new BoardService();
		//조회한거 리스트 담을 객체 생성
		List<Board> boardList = service.selectFAQBoard();
		
		req.setAttribute("boardList", boardList);
		// 서비스에 어떤 메서드로 보낼지
		
				
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
