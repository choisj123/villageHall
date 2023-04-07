package com.kh.villagehall.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.board.model.service.BoardService;
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
		
		int result = 0;
	
		try {
			
			double latitude = Double.parseDouble(req.getParameter("latitude"));
			double longitude = Double.parseDouble(req.getParameter("longitude"));
			
			int categoryNo = Integer.parseInt(req.getParameter("category"));
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			System.out.println("writeBoardServlet : " + latitude +longitude ) ;
			  
			// ** 로그인 회원 번호 얻어오기 **
			HttpSession session = req.getSession(); // 세션 얻어오기
	
			// 로그인 정보 얻어오기
			User loginUser = (User)( session.getAttribute("loginUser") ) ;
  			
			int userNo = loginUser.getUserNo(); // 로그인 회원 번호
			
			Board board = new Board();
			  
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setCategoryNo(categoryNo);
			board.setUserNo(userNo);
			board.setLatitude(latitude);
			board.setLongtitude(longitude);
			
			System.out.println(latitude);
			System.out.println(longitude);
			
			BoardService service = new BoardService();
			  
			result = service.insertBoard(board);
  	
			
			String path = null; 
		
			
			if(result > 0) {
				
				int boardNo = service.getBoardNo(board);
				
				path = req.getContextPath() + "/board/boardDetail?boardNo=" + boardNo;
				
			}else {
				
				session.setAttribute("message", "게시글 등록을 실패했습니다. 잠시 후 다시 시도해주세요." );
				
				path =  req.getContextPath() + "/board/writeBoard";
				
			}
			
			req.setAttribute("board", board);
//			req.getRequestDispatcher(path).forward(req, resp);
			resp.sendRedirect(path);
//			resp.getWriter().print(result);
			
	
			
			
			
		}catch(Exception e) {
			System.out.println("WriteBoardServlet 수행 중 에러 발생");
			e.printStackTrace();
		}
		
	
	
	}
}
