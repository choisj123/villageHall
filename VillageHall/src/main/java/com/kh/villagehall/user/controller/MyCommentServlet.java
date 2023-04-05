package com.kh.villagehall.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.service.CommentService;
import com.kh.villagehall.comment.model.vo.Comment;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/mypage/myComment")
public class MyCommentServlet extends HttpServlet {
	
	// 내글목록 페이지 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그인 객체 불러오기
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		int userNo = loginUser.getUserNo();
		
		String path = "/WEB-INF/views/mypage/myComment.jsp";
		
		
		// 내댓글 목록 데이터 불러오고 저장
		try {
			CommentService service = new CommentService();
			
			List<Comment> commentList = service.selectMyComment(userNo);
			
			req.setAttribute("commentList", commentList);
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
