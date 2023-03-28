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
	public User login(User user) throws Exception {

		Connection conn = getConnection();
		
		User loginUser = dao.login(conn, user);
		
		close(conn);
		
		return loginUser;
	}

}
