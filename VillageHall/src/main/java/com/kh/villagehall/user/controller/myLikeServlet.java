package com.kh.villagehall.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/mypage/myLike")
public class myLikeServlet extends HttpServlet {
	
	// 좋아요 목록 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그인 객체 불러오기
			User loginUser = (User)req.getSession().getAttribute("loginUser");
			int userNo = loginUser.getUserNo();
				
			String path = "/WEB-INF/views/mypage/myLike.jsp";
			
			// 좋아요 글 목록 데이터 불러오기
			try {
				BoardService service = new BoardService();
				
				List<Board> boardList = service.selectMyLike(userNo);
				
				req.setAttribute("boardList", boardList);
				req.getRequestDispatcher(path).forward(req, resp);
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
}
