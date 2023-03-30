package com.kh.villagehall.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;

@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {

	// 게시글 조회 기능
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/board/boardDetail.jsp";
		// 파라미터 얻어오기
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		try {
			BoardService service = new BoardService();
			
			Board board = service.selectBoardDetail(boardNo);
			
			req.setAttribute("board", board);
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
