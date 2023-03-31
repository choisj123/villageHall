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
		
		close(conn);
		
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
		
		close(conn);
		
		return boardList;
	}

	/** 전체 게시글 목록 조회 Service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoard() throws Exception {

		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectAllBoard(conn);
		
		close(conn);
		
		return boardList;
	}
	
	/** 게시글 상세조회 service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoardDetail(int boardNo) throws Exception {

		Connection conn = getConnection();
		
		Board board = dao.selectBoardDetail(conn, boardNo);
		
		close(conn);
		
		return board;
	}

	public List<Board> selectFAQBoard() throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectFAQBoard(conn);
		
		close(conn);
		
		return boardList;
	}

}
