package com.kh.villagehall.board.model.dao;

import static com.kh.villagehall.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.board.model.vo.Pagination;
import com.kh.villagehall.comment.model.vo.Comment;

public class BoardDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/com/kh/villagehall/sql/board-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 내글 목록 조회 DAO
	 * @param conn
	 * @param userNo 
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMyBoard(Connection conn, int userNo) throws Exception {

		List<Board> boardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectMyBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardCreateDate(rs.getString(3));
				board.setReadCount(rs.getInt(4));
				board.setLikeCount(rs.getInt(5));
				board.setCategoryName(rs.getString(6));
				
				boardList.add(board);				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	
	/** 내좋아요 목록 조회 DAO
	 * @param conn
	 * @param userNo 
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMyLike(Connection conn, int userNo) throws Exception {
		List<Board> boardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectMyLike");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardCreateDate(rs.getString(3));
				board.setUserNickname(rs.getString(4));
				board.setReadCount(rs.getInt(5));
				board.setLikeCount(rs.getInt(6));
				board.setCategoryName(rs.getString(7));
								
				boardList.add(board);				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	
	/** 전체글 조회 DAO
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectAllBoard(Connection conn) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectAllBoard");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardCreateDate(rs.getString(3));
				board.setUserNickname(rs.getString(4));
				board.setReadCount(rs.getInt(5));
				board.setLikeCount(rs.getInt(6));
				board.setCategoryName(rs.getString(7));
								
				boardList.add(board);	
			}

			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}
	
	/** 인기글 게시판 조회 DAO
	 * @param conn
	 * @param sortBy
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectPopularBoard(Connection conn, String sortBy) throws Exception {
		// 리스트 객체 생성
		List<Board> boardList = new ArrayList<>();
				
		try {
			
			String sql = "";
			
			if(sortBy.equals("read")) {
				sql = prop.getProperty("sortByReadCount");
			} else if(sortBy.equals("like")) {
				sql = prop.getProperty("sortByLikeCount");
			}
			
			
					
			stmt = conn.createStatement();
			
			
					
			rs = stmt.executeQuery(sql);
					
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt(2));
				board.setBoardTitle(rs.getString(3));
				board.setBoardCreateDate(rs.getString(4));
				board.setUserNickname(rs.getString(5));
				board.setReadCount(rs.getInt(6));
				board.setLikeCount(rs.getInt(7));
				board.setCategoryName(rs.getString(8));
						
				boardList.add(board);
			}
					
			}finally{
				close(rs);
				close(stmt);
			}
		
		return boardList;
	}
	
	/** 게시글 상세조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public Board selectBoardDetail(Connection conn, int boardNo) throws Exception {
		
		Board board = null;
		
		try {
			
			String sql = prop.getProperty("selectBoardDetail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				
				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));				
				board.setBoardContent(rs.getString(3));
				board.setBoardCreateDate(rs.getString(4));
				board.setUserNickname(rs.getString(5));
				board.setReadCount(rs.getInt(6));
				board.setLikeCount(rs.getInt(7));
				board.setCategoryName(rs.getString(8));
				board.setBoardImg(rs.getString(9));
				board.setCategoryNo(rs.getInt(10));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return board;
	}

  
  /** 카카오 맵 DAO
	 * @param conn
	 * @return kakaoMapList;
	 * @throws Exception
	 */
	public List<Board> kakaoMapBoard(Connection conn) throws Exception{
		List<Board> kakaoMapList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("kakaoMapList");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board boardList = new Board();
				
				boardList.setBoardTitle(rs.getString(1));
				boardList.setBoardContent(rs.getString(2));
				boardList.setBoardCreateDate(rs.getString(3));
				boardList.setLatitude(rs.getDouble(4));
				boardList.setLongtitude(rs.getDouble(5));
				boardList.setCategoryName(rs.getString(6));

				boardList.setUserNickname(rs.getString(7));
				boardList.setBoardNo(rs.getInt(8));
				
				kakaoMapList.add(boardList);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return kakaoMapList;
	}



  /** FAQ 게시글 조회 DAO
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectFAQBoard(Connection conn) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectFAQBoard");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardTitle(rs.getString(1));
				board.setBoardContent(rs.getString(2));
				
				boardList.add(board);
			}
			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}
  
  

	
  

	/** 조회수 증가 dao
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateRead(Connection conn, int boardNo) throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("updateRead");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
  

	/** 좋아요 유무 확인 dao
	 * @param conn
	 * @param userNo
	 * @param boardNo
	 * @return count
	 * @throws Exception
	 */
	public int selectLike(Connection conn, int userNo, int boardNo) throws Exception {

		int count = 0;
		
		try {
			String sql = prop.getProperty("selectLike");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}
  
	
	/** 좋아요 업데이트 DAO
	 * @param conn
	 * @param userNo
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateLike(Connection conn, int userNo, int boardNo) throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("updateLike");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

	/** 좋아요 취소 dao
	 * @param conn
	 * @param userNo
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteLike(Connection conn, int userNo, int boardNo) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteLike");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 게시글 삭제 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	public List<Board> kakaoMapBoardRecent(Connection conn) throws Exception{
		
		List<Board> kakaoBoardRecent = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("kakaoMapBoardRecent");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board boardList = new Board();
				
				boardList.setBoardTitle(rs.getString(1));
				boardList.setBoardCreateDate(rs.getString(2));
				boardList.setCategoryName(rs.getString(3));
				boardList.setUserNickname(rs.getString(4));
				boardList.setBoardNo(rs.getInt(5));
				boardList.setBoardImg(rs.getString(6));
				
				kakaoBoardRecent.add(boardList);
			}
			System.out.println(kakaoBoardRecent);
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return kakaoBoardRecent;
	}

	
	/** 게시글 내 댓글 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectAllComment(Connection conn, int boardNo) throws Exception {

		List<Comment> commentList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectAllComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setCommentNo(rs.getInt(1));
				comment.setProfileImg(rs.getString(2));
				comment.setUserNickname(rs.getString(3));
				comment.setCommentContent(rs.getString(4));
				comment.setCommentCreateDate(rs.getString(5));
				
				commentList.add(comment);				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return commentList;
	
	}
  
	
	/** 게시글 등록 DAO
	 * @param conn
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board board) throws Exception{
		int result = 0;
		
		
		try {
			String sql = prop.getProperty("insertBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
//			pstmt.setDouble(3, board.getLatitude());
//			pstmt.setDouble(4, board.getLongtitude());
			
			pstmt.setInt(3, board.getCategoryNo());
			pstmt.setInt(4, board.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	
	/** 게시글 등록 - 게시글 번호 얻어오기 
	 * @param conn
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int getBoardNo(Connection conn, Board board) throws Exception{
		int boardNo = 0;
	
		try {
			
			String sql = prop.getProperty("getBoardNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getCategoryNo());
			pstmt.setInt(4, board.getUserNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardNo = rs.getInt(1);
			}
		
			
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return boardNo;
	}

	/** 메인페이지 인기글 목록 조회 dao
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMainPagePopularBoard(Connection conn) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectMainPagePopularBoard");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt(2));
				board.setBoardTitle(rs.getString(3));
				board.setReadCount(rs.getInt(4));
				
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}

	/** 메인페이지 공지사항 목록 조회 dao
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMainPageNotice(Connection conn) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectMainPageNotice");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt(2));
				board.setBoardTitle(rs.getString(3));
				board.setReadCount(rs.getInt(4));
				
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}

	/** 특정 게시판 전체 게시글 수 조회 DAO
	 * @param conn
	 * @param category
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int category) throws Exception{
		int listCount = 0;
		
		try {
			
			String sql = prop.getProperty("getListCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, category);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/** 특정 게시판에서 일정한 범위의 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param category
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination, int category) throws Exception {
		// 리스트 객체 생성
		List<Board> boardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectBoardList");
			
			// BETWEEN 구문에 들어갈 범위 계산
			int start =  ( pagination.getCurrentPage() - 1 ) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			if(category == 1 || category == 2) {
				pstmt.setInt(1, category);
			} else {
				String category2 = "3,4,5,6,7,8";
				pstmt.setString(1, category2);
			}
			
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
												
				board.setBoardNo(rs.getInt(2));
				board.setBoardTitle(rs.getString(3));
				board.setBoardCreateDate(rs.getString(4));
				board.setUserNickname(rs.getString(5));				
				board.setReadCount(rs.getInt(6));
				board.setLikeCount(rs.getInt(7));
				board.setCategoryName(rs.getString(8));
				
				boardList.add(board);
			}
			
		  }finally{
			  close(rs);
			  close(pstmt);
		  }
      return boardList;
	}
	
	public int searchListCount(Connection conn, int category, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateBoard(Connection conn, Board board) throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("updateBoard");
			
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setDouble(3, board.getLatitude());
			pstmt.setDouble(4, board.getLongtitude());
			pstmt.setInt(5, board.getCategoryNo());
			pstmt.setString(6, board.getBoardImg());
			pstmt.setInt(7, board.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 댓글 등록 DAO
	 * @param conn
	 * @param comment
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(Connection conn, Comment comment) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, comment.getCommentContent());
			pstmt.setInt(2, comment.getUserNo());
			pstmt.setInt(3, comment.getBoardNo());
			
			result = pstmt.executeUpdate();			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 댓글 삭제 DAO
	 * @param conn
	 * @param comment
	 * @return result
	 * @throws Exception
	 */
	public int deleteComment(Connection conn, Comment comment) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, comment.getUserNo());
			pstmt.setInt(2, comment.getBoardNo());
			pstmt.setInt(3, comment.getCommentNo());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	


}
