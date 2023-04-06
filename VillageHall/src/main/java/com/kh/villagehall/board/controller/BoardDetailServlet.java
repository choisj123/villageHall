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
import com.kh.villagehall.comment.model.vo.Comment;
import com.kh.villagehall.user.model.vo.User;

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
			
			// 게시글 정보 받아오기
			Board board = service.selectBoardDetail(boardNo);
			
			// 댓글 정보 받아오기
			List<Comment> commentList = service.selectAllComment(boardNo);
			
			// 내글이아닌 게시글 조회시 조회수 증가	(아직전체증가 미완성)					
			int result = service.updateRead(boardNo);
				
				
			req.setAttribute("board", board);
			req.setAttribute("commentList", commentList);
			req.getRequestDispatcher(path).forward(req, resp);
			
				
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
