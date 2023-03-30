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

@WebServlet("/board/popularBoard")
public class PopularBoardServlet extends HttpServlet {
	
	// 인기글 조회 기능
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/popularBoard.jsp";
		
		try {
			BoardService service = new BoardService();
			
			List<Board> boardList = service.selectAllBoard();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
