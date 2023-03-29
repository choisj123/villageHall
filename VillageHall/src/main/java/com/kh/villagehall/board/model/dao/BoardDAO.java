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
				
				boardList.add(board);				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}

	public List<Board> kakaoMap(Connection conn) {
		
		List<Board> kakaoBoardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("kakaoMap");
		}
		return null;
	}

}
