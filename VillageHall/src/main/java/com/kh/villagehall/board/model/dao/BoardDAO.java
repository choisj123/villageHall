package com.kh.villagehall.board.model.dao;

import static com.kh.villagehall.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.villagehall.board.model.vo.Board;

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
								
				boardList.add(board);	
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}

}
