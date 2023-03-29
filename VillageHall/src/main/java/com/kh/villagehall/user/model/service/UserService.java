package com.kh.villagehall.user.model.service;


import static com.kh.villagehall.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.villagehall.user.model.dao.UserDAO;
import com.kh.villagehall.user.model.vo.User;

public class UserService {
	
	private UserDAO dao = new UserDAO();

	/** 로그인 서비스
	 * @param user
	 * @return loginMember
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

	
	
	
	

	
}
