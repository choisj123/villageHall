package com.kh.villagehall.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.user.model.vo.User;

@WebServlet("/board/writeBoard")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1MB
	    maxFileSize = 1024 * 1024 * 50, // 50MB
	    maxRequestSize = 1024 * 1024 * 100 // 100MB
	)
public class WriteBoardServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/board/writeBoard.jsp";
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
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 req.setCharacterEncoding("UTF-8");
	     resp.setContentType("text/html;charset=UTF-8");
	 
	     Part part = req.getPart("file");
	     String fileName = getFileName(part);
	     String realPath = req.getSession().getServletContext().getRealPath("/resources/images/boardImg/");
	     String filePath = realPath + File.separator + fileName;
	     part.write(fileName);
		
		int result = 0;
	
		try {
			
			
			System.out.println("servlet : " + req.getParameter("latitude"));
			System.out.println("servlet : " + req.getParameter("longitude"));
			
			double latitude = Double.parseDouble(req.getParameter("latitude"));
			double longitude = Double.parseDouble(req.getParameter("longitude"));
				
			
			int categoryNo = Integer.parseInt(req.getParameter("category"));
			System.out.println(categoryNo);
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			System.out.println("writeBoardServlet : " + latitude +longitude ) ;
			  
			// ** 로그인 회원 번호 얻어오기 **
			HttpSession session = req.getSession();
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
			board.setBoardImg(filePath);
			
			
			BoardService service = new BoardService();
			
			// 모드가 insert일 경우
			String mode = mpReq.getParameter("mode");
			
			if(mode.equals("insert")) {
				
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
//				req.getRequestDispatcher(path).forward(req, resp);
				resp.sendRedirect(path);
//				resp.getWriter().print(result);
			}
			
			
			if(mode.equals("update")) {
				
				int boardNo = Integer.parseInt(mpReq.getParameter("boardNo"));
				
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
//				req.getRequestDispatcher(path).forward(req, resp);
				resp.sendRedirect(path);
//				resp.getWriter().print(result);
				
			}
			
		}catch(Exception e) {
			System.out.println("WriteBoardServlet 수행 중 에러 발생");
			e.printStackTrace();
		}
		
	
	
	}
	
    private String getFileName(Part part) {
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";

    }
}
