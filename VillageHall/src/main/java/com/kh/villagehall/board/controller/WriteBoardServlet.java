package com.kh.villagehall.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/writeBoard")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 100 // 100MB
)
public class WriteBoardServlet extends HttpServlet {

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
				
			}
			String path = "/WEB-INF/views/board/writeBoard.jsp";
		
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		

		// 파일을 저장할 경로
	    String uploadPath = req.getServletContext().getRealPath("/resources/images/boardImg");
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }
	    // 파일 업로드 처리
	    MultipartRequest multi = new MultipartRequest(
	            req, // HttpServletRequest
	            uploadPath, // 저장할 디렉토리 경로
	            10 * 1024 * 1024, // 최대 업로드 파일 크기 (10MB)
	            "UTF-8", // 인코딩
	            new DefaultFileRenamePolicy() // 중복된 파일명 처리
	    );

	    // 업로드된 파일 정보 가져오기
	    File file = multi.getFile("file");

	    // 파일 저장 후 파일 경로 반환
	    String savedFilePath = null;
	    if (file != null) {
	        String originalFilename = multi.getOriginalFileName("file"); // 원래 파일명
	        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // 확장자
	        String savedFilename = UUID.randomUUID() + "." + extension; // 저장할 파일명
	        File savedFile = new File(uploadPath, savedFilename); // 저장할 파일 객체
	        file.renameTo(savedFile); // 업로드된 파일을 저장할 파일로 이동
	        savedFilePath = req.getContextPath() + "/resources/images/boardImg/" + savedFilename; // 저장된 파일의 경로
	    }
	    

		int result = 0;
	
		try {
		
			
//			double latitude = Double.parseDouble(req.getParameter("latitude"));
//			double longitude = Double.parseDouble(req.getParameter("longitude"));
				
			
			int categoryNo = Integer.parseInt(req.getParameter("category"));
			System.out.println(categoryNo);
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			  
			// ** 로그인 회원 번호 얻어오기 **
			// 로그인 정보 얻어오기
			User loginUser = (User)( session.getAttribute("loginUser") ) ;
  			
			int userNo = loginUser.getUserNo(); // 로그인 회원 번호
			
			Board board = new Board();
			  
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setCategoryNo(categoryNo);
			board.setUserNo(userNo);
			board.setBoardImg(savedFilePath);
			
			
			BoardService service = new BoardService();
			
			// 모드가 insert일 경우
			String mode = req.getParameter("mode");
			
			if(mode.equals("insert")) {
				
				result = service.insertBoard(board);
				
				String path = null;
				
				if(result > 0) {
					
					int boardNo = service.getBoardNo(board);
					
					path = req.getContextPath() + "/board/boardDetail?boardNo=" + boardNo;
					
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
		}
		
	
	
	
	}
}
