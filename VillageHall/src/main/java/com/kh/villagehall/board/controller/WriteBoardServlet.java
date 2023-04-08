package com.kh.villagehall.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.villagehall.board.model.service.BoardService;
import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.common.MyRenamePolicy;
import com.kh.villagehall.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

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
		
int maxSize = 1024 * 1024 * 20;
		
		HttpSession session = req.getSession(); // session 얻어오는 것은 지장없음(사용 가능)
		
		// 최상위 경로( "/" == webapp 폴더)의 컴퓨터상의 실제 절대 경로를 얻어옴.
		String root = session.getServletContext().getRealPath("/");
		
		// 실제 파일이 저장되는 폴더의 경로
		String folderPath = "/resources/images/boardImg/";
		
		// userProfile 폴더 까지의 절대경로
		String filePath = root + folderPath;

		String encoding = "UTF-8";
		
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        
        MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
        
        
		System.out.println( mpReq.getOriginalFileName("file")  );
		
		// getFilesystemName("input type='file'의 name 속성 값")
		// -> 변경된 파일명
		System.out.println( mpReq.getFilesystemName("file") );
        
        
   
		
        String boardImg = folderPath + mpReq.getFilesystemName("file");
		
		int result = 0;
	
		try {
			
			
			System.out.println("servlet : " + req.getParameter("latitude"));
			System.out.println("servlet : " + req.getParameter("longitude"));
			
//			double latitude = Double.parseDouble(req.getParameter("latitude"));
//			double longitude = Double.parseDouble(req.getParameter("longitude"));
				
			
			int categoryNo = Integer.parseInt(req.getParameter("category"));
			System.out.println(categoryNo);
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
//			System.out.println("writeBoardServlet : " + latitude +longitude ) ;
			  
			// ** 로그인 회원 번호 얻어오기 **
	
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
	
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("file")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
	
	

}
