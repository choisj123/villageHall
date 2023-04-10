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
public class WriteBoardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public WriteBoardServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
			// insert / update 구분
			String mode = req.getParameter("mode");
			// insert는 별도 처리없이 위임
			
			//update는 기존 게시글 내용 조회하는 처리 필요
			if(mode.equals("update")) {
				
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				
				BoardService service = new BoardService();
				
				Board board = service.selectBoardDetail(boardNo);
				
				board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\n"));
				
				req.setAttribute("categoryNo", board.getCategoryNo());
				req.setAttribute("board", board);
				
				BoardImgServlet bImg = new BoardImgServlet();
				
			}
			String path = "/WEB-INF/views/board/writeBoard.jsp";
		
			req.setAttribute("mode", mode);
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		BoardService service = new BoardService();

		
		int result = 0;
	
		try {
			
			
//			double latitude = Double.parseDouble(req.getParameter("latitude"));
//			double longitude = Double.parseDouble(req.getParameter("longitude"));
		
			int categoryNo = Integer.parseInt(req.getParameter("category"));
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			  
			// ** 로그인 회원 번호 얻어오기 **
			// 로그인 정보 얻어오기
			User loginUser = (User)( session.getAttribute("loginUser") ) ;
  			
			int userNo = loginUser.getUserNo(); // 로그인 회원 번호
			
			
			//content에 있는 img 태그 내 src를 선택해 image url 목록 반환 받기
			String imgUrl = service.getImageList(boardContent);
			
			
			Board board = new Board();
			  
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setCategoryNo(categoryNo);
			board.setUserNo(userNo);
			board.setBoardImg(imgUrl);
			System.out.println(imgUrl);
//			System.out.println("board확인용" + board);
			
			
			// 모드가 insert일 경우
			String mode = req.getParameter("mode");
			
			if(mode.equals("insert")) {
				
				result = service.insertBoard(board);
				
				String path = null;
				
				if(result > 0) {
					
					int boardNo = service.getBoardNo(board);
					
					path = req.getContextPath() + "/board/writeBoard?boardNo=" + boardNo;
					
				}else {
					
					session.setAttribute("message", "게시글 등록을 실패했습니다. 잠시 후 다시 시도해주세요." );
					
					path =  req.getContextPath() + "/board/writeBoard.jsp";
					
				}
				
				req.setAttribute("board", board);
//							req.getRequestDispatcher(path).forward(req, resp);
				resp.sendRedirect(path);
//							resp.getWriter().print(result);
			}
			
			
			if(mode.equals("update")) {
				
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				
				board.setBoardNo(boardNo);
				
				result = service.updateBoard(board);
				
				String path = null;
				
				if(result > 0) {
					path = req.getContextPath() + "/board/boardDetail?boardNo=" + boardNo;
				} else {
					
					session.setAttribute("message", "게시글 수정에 실패했습니다. 잠시 후 다시 시도해주세요." );
					
					path =  req.getContextPath() + "/board/writeBoard?boardNo=" + boardNo;
					
				}
				
				req.setAttribute("board", board);
//							req.getRequestDispatcher(path).forward(req, resp);
				resp.sendRedirect(path);
//							resp.getWriter().print(result);
				
			}
			
		}catch(Exception e) {
			System.out.println("WriteBoardServlet 수행 중 에러 발생");
			e.printStackTrace();
			
			String message = "파일 서버 업로드 과정에서 에러 발생";
			
//			path = "/WEB-INF/views/common/errorPage.jsp";
			req.setAttribute("message", message);
		}
		
	
	
	
	}
}