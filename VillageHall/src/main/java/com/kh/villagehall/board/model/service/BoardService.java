package com.kh.villagehall.board.model.service;

import static com.kh.villagehall.common.JDBCTemplate.close;
import static com.kh.villagehall.common.JDBCTemplate.commit;
import static com.kh.villagehall.common.JDBCTemplate.getConnection;
import static com.kh.villagehall.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.villagehall.board.model.dao.BoardDAO;
import com.kh.villagehall.board.model.vo.Board;
import com.kh.villagehall.board.model.vo.Pagination;
import com.kh.villagehall.comment.model.vo.Comment;


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
  

	/** 좋아요 유무 확인 service
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
  
	
	/** 좋아요 업데이트 service 
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
  

	/** 좋아요 취소 service
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
		
		close(conn);
		
		return result;
	}

	/** 게시글 삭제 service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** 인기글 조회 service
	 * @param sortBy
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectPopularBoard(String sortBy) throws Exception {

		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectPopularBoard(conn, sortBy);
		
		close(conn);
		
		return boardList;
	}

	/** 카카오맵 service
	 * @return
	 * @throws Exception
	 */
	public List<Board> kakaoMapBoardRecent()throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> kakaoBoardRecent = dao.kakaoMapBoardRecent(conn);
		
		close(conn);
		
		return kakaoBoardRecent;
	}

	/** 게시글 내 댓글 조회 service
	 * @param boardNo
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectAllComment(int boardNo) throws Exception {

		Connection conn = getConnection();
		
		List<Comment> commentList = dao.selectAllComment(conn, boardNo);
		
		close(conn);
		
		return commentList;
	}


	
	/** 게시글 등록 service
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Board board) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn, board);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	
		
	}

	/** 게시글 등록 후 게시글 번호 얻어오기 service
	 * @param board
	 * @return boardNo
	 * @throws Exception
	 */
	public int getBoardNo(Board board) throws Exception{
		Connection conn = getConnection();
		
		int boardNo = dao.getBoardNo(conn, board);
		
		
		close(conn);
		
		return boardNo;
	}

	/** 메인페이지 인기글 목록 조회 Service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMainPagePopularBoard() throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectMainPagePopularBoard(conn);
		
		close(conn);
		
		return boardList;
	}

	/** 메인페이지 공지사항 목록 조회 Service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectMainPageNotice() throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectMainPageNotice(conn);
		
		close(conn);
		
		return boardList;
	}
	
	/** 게시글 목록 조회 Service
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardList(int type, int cp) throws Exception {
		
		Connection conn = getConnection();
		
		// 게시판 이름 조회 DAO 호출
		String boardName = dao.selectBoardName(conn, type);
		
		// 1. 특정 게시판 전체 게시글 수 조회 DAO 호출
		int listCount = dao.getListCount(conn, type);
		
		// 2. 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
		Pagination pagination = new Pagination(cp, listCount);
		
		// 3. 게시글 목록 조
		List<Board> boardList = dao.selectBoardList(conn, pagination, type);
		
		// 4. Map 객체를 생성하여 1,2 결과 객체를 모두 저장
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		return map; // Map 객체 반
	}
	
	/** 검색 목록 조회 Service
	 * @param category
	 * @param cp
	 * @param key
	 * @param query
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> searchBoardList(int type, int cp, String key, String query) throws Exception {
		
		Connection conn = getConnection();
		
		// 기존 목록 조회 Service, DAO, SQL을 참고하면서 진행
				
		// 1. SQL 조건절에 추가될 구문 가공(key, query 사용)
		String condition = null;// 조건
		
		switch(key) {
		case "t"  : condition = " AND BOARD_TITLE LIKE '%"+query+"%' ";  break;
		case "c"  : condition = " AND BOARD_CONTENT LIKE '%"+query+"%' ";  break;
		case "tc" : condition = " AND (BOARD_TITLE LIKE '%"+query+"%' OR BOARD_CONTENT LIKE '%"+query+"%') ";  break;
		case "w"  : condition = " AND MEMBER_NICK LIKE '%"+query+"%' "; break;
		}
		
		// 3-1. 특정 게시판에서 조건을 만족하는 게시글 수 조회
		int listCount = dao.searchListCount(conn, type, condition);
				
		// 3-2. listCount  + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
		Pagination pagination = new Pagination(cp, listCount);		
		
		
		// 4. 특정 게시판에서 조건을 만족하는 게시글 목록 조회
//		List<Board> boardList = dao.searchBoardList(conn, pagination, category, condition);
		
		// 5. 결과 값을 하나의 Map에 모아서 반환
		Map<String, Object> map = new HashMap<>();
		
		map.put("pagination", pagination);
//		map.put("boardList", boardList);
		
		close(conn);
	
		return map;
	}

	/** 게시글 수정 Service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Board board) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateBoard(conn, board);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** 댓글 등록 Service
	 * @param comment
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(Comment comment) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.insertComment(conn, comment);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 댓글 삭제 Service
	 * @param comment
	 * @return result
	 * @throws Exception
	 */
	public int deleteComment(Comment comment) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.deleteComment(conn, comment);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


}
