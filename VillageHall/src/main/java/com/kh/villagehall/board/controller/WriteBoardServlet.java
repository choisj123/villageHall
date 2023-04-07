package com.kh.villagehall.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/board/writeBoard")
@MultipartConfig(
		   fileSizeThreshold = 1024 * 1024,
		   maxFileSize = 1024 * 1024 * 50,
		   maxRequestSize = 1024 * 1024 * 50 * 5
		)
public class WriteBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/board/writeBoard.jsp";
	
		
		req.getRequestDispatcher(path).forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		    // 파일 저장할 디렉토리 경로
		    String uploadPath = req.getServletContext().getRealPath("/") + "resources/images/boardImg/";
	
		    // 업로드된 파일 정보 받아오기
		    Part filePart = req.getPart("image");
		    String fileName = filePart.getSubmittedFileName();
		    

		    // 파일 저장될 경로 및 이름 설정
		    String savePath = uploadPath + fileName;

		    // 파일 쓰기
		    try (InputStream input = filePart.getInputStream()) {
		        Files.copy(input, Paths.get(savePath), StandardCopyOption.REPLACE_EXISTING);
		    }

		
		
		int result = 0;
	
		try {
			
			
			System.out.println("servlet : " + req.getParameter("latitude"));
			System.out.println("servlet : " + req.getParameter("longitude"));
			
//			double latitude = Double.parseDouble(req.getParameter("latitude"));
//			double longitude = Double.parseDouble(req.getParameter("longitude"));
				
			
			int categoryNo = Integer.parseInt(req.getParameter("category"));
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			String boardImg = "/resources/images/boardImg/" + fileName;  // 저장할 이미지 URL
//			System.out.println("writeBoardServlet : " + latitude +longitude ) ;
			  
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
//			board.setLatitude(latitude);
//			board.setLongtitude(longitude);
			board.setBoardImg(boardImg);
			
			
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
