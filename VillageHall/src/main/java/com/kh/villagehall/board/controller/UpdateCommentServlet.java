package com.kh.villagehall.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.comment.model.vo.Comment;

@WebServlet("/comment/updateComment")
public class UpdateCommentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String commentContent = req.getParameter("commentContent");
		int commentNo = Integer.parseInt(req.getParameter("commentNo"));
		int userNo = Integer.parseInt(req.getParameter("userNo"));
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		Comment comment = new Comment();
		
		comment.setCommentContent(commentContent);
		comment.setUserNo(userNo);
		comment.setCommentNo(commentNo);
		
		try {
			
			BoardService service = new BoardService();
			
			int result = service.updateComment(comment);
			
			if(result > 0) {
				resp.sendRedirect("/VillageHall/board/boardDetail?boardNo=" + boardNo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
