package com.kh.villagehall.board.model.dao;

import static com.kh.villagehall.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.villagehall.board.model.vo.Board;
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
  
  

  /** 공지사항 게시글 조회 DAO
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectNoticeBoard(Connection conn) throws Exception {
		// 리스트 객체 생성
		List<Board> boardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectNoticeBoard");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setRowNo(rs.getInt(1));
				board.setBoardNo(rs.getInt(2));
				board.setBoardTitle(rs.getString(3));
				board.setUserNickname(rs.getString(4));
				board.setBoardCreateDate(rs.getString(5));
				board.setReadCount(rs.getInt(6));
				
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
				comment.setProfileImg(rs.getString(1));
				comment.setUserNickname(rs.getString(2));
				comment.setCommentContent(rs.getString(3));
				comment.setCommentCreateDate(rs.getString(4));
				
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
			pstmt.setDouble(3, board.getLatitude());
			pstmt.setDouble(4, board.getLongtitude());
			
			pstmt.setInt(5, board.getCategoryNo());
			pstmt.setInt(6, board.getUserNo());
			
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


}
