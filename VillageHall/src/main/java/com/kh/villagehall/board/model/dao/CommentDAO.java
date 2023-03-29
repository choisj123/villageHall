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

import com.kh.villagehall.comment.model.vo.Comment;

public class CommentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO() {
		try {
			prop = new Properties();
			
			String filePath = CommentDAO.class.getResource("/com/kh/villagehall/sql/comment-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 내댓글 목록 조회 DAO
	 * @param conn
	 * @param userNo 
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectMyComment(Connection conn, int userNo) throws Exception {

		List<Comment> commentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectMyComment");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment comment = new Comment();
				
				comment.setCommentContent(rs.getString(1));
				comment.setCommentCreateDate(rs.getString(2));
				comment.setBoardTitle(rs.getString(3));
				
				commentList.add(comment);
			}
					
		} finally {
			close(rs);
			close(pstmt);
		}
		return commentList;
	}

}
