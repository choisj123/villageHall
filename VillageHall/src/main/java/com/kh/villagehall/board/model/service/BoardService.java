package com.kh.villagehall.board.model.service;

import static com.kh.villagehall.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.villagehall.board.model.dao.BoardDAO;
import com.kh.villagehall.board.model.vo.Board;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
	/** 내글 목록 조회 Service
	 * @param userNo 
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMyBoard(int userNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectMyBoard(conn, userNo);
		
		return boardList;
	}

	/** 내좋아요 목록 조회 Service
	 * @param userNo 
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMyLike(int userNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectMyLike(conn, userNo);
		
		return boardList;
	}

	/** 전체 게시글 목록 조회 Service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoard() throws Exception {

		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectAllBoard(conn);
		
		return boardList;
	}

}
