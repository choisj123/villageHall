package com.kh.villagehall.user.model.service;


import static com.kh.villagehall.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.villagehall.user.model.dao.UserDAO;
import com.kh.villagehall.user.model.vo.User;

public class UserService {
	
	private UserDAO dao = new UserDAO();

	/** 로그인 서비스
	 * @param user
	 * @return loginUser
	 * @throws Exception
	 */
	public User login(User user) throws Exception{
		
		// Connection 얻어오기
		Connection conn = getConnection();
		
		// DAO 수행
		User loginUser = dao.login(conn, user);
		
		// Connection 반환
		close(conn);
		
		// 결과 반환
		return loginUser;
	}
	
	/** 회원가입 Service
	 * @param user
	 * @return result
	 * @throws Exception
	 */
	public int signUp(User user) throws Exception {

		// 1) 커넥션 얻어오기
		Connection conn = getConnection(); // DBCP 에서 얻어옴
				
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.signUp(conn, user);
				
		// 3) 트랜잭션 처리
		// result가 0인 경우 -> DAO return 구문 잘못 작성
				
		if(result > 0)	commit(conn);  
		else			rollback(conn);
				
		// 4) conn 반환(DBCP로 돌려주기)
		close(conn);
				
		// 5) 결과 반환
		return result;
	}

	public int myInfoCheckPw(int userNo, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.myInfoCheckPw(conn, userNo, inputPw);
		
		close(conn);
		
		return result;
	}
	
	
	/** 인증 번호 DB 추가 Service
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 * @throws Exception
	 */
	public int insertCertification(String inputEmail, String cNumber)throws Exception {

		Connection conn = getConnection();
		
		// 1) 입력한 이메일과 일치하는 값이 있으면 수정(UPDATE)
		int result = dao.updateCertification(conn, inputEmail, cNumber);
		
		// 2) 일치하는 이메일이 없는겨우 -> 처음으로 인증번호를 발급 받음 -> 삽입(INSERT)
		if( result == 0 ) {
			result = dao.insertCertification(conn, inputEmail, cNumber);
		}
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	
}
