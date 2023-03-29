package com.kh.villagehall.board.model.service;

import static com.kh.villagehall.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.villagehall.board.model.dao.CommentDAO;
import com.kh.villagehall.comment.model.vo.Comment;

public class CommentService {
	
	private CommentDAO dao = new CommentDAO();

	/** 내댓글 목록 조회 Service
	 * @param userNo 
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectMyComment(int userNo) throws Exception {

		Connection conn = getConnection();
		
		List<Comment> commentList = dao.selectMyComment(conn, userNo);
		
		return commentList;
	}

}
