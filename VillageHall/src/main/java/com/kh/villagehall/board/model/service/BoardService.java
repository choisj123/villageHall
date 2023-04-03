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

  /** 카카오맵 조회 service
	 * @return kakaoMapList
	 * @throws Exception
	 */
	public List<Board> kakaoMapBoard() throws Exception{
		Connection conn = getConnection();
		
		List<Board>kakaoMapList = dao.kakaoMapBoard(conn);
		
		close(conn);
		
		return kakaoMapList;
	}
	


	/** FAQ 게시글 조회 service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectFAQBoard() throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectFAQBoard(conn);
		
		close(conn);
		
		return boardList;
	}
  
  
  /** 공지사항 게시글 조회 service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectNoticeBoard() throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectNoticeBoard(conn);
		
		close(conn);
		
		return boardList;
	}


	/** 조회수 증가 service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateRead(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateRead(conn, boardNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
  

	/** 좋아요 유무 확인 서비스
	 * @param userNo
	 * @param boardNo
	 * @return count
	 * @throws Exception
	 */
	public int selectLike(int userNo, int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		int count = dao.selectLike(conn, userNo, boardNo);
		
		close(conn);
		
		return count;
	}
  
	
	/** 좋아요 업데이트 서비스 
	 * @param userNo
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateLike(int userNo, int boardNo) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.updateLike(conn, userNo, boardNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
  

	/** 좋아요 취소 DAO
	 * @param userNo
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteLike(int userNo, int boardNo) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.deleteLike(conn, userNo, boardNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		return result;
	}

	/** 게시글 삭제 DAO
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		return result;
	}


}
